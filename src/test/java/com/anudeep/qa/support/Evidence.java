package com.anudeep.qa.support;

import com.anudeep.qa.config.Config;
import com.anudeep.qa.drivers.Drivers;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class Evidence {
  private static final ObjectMapper JSON = new ObjectMapper();
  private static final ThreadLocal<Context> CURRENT = new ThreadLocal<>();

  static final class Context {
    String id, method, stamp;
    Path folder;
    List<String> observations = new ArrayList<>();
    List<Map<String, Object>> logs = new ArrayList<>();
  }

  private Evidence() {}

  public static void begin(String id, String method) {
    Context c = new Context();
    c.id = id;
    c.method = method;
    c.stamp =
        DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS")
            .withZone(ZoneOffset.UTC)
            .format(Instant.now());
    c.folder = Path.of("artifacts", "runs", c.stamp + "_" + id + "_" + method);
    CURRENT.set(c);
    writeLog("START", "RUNNING", null);
  }

  public static void observe(String message) {
    CURRENT.get().observations.add(message);
    writeLog(message, "OBSERVED", null);
    Allure.step(message);
  }

  public static void writeLog(String action, String result, Throwable error) {
    if (CURRENT.get() == null) return;
    Map<String, Object> row = new LinkedHashMap<>();
    row.put("timestamp", Instant.now().toString());
    row.put("test", CURRENT.get().method);
    row.put("caseId", CURRENT.get().id);
    row.put("action", action);
    row.put("result", result);
    row.put("environment", Config.get("ENVIRONMENT"));
    if (error != null) row.put("exception", error.toString());
    CURRENT.get().logs.add(row);
  }

  public static void checkpoint(String label) {
    if (Config.get("SCREENSHOT_MODE").equals("ALL")) screenshot(label);
  }

  private static void screenshot(String status) {
    Context c = CURRENT.get();
    if (c == null || Drivers.get() == null) return;
    try {
      byte[] bytes = ((TakesScreenshot) Drivers.get()).getScreenshotAs(OutputType.BYTES);
      Files.createDirectories(c.folder);
      String filename =
          c.id
              + "_"
              + c.method
              + "_"
              + status.replaceAll("[^A-Za-z0-9_-]", "_")
              + "_"
              + c.stamp
              + ".png";
      Files.write(c.folder.resolve(filename), bytes);
      Allure.addAttachment(filename, "image/png", new java.io.ByteArrayInputStream(bytes), "png");
    } catch (Exception e) {
      writeLog("SCREENSHOT_CAPTURE_FAILED", status, e);
      Allure.addAttachment("Screenshot capture error", e.toString());
    }
  }

  public static void finish(String status, long duration, Throwable failure) {
    while (failure instanceof java.lang.reflect.InvocationTargetException && failure.getCause() != null) {
      failure = failure.getCause();
    }
    Context c = CURRENT.get();
    if (c == null) return;
    writeLog("COMPLETE", status, failure);
    if (status.equals("FAIL") || Config.get("SCREENSHOT_MODE").equals("ALL")) screenshot(status);
    try {
      Files.createDirectories(c.folder);
      String log = JSON.writerWithDefaultPrettyPrinter().writeValueAsString(c.logs);
      Files.writeString(c.folder.resolve("execution-log.json"), log);
      Allure.addAttachment("Structured execution log", "application/json", log, "json");
      Map<String, Object> record = new LinkedHashMap<>();
      record.put("caseId", c.id);
      record.put("method", c.method);
      record.put("status", status);
      record.put("observations", c.observations);
      record.put("durationMs", duration);
      record.put("timestampUtc", Instant.now().toString());
      record.put("environment", Config.get("ENVIRONMENT"));
      record.put("baseUrl", Config.get("BASE_URL"));
      record.put(
          "gitCommit",
          System.getProperty(
              "GIT_COMMIT", System.getenv().getOrDefault("GIT_COMMIT", "NOT PROVIDED")));
      record.put("applicationBuild", "Not exposed by public demo");
      if (Drivers.get() != null) {
        record.put("url", Drivers.get().getCurrentUrl());
        record.put("browser", ((RemoteWebDriver) Drivers.get()).getCapabilities().asMap());
      }
      if (failure != null) {
        record.put("failure", failure.toString());
        record.put(
            "stackTrace", Arrays.stream(failure.getStackTrace()).map(Object::toString).toList());
        Allure.addAttachment("Failure", failure.toString());
      }
      Files.writeString(
          c.folder.resolve("result.json"),
          JSON.writerWithDefaultPrettyPrinter().writeValueAsString(record));
    } catch (java.io.IOException e) {
      throw new java.io.UncheckedIOException("Cannot persist test evidence", e);
    }
  }

  public static void cleanup(String status, Throwable error) {
    Context c = CURRENT.get();
    if (c == null) return;
    try {
      Files.createDirectories(c.folder);
      Map<String, String> record = new LinkedHashMap<>();
      record.put("status", status);
      if (error != null) record.put("error", error.toString());
      Files.writeString(c.folder.resolve("cleanup.json"), JSON.writeValueAsString(record));
    } catch (java.io.IOException e) {
      throw new java.io.UncheckedIOException(e);
    }
  }

  public static void clear() {
    CURRENT.remove();
  }
}

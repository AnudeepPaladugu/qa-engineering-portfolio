package com.anudeep.qa.drivers;

import com.anudeep.qa.config.Config;
import java.time.Duration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class Drivers {
  private static final ThreadLocal<WebDriver> CURRENT = new ThreadLocal<>();

  private Drivers() {}

  public static void start() {
    if (!Config.get("BROWSER").equalsIgnoreCase("chrome"))
      throw new IllegalArgumentException("Only Chrome is supported in the verified baseline");
    ChromeOptions options = new ChromeOptions();
    if (Config.bool("HEADLESS")) options.addArguments("--headless=new");
    options.addArguments("--window-size=1440,1000");
    options.setPageLoadStrategy(PageLoadStrategy.EAGER);
    WebDriver driver = new ChromeDriver(options);
    CURRENT.set(driver);
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.manage().timeouts().implicitlyWait(Duration.ZERO);
  }

  public static WebDriver get() {
    return CURRENT.get();
  }

  public static void stop() {
    try {
      if (get() != null) get().quit();
    } finally {
      CURRENT.remove();
    }
  }
}

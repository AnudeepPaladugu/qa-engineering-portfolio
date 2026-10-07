package com.anudeep.qa.config;

import java.io.IOException;
import java.util.Properties;

public final class Config {
    private static final Properties DEFAULTS = new Properties();
    static {
        try (var stream = Config.class.getResourceAsStream("/config.properties")) {
            if (stream == null) throw new IllegalStateException("config.properties is missing");
            DEFAULTS.load(stream);
        } catch (IOException e) { throw new ExceptionInInitializerError(e); }
    }
    private Config() { }
    public static String get(String key) {
        String value = System.getProperty(key);
        if (value == null) value = System.getenv(key);
        return value != null ? value : DEFAULTS.getProperty(key, "");
    }
    public static String required(String key) {
        String value = get(key);
        if (value.isBlank() || value.startsWith("REPLACE_")) throw new IllegalStateException("Configure " + key + " before running account tests");
        return value;
    }
    public static boolean bool(String key) {
        String value = get(key);
        if (!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false")) throw new IllegalArgumentException(key + " must be true or false");
        return Boolean.parseBoolean(value);
    }
    public static int waitSeconds() { return Integer.parseInt(get("WAIT_SECONDS")); }
}

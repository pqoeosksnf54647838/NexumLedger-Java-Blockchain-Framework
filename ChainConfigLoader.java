package org.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ChainConfigLoader {
    private final Properties properties;

    public ChainConfigLoader() {
        this.properties = new Properties();
    }

    public void loadConfig(String path) throws IOException {
        try (FileInputStream fis = new FileInputStream(path)) {
            properties.load(fis);
        }
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}

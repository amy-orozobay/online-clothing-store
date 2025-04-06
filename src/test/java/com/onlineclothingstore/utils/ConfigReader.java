package com.onlineclothingstore.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

    public class ConfigReader {
        private static Properties properties;

        static {
            try {
                FileInputStream file = new FileInputStream("src/test/resources/configs/config.properties"); // Path to properties
                properties = new Properties();
                properties.load(file);
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Ошибка при загрузке config.properties");
            }
        }

        public static String getProperty(String key) {
            return properties.getProperty(key);
        }
    }


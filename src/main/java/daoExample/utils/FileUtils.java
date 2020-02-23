package daoExample.utils;

import java.io.*;
import java.util.Properties;

public class FileUtils {
    private static final String PROPERTY_FILE = "config.properties";

    public static void zapiszProperty(String key, String value) {
        Properties properties = getProperties();
        properties.put(key, value);
        try (OutputStream os = new FileOutputStream(new File(PROPERTY_FILE))) {
            properties.store(os, "Person config");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try (InputStream is = new FileInputStream(new File(PROPERTY_FILE))) {
            properties.load(is);
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return properties;
    }

    public static String pobierzProperty() {
        String key = "file";
        String result = getProperties().getProperty(key);
        if(result == null) {
            zapiszProperty(key,"example_file.csv");
            result = getProperties().getProperty(key);
        }
        return result;
    }
}

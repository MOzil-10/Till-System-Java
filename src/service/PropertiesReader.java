package service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static PropertiesReader instance = null;
    private final Properties prop;

    private PropertiesReader() {
        prop = new Properties();
        String propFileName = "config.properties";
        try (InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream(propFileName)) {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new IOException("Unable to find property file: " + propFileName);
            }
        } catch (IOException e) {
            System.err.println("Error occurred while loading property file: " + e.getMessage());
        }
    }

    public static PropertiesReader getInstance() {
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    public String getPropertyValue(String value) {
        return prop.getProperty(value);
    }
}

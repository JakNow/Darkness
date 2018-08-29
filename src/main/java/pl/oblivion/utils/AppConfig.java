package pl.oblivion.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class AppConfig {

    public static synchronized Properties loadProperties(String path) {
        try {
            Properties properties = new Properties();
            properties.load(Files.newInputStream(Paths.get(path)));
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Couldn't load properties from path=" + path);
        }
    }
}

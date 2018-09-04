package pl.oblivion.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class AppConfig {

    private static final Logger logger = LogManager.getLogger(AppConfig.class.getName());

    public static synchronized Properties loadProperties(String path) {
        logger.info("Loading properties");
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

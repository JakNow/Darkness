package pl.oblivion.utils;

import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

@ToString
public class MyFile {

    private static final Logger logger = LogManager.getLogger(MyFile.class.getName());
    private String path;
    private String name;

    public MyFile(String path) {
        this.path = path.startsWith(File.separator) ? path : File.separator.concat(path);
        this.name = setName(this.path);
        logger.info(this.toString());
    }

    private String setName(String path) {
        String[] dirs = path.split(File.separator);
        return dirs[dirs.length - 1];
    }

    public MyFile(String... paths) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String path : paths) {
            stringBuilder.append(File.separator.concat(path));
        }
        this.path = stringBuilder.toString();
        this.name = setName(this.path);
        logger.info(this.toString());
    }

    public MyFile(MyFile myFile, String subFile) {
        this.path = myFile.path.concat(File.separator).concat(subFile);
        this.name = subFile;
        logger.info(this.toString());
    }

    public MyFile(MyFile myFile, String... subFiles) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String subFile : subFiles) {
            stringBuilder.append(File.separator.concat(subFile));
        }
        this.path = stringBuilder.toString();
        this.name = setName(this.path);
        logger.info(this.toString());
    }

    public BufferedReader getReader() {
        try {
            InputStreamReader isr = new InputStreamReader(getInputStream());
            return new BufferedReader(isr);
        } catch (Exception e) {
            logger.error("Couldn't get reader for " + this.path, e);
            throw e;
        }
    }

    private InputStream getInputStream() {
        return Class.class.getResourceAsStream(this.path);
    }
}

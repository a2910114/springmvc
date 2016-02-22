package com.mykhaylenko.messenger.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pavlo.mykhaylenko on 8/26/2015.
 */
public class PropertiesUtil {

    public Properties loadProperties(String properyFileName) {
        Properties properties = new Properties();
        try {
            properties = getProperties(properyFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return properties;
    }


    private Properties getProperties(String fileName) throws FileNotFoundException {
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new FileNotFoundException("Properties file: " + fileName + " not found");
        }

        return properties;
    }
}

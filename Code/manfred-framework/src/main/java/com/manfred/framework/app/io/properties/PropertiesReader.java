package com.manfred.framework.app.io.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesReader {

	public static Properties readPropertiesFromFile(String file) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = classLoader.getResourceAsStream(file);
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}

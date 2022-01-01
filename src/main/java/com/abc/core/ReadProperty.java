package com.abc.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
		Properties properties = null;
		public ReadProperty(String propertiesFileName) throws IOException {
			File file = new File(System.getProperty("user.dir")+"/src/main/resources/config/"+propertiesFileName+".properties");
			FileInputStream fileInputStream = new FileInputStream(file);
			
			properties = new Properties();
			properties.load(fileInputStream);
		}
		
		public String getKeyValue(String keyName) throws IOException {
			return properties.getProperty(keyName);
			
		}

}

package com.dlg.web.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;



public class RequirementUtils {
		
	//private static final Logger log = Logger.getLogger(RequirementUtils.class);
	
	private static final String ENV_CONFIG_LOCATION = "env.config.location";
	public static String home_location;
	private static InputStream inputStream;
	public static Properties properties;
	private static String appQueueMessage;
	private static String outQueueMessage;

	
	
	@PostConstruct
	public void initialize() {
		try {
			inputStream = getClass().getResourceAsStream("/env.properties");			
			properties = new Properties();
			properties.load(inputStream);
		} catch (IOException e) {
			//log.error(e.getMessage(), e);
		}
	}
	

	public  String getEnvPropertyValue(String propertyName) {
		try {
			inputStream = getClass().getResourceAsStream("/dlg.properties");

			properties = new Properties();
			properties.load(inputStream);			
			
		} catch (IOException e) {
			//log.error(e.getMessage(), e);
		}
		return (String) properties.getProperty(propertyName);
	}

	public static String readFileToString(File file) throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(file);
		BufferedReader xmlRequestReader = new BufferedReader(fileReader);

		StringBuffer requestXml = new StringBuffer();
		String line = "";
		while ((line = xmlRequestReader.readLine()) != null) {
			requestXml.append(line);
		}
		xmlRequestReader.close();
		return requestXml.toString();
	}

	

}
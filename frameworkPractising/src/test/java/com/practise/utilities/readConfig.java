package com.practise.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfig {
	Properties property;
	
	public readConfig() {
		
		File file = new File("./Configurations/config.properties");
		try {
		FileInputStream src = new FileInputStream(file);
		property = new Properties();
		property.load(src);
		
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	
	}

	public String getURL() {
		String BaseURL = property.getProperty("BaseURL");
		return BaseURL;
	}
	public String userName() {
		String userName = property.getProperty("userName");
		return userName;
	}
	public String passWord() {
		String passWord = property.getProperty("passWord");
		return passWord;
	}

	
}

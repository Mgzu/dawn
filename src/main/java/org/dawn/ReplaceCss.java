package org.dawn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReplaceCss {

	public static void main(String[] args) {
		Properties pro = new Properties();
		FileInputStream in = null;
		try {
			in = new FileInputStream("config.properties");
			pro.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String res = pro.getProperty("res");
		System.out.println(res);
		System.out.println(pro.getProperty("mode"));
	}
}

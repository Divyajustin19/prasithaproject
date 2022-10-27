package util1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader1 {


	public static Properties getPropertyObject() throws IOException {
		FileInputStream fp = new FileInputStream("config.properties1");
		Properties prop = new Properties();
		prop.load(fp);
		return prop;
	}
		public static String gettype() throws IOException {
		return getPropertyObject().getProperty("type");
	}
	public static String getcourse() throws IOException {
		return getPropertyObject().getProperty("course");
	}
	public static String getsem() throws IOException {
		return getPropertyObject().getProperty("sem");
	}
	public static String getupload() throws IOException {
		return getPropertyObject().getProperty("upload");
	}









}



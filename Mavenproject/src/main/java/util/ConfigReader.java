package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties getPropertyObject() throws IOException {
		FileInputStream fp = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(fp);
		return prop;
	}
	public static String getname() throws IOException {
		return getPropertyObject().getProperty("name");
	}
	public static String getlogo() throws IOException {
		return getPropertyObject().getProperty("logo");
	}
	public static String getaddress() throws IOException {
		return getPropertyObject().getProperty("address");
	}
	public static String getdistrict() throws IOException {
		return getPropertyObject().getProperty("district");
	}
	public static String getaffiliation() throws IOException {
		return getPropertyObject().getProperty("affiliation");
	}
	public static String getaffiliatedto() throws IOException {
		return getPropertyObject().getProperty("affiliatedto");
	}
	public static String getcollegetpe() throws IOException {
		return getPropertyObject().getProperty("collegetpe");
	}
	public static String getadname() throws IOException {
		return getPropertyObject().getProperty("adname");
	}
	public static String getadnumber() throws IOException {
		return getPropertyObject().getProperty("adnumber");
	}
	public static String getemail() throws IOException {
		return getPropertyObject().getProperty("email");
	}
	public static String getplname() throws IOException {
		return getPropertyObject().getProperty("plname");
	}
	public static String getplnumber() throws IOException {
		return getPropertyObject().getProperty("plnumber");
	}
	public static String getplemail() throws IOException {
		return getPropertyObject().getProperty("plemail");
	}
		
}


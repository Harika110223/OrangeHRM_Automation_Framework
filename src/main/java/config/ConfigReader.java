package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties=new Properties();

    public ConfigReader() throws IOException{
        FileInputStream fileInputStream=new FileInputStream("src/main/resources/config.properties");

properties.load(fileInputStream);
}
public static String getProperty(String key){
        return properties.getProperty(key);
    }
}

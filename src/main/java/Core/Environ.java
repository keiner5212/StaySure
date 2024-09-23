package Core;

import java.util.Properties;

public class Environ {
    private Properties properties = new Properties();

    public Environ() {
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
}
package com.fje.utils;
import com.fje.JsonExplorer;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {
    private Properties props;

    public PropertiesUtil(String fileName) {
        readProperties(fileName);
    }

    /**
     * 加载配置文件
     *
     * @param fileName
     */
    private void readProperties(String fileName) {
        try {
            props = new Properties();
            InputStream in = JsonExplorer.class.getClassLoader().getResourceAsStream(fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(in, "8859_1");
            props.load(inputStreamReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据key读取对应的value
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return props.getProperty(key);
    }
}




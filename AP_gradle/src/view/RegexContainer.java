package view;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class RegexContainer {
    private Properties properties = new Properties();

    public RegexContainer(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRegex(String key) {
        return properties.getProperty(key);
    }
}

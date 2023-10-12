package gp.x.easydev;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/

public final class PropertiesReader {
    private Properties properties;
    // private static final Logger logger = LogManager.getLogger();

    public PropertiesReader(String filename) {
        try {
            ClassLoader loader = PropertiesReader.class.getClassLoader();
            File file = new File(filename);
            this.properties = new Properties();
            this.properties.load(new FileInputStream(file));
        } catch (NullPointerException | IOException var4) {
            var4.printStackTrace();
        }

    }

    public String getValue(String key) {
        return this.properties.getProperty(key);
    }

    public int getIntValue(String key) {
        try {
            return Integer.parseInt(this.properties.getProperty(key));
        } catch (NumberFormatException var3) {
            //logger.error("Ошибка преобразования проперти " + key + ": " + var3.getMessage());
            return -1;
        }
    }

    public long getLongValue(String key) {
        try {
            return Long.parseLong(this.properties.getProperty(key));
        } catch (NumberFormatException var3) {
            // logger.error("Ошибка преобразования проперти " + key + ": " + var3.getMessage());
            return -1L;
        }
    }
}

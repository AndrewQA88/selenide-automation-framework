package configs;

import java.util.ResourceBundle;

public class ResourceBundleFileReader {

    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("autotest");

    public static String getProperty(String propertyName) {
        return resourceBundle.getString(propertyName);
    }
}

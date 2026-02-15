package base;

import config.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.DriverManager;

public class BaseTest {
    
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        // Initialize driver
        DriverManager.initDriver(browser);
        
        // Navigate to application
        DriverManager.getDriver().get(ConfigReader.getProperty("url"));
    }
    
    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
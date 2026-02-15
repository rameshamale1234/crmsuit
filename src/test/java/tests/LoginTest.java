
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.DemoPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtils;

public class LoginTest extends BaseTest {
	
	HomePage homePage;
	DemoPage demoPage;
	LoginPage loginPage;
    
    @Test(priority = 1, description = "Verify login with valid credentials", dataProvider = "loginData")
    public void testValidLogin(String username, String password) {
    	
    	loginPage= new LoginPage();
    	homePage = new HomePage();
    	demoPage = new DemoPage();
    	demoPage.clickAccessDemoButton();
        loginPage.login(username,password );
    }
    
    @Test(priority = 2, description = "Verify login with invalid credentials")
    public void testInvalidLogin() {
        loginPage = new LoginPage();
        
        // Perform login with invalid credentials
        loginPage.login("invalid_username", "invalid_password");
        
        // Verify error message
        String errorMsg = loginPage.getErrorMessage();
        Assert.assertTrue(errorMsg.contains("Invalid"), 
                         "Error message should appear");
    }
    
    @DataProvider(name = "loginData")
    public Object[][] getData() {
    	String path = System.getProperty("user.dir") + "/src/test/resources/testdata/ValidLogin.xlsx";
        return ExcelUtils.getTestData(path, "ValidLogin");
    }
}
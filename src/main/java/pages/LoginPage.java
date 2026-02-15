package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    
    // Locators
    @FindBy(id = "user_name")
    private WebElement usernameField;
    
    @FindBy(id = "username_password")  
    private WebElement passwordField;
    
    @FindBy(id= "bigbutton")
    private WebElement loginButton;
    
    @FindBy(css = ".error-message")  // Change to your actual locator
    private WebElement errorMessage;
    
    // Actions
    public LoginPage enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
        return this;
    }
    
    public LoginPage enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
    
    public void clickLogin() {
        loginButton.click();
    }
    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    
    public String getErrorMessage() {
        return errorMessage.getText();
    }
    
   
}
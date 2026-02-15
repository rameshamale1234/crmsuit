package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.DriverManager;

public class HomePage extends BasePage {
	
private WebElement driver;
	
	
@FindBy (xpath = "//li[@id='menu-item-564397']")
private WebElement getStartedButtonLink;

public HomePage() { 
	super(); 
	PageFactory.initElements(driver, this); 	
}

public void clickGetStartedButton() {
	getStartedButtonLink.click(); }
}

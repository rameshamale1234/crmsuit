package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemoPage extends BasePage {
	
	@FindBy(xpath="//span[text()='ACCESS THE SUITECRM 7 ESR DEMO']")
	private WebElement accessDemoButton; 
	
	
	public void clickAccessDemoButton() { 
		scrollToElement(accessDemoButton);
		accessDemoButton.click(); }
}

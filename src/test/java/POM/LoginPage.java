package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.BasePage;

public class LoginPage extends BasePage{
        
	public LoginPage(WebDriver driver){
	     super(driver);
	}
	
	@FindBy(xpath = "//h5[text()='Login']")
	WebElement loginText;
	
	@FindBy(name= "username")
	WebElement usernameTF;
	
	@FindBy(name="password")
	WebElement passwordTF;
	
	@FindBy(xpath = "//button[text()=' Login ']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='orangehrm-login-forgot']")
	WebElement forgotLink;
	
	public void login(String user, String pass) {
		usernameTF.sendKeys(user);
		passwordTF.sendKeys(pass);
        loginBtn.click();
    }
	
	public void clickforgotPassLink()
	{
		forgotLink.click();
	}
	
	public String getLoginText()
	{
		String loginHeading =loginText.getText();
		return loginHeading;
	}
	
}

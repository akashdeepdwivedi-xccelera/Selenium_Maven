package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.BasePage;
import utils.WaitUtils;

public class DashboardPage extends BasePage{
	
	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	WaitUtils wait = new WaitUtils(driver);
	
	@FindBy(xpath = "//p[text()='My Actions']")
	WebElement myActionsCard;
	
	@FindBy(xpath= "//div[@class='oxd-topbar-header-userarea']")
	WebElement profileIcon;
	
	@FindBy(linkText = "Logout")
	WebElement logoutLink;
	
	public String getMyActionsCard()
	{
		String text= myActionsCard.getText();
		return text;
	}
	
	public void clickLogoutLink()
	{
		profileIcon.click();
		wait.waitForElementToBeVisible(logoutLink,10);
		logoutLink.click();
	}
}

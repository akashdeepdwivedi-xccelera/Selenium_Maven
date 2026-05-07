package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.DashboardPage;
import POM.LoginPage;
import TestBase.TestBase;

public class LogoutTest extends TestBase{
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }
    
    @Test(groups= {"smoke"})
    public void logoutTest() {
        loginPage.login("Admin", "admin123");
        Assert.assertEquals(dashboardPage.getMyActionsCard(), "My Actions");
        dashboardPage.clickLogoutLink();
        Assert.assertEquals(loginPage.getLoginText(), "Login");
    }

    @AfterMethod
    public void close() {
        tearDown();
    }
}

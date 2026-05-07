package TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ConfigReader;

public class TestBase {

    public static WebDriver driver;
    ConfigReader config;

    public void initialization() {
    	
    	config = new ConfigReader();
        String browser = config.getBrowser();

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();
        }
         else if (browser.equalsIgnoreCase("firefox")) {
             driver = new FirefoxDriver();
         }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getImplicitWait()));

        driver.get(config.getUrl());
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
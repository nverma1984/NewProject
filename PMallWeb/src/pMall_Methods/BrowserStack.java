package pMall_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStack extends BusinessMethods {

public static final String USERNAME = "neerajv1";
public static final String AUTOMATE_KEY = "VmF1HyZsr9XEdqeXs7q1";
public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

@Test
public void bstack() {
 openbrowser("browserstack");
 driver.navigate().to("https://dev.personalizationmall.com");
 explicitWait(3);
 System.out.println(driver.getTitle());
driver.quit();
	  }	
	
	
}


package pMall_Methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CoreMethods {
	
	public WebDriver driver;


	public void openbrowser(){
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\Driver\\geckodriver.exe");
	 driver = new FirefoxDriver();
	 driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void launchapp(String pUrl){		
		driver.navigate().to(pUrl);
		}
	
	public void closebrowser(){
		 driver.quit();
		}
		
	
}

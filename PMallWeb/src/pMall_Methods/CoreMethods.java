package pMall_Methods;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CoreMethods {
	
	public WebDriver driver;


	public void openbrowser(){
//	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\Driver\\geckodriver.exe");
//	 driver = new FirefoxDriver();
//	 driver.manage().window().maximize();
//     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
			WebDriverManager.chromedriver().version("75.0").setup();
			driver =new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}
	
	public void launchapp(String pUrl){		
		driver.navigate().to(pUrl);
		}
	
	public void closebrowser(){
		 driver.quit();
		}
		
	public void explicitWait(int timeinseconds){
		try {
			Thread.sleep(timeinseconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

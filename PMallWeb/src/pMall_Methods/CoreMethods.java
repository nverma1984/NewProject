package pMall_Methods;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreMethods {
	
	public WebDriver driver;
	public static final String USERNAME = "neerajv1";
	public static final String AUTOMATE_KEY = "VmF1HyZsr9XEdqeXs7q1";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public void openbrowser(String type){
//	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\Driver\\geckodriver.exe");
//	 driver = new FirefoxDriver();
//	 driver.manage().window().maximize();
//     driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
 if (type=="mobile"){		
	 WebDriverManager.chromedriver().version("76.0").setup();
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
	        options.addArguments("--start-maximized");
	        driver =new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
 }//for ends
 
 else if( type=="desktop"){
		WebDriverManager.chromedriver().version("76.0").setup();
        driver =new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
 }//else ends
 
 else if (type=="browserstack"){
	 
	  DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browserName", "iPhone");
	    caps.setCapability("device", "iPhone XS");
	    caps.setCapability("realMobile", "true");
	    caps.setCapability("os_version", "12");
	    caps.setCapability("name", "Bstack-[Java] Sample Test");
	    caps.setCapability("browserstack.debug", "true");

	    try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
 }//else ends
 
 else if (type == "firefox"){
	 
	 WebDriverManager.firefoxdriver().setup();
	 driver = new FirefoxDriver();
	 
 }//else ends

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

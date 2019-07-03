import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FindAlttext {
public static String nameofpagelink;
public static String urlofpagelink;
public static String[] pagestring = {"Shop by Occasion", "Summer Gifts", "Best Sellers For Summer", "For The Home", "For The Kids", "Beach Towels", "New in Summer Gifts", "Back To School"};
	private static ThreadLocal<WebDriver> localthread = new ThreadLocal<WebDriver>();
	public static WebDriver getDriver(){
 		return (WebDriver)localthread.get();		
 		}
	
	public void createinstanceofbrowser(String Browser, String GridMachine){

 		WebDriver driver=null;
 		
 		if (Browser.equalsIgnoreCase("Mozilla"))
	 		
 		{
 			
 		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\Driver\\geckodriver.exe");
 		 driver=new FirefoxDriver();
 		 this.localthread.set(driver);	
 		}
 		
 		else if(Browser.equalsIgnoreCase("Chrome")){
 			WebDriverManager.chromedriver().version("74.0").setup();
 			driver =new ChromeDriver();
 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
 			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 			this.localthread.set(driver);
 			
 		}
 		else if(Browser.equalsIgnoreCase("IE")){
 			System.setProperty("webdriver.ie.driver", "C:\\Users\\nverma\\Desktop\\Stuff not backed up\\Stuff not backed up\\Softwares\\Drivers\\IEDriverServer.exe");
 			 driver =new InternetExplorerDriver();
 			this.localthread.set(driver);
 			
 		}
 	    driver=localthread.get();
 	
 	}
    
	
   @Test
	 public void firsttest(){	    	 
	   	 FindAlttext t1 = new FindAlttext();
	   	 t1.createinstanceofbrowser("Chrome", "true");
	   	 t1.getalttext();		
	}
	 
	 
		public void getalttext(){
			getDriver().get("https://www.personalizationmall.com");
	 		getDriver().manage().window().maximize();
	 		getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	 		getDriver().findElement(By.xpath("//span[text()='close']")).click();
	 			 			 		
	 		List<String> ListofPages = Arrays.asList(pagestring);
	 	
	 		//System.out.println("The first link is " + ListofPages.get(0));
	 		//System.out.println("Total number of links is " + ListofPages.size());
	 			 		
	 		for (int i =0;i<ListofPages.size();i++){
	 			//System.out.println(" For The link number " + (i+1));
	 		getDriver().get("https://www.personalizationmall.com/SiteMap.aspx");	
	 		WebElement link =  getDriver().findElement(By.linkText(ListofPages.get(i)));
	 		nameofpagelink = link.getText();
	 		urlofpagelink = link.getAttribute("href");
	 		getDriver().navigate().to(urlofpagelink);
	 		waitforseconds(15);
	 		findimagealttext();	
	 		}
	 			
		}
	 
	// - Code to find the image link and Alt text
	 public void findimagealttext(){
	 		 		
	 		List<WebElement> elementName = getDriver().findElements(By.tagName("img"));
	 		int ni = elementName.size();
	 	    //System.out.println("Number of images on page " + nameofpagelink +" is:" + ni);
	 		
	 		for(int i1=0;i1<ni;i1++){
	 			
	 			String src = elementName.get(i1).getAttribute("src");
	 			String alttext = elementName.get(i1).getAttribute("alt");
	 			if(alttext==""){alttext="blank";}
	 		//System.out.print("The image source is " + src + "  ,");
	 		//System.out.println("The image alt text is " + alttext);
	 			System.out.println(src + "^ " + alttext + "^ " + nameofpagelink + "^ " + urlofpagelink);
	      }
		 
	 }
	 
	 public void waitforseconds(int time){
			try {
				time=time*1000;
				Thread.sleep(time);
				
				//System.out.println("The program waited for " + time + " seconds");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	 }
	 

		
		//-- Code to find links on site map
		
		public void linksofsitemappage(){
		
		waitforseconds(12);

		List<WebElement> elementName2 = getDriver().findElements(By.xpath("//div[@id='ctl00_tdMain']//a"));
		int linkcount = elementName2.size();
		System.out.println("The nummber of links on sitemap is " + linkcount);
		
		for(int i=0;i<=2;i++){
			
			String href = elementName2.get(i).getAttribute("href");
			String linktextvalue = elementName2.get(i).getText();
	 		System.out.println("The link name is" + linktextvalue);
	 		System.out.print("The link is " + href + "  ,");
   }
		}
}
	


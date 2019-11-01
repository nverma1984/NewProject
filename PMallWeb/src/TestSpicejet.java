import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pMall_Methods.BusinessMethods;


public class TestSpicejet extends BusinessMethods {

	@Test
	public void spicejet(){
		
		openbrowser("desktop");
		driver.navigate().to("https://www.spicejet.com");
		
		
		driver.findElement(By.xpath("//input[@value='RoundTrip' and @id='ctl00_mainContent_rbtnl_Trip_1']")).click();;
		explicitWait(5);	
		
	
	
		driver.findElements(By.xpath("//button[@class='ui-datepicker-trigger']")).get(0).click();
		explicitWait(3);
		List<WebElement> futuredate = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[1]//td[@data-handler='selectDay']"));
		futuredate.get(2).click();
		
		
		//driver.findElements(By.xpath("//button[@class='ui-datepicker-trigger']")).get(1).click();
		driver.findElement(By.xpath("//input[@name ='ctl00$mainContent$view_date2']")).click();
		explicitWait(3);
		List<WebElement> futuredate1 = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']/div[1]//td[@data-handler='selectDay']"));
		futuredate1.get(futuredate1.size()-1).click();
		
		
	}
}

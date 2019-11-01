package pMall_TestCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pMall_Methods.BusinessMethods;

public class Newclasstitleverification extends BusinessMethods {
String url="https://dev.personalizationmall.com/Personalized-Gifts-Daily-Deals-z2.store";
String metadescription;
List<String> arr=new ArrayList<String>();
List <WebElement> a1;
String s="https://www.personalizationmall.com/AboutUs.aspx~https://www.personalizationmall.com/ContactUs.aspx~https://www.personalizationmall.com/Personalized-Iron-Man-Gifts-Marvel-Comics-l110.lp~https://www.personalizationmall.com/CreateProfile.aspx~https://www.personalizationmall.com/Pmall_Reviews.aspx~https://www.personalizationmall.com/AffiliateProgram.aspx~https://www.personalizationmall.com/Personalized-Gifts-Daily-Deals-z2.store~https://www.personalizationmall.com/Personalized-Gifts-Shop-By-Occasion-z5.store~https://www.personalizationmall.com/Personalized-Canvas-Prints-Wall-Art-g4.lp~https://www.personalizationmall.com/Personalized-Jewelry-Gifts-g15.lp~https://www.personalizationmall.com/Personalized-Keepsake-Gifts-g16.lp~https://www.personalizationmall.com/Personalized-Garden-Outdoor-Gifts-g19.lp~https://www.personalizationmall.com/Personalized-Clothing-Accessories-g8.lp~https://www.personalizationmall.com/Personalized-Kitchenware-Kitchen-Supplies-g17.lp~https://www.personalizationmall.com/Personalized-Gifts-Product-Categories-z3.store~https://www.personalizationmall.com/Personalized-Drinkware-Coffee-Mugs-Barware-g10.lp~https://www.personalizationmall.com/Personalized-Travel-Gifts-g11.lp~https://www.personalizationmall.com/Personalized-Picture-Frames-Photo-Albums-g12.lp~https://www.personalizationmall.com/Personalized-Bed-Bath-Gifts-g3.lp~https://www.personalizationmall.com/Personalized-Stationery-Gifts-g1.lp~https://www.personalizationmall.com/Personalized-Kids-Toys-g25.lp~https://www.personalizationmall.com/Personalized-Graduation-Gifts-pa14.store~https://www.personalizationmall.com/Personalized-Gifts-for-Kids-pa25.store~https://www.personalizationmall.com/Wedding-Anniversary-Gift-Ideas-For-Every-Year-l279.lp~https://www.personalizationmall.com/Personalization-Mall-Coupon-Codes-l268.lp~https://www.personalizationmall.com/25th-Anniversary-Gifts-Silver-Anniversary-Gifts-l288.lp~https://www.personalizationmall.com/50th-Anniversary-Gifts-Golden-Anniversary-Gifts-l289.lp~https://www.personalizationmall.com/10-Year-Anniversary-Gifts-Tin-Anniversary-Gifts-l287.lp~https://www.personalizationmall.com/1st-Year-Anniversary-Gifts-Paper-Anniversary-Gifts-l285.lp~https://www.personalizationmall.com/5-Year-Anniversary-Gifts-Wood-Anniversary-Gifts-l286.lp~https://www.personalizationmall.com/Anniversary-Gifts-for-Him-l293.lp~https://www.personalizationmall.com/Five-Senses-Gift-l269.lp~https://www.personalizationmall.com/Anniversary-Gifts-for-Her-l292.lp~https://www.personalizationmall.com/Anniversary-Gifts-for-Parents-Couples-l294.lp~https://www.personalizationmall.com/Five-Senses-Gift-Ideas-Sound-l272.lp~https://www.personalizationmall.com/Fathers-Day-Gift-Ideas-For-The-Military-Dad-l152.lp~https://www.personalizationmall.com/Five-Senses-Gift-Ideas-Touch-l274.lp~https://www.personalizationmall.com/Five-Senses-Gift-Ideas-Smell-l270.lp~https://www.personalizationmall.com/Mothers-Day-Gift-Ideas-For-Active-Moms-l137.lp~https://www.personalizationmall.com/Fathers-Day-Gift-Ideas-For-The-Handyman-Dad-l151.lp~https://www.personalizationmall.com/Five-Senses-Gift-Ideas-Sight-l273.lp~https://www.personalizationmall.com/Fathers-Day-Gift-Ideas-For-The-Outdoorsman-Dad-l153.lp~https://www.personalizationmall.com/Mothers-Day-Gift-Ideas-For-Working-Moms-l135.lp~https://www.personalizationmall.com/Fathers-Day-Gift-Ideas-For-The-Businessman-Dad-l203.lp~https://www.personalizationmall.com/ShippingRates.aspx~https://www.personalizationmall.com/ShippingRates.aspx?regionid=2~https://www.personalizationmall.com/Design-Your-Own-T-Shirts-Gifts-s48.store~https://www.personalizationmall.com/corporate/CorpDefault.aspx";

//Test to get the meta description of the pages
@Test(invocationCount=0)	
	
public void getMetaDescription()
	{
	

String ar[] = s.split("~");

String pagetitle="";
	openbrowser("mobile");
	for(int i=1;i<=ar.length;i++){
	//System.out.println("Running for " + ar.get(i-1));
	driver.navigate().to(ar[i-1]);
    explicitWait(2);
    try {
         metadescription = driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content").toString();
         pagetitle = driver.getTitle();
    } catch (Exception e) {
	    System.out.println("The metadescription doesn't exist for"+ "    " + ar[i-1]);	
	    continue;}
        
    //driver.findElement(By.xpath("//meta[@name='description']")).isDisplayed();
    String ss= metadescription+ "    " + pagetitle + "    " + driver.getCurrentUrl();
	System.out.println(ss);

	} //for ends
	
System.out.println("MetaDescription and PageTitles for Desktop");
openbrowser("desktop");
for(int i=1;i<=ar.length;i++){
//System.out.println("Running for " + ar.get(i-1));
driver.navigate().to(ar[i-1]);
explicitWait(2);
try {
     metadescription = driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content").toString();
     pagetitle = driver.getTitle();
} catch (Exception e) {
    System.out.println("The metadescription doesn't exist for"+ "    " + ar[i-1]);	
    continue;}
    
//driver.findElement(By.xpath("//meta[@name='description']")).isDisplayed();
String ss= metadescription+ "    " + pagetitle + "    " + driver.getCurrentUrl();
System.out.println(ss);

} //for ends


	}          //test for meta description ends




//test for store page titles
@Test(invocationCount=0)	
public void getStorePagesTitles(){
	
//get store pages from site map	
openbrowser("desktop");
driver.navigate().to("https://www.personalizationmall.com/SiteMap.aspx");
a1 = driver.findElements(By.xpath("//li/a[contains(@href,'.store')]"));	

//Storing the links in an array.
List <String> a2 = new ArrayList<String>();

for (int j = 1;j<=a1.size();j++){
	
a2.add(a1.get(j-1).getAttribute("href"));
}//for ends here

//get page titles-------------
String pagelink="";
String PageTitle="";
for (int i = 1;i<=a2.size();i++){

try {
//System.out.println("Value of i is " + i);
//System.out.println("Value of link is " + a2.get(i-1));
	pagelink = a2.get(i-1);
	driver.navigate().to(pagelink);
	explicitWait(2);
	PageTitle = driver.getTitle();
	System.out.println(pagelink + "~"+ PageTitle);
} catch (Exception e) {
	System.out.println(pagelink + "~"+ "Problem on the page");
	continue;
}//try-catch ends

}//for ends

driver.quit();

System.out.println("The PageTitles for mobile site starts here");
openbrowser("mobile");
for (int i = 1;i<=a2.size();i++){

try {
//System.out.println("Value of i is " + i);
//System.out.println("Value of link is " + a2.get(i-1));
	pagelink = a2.get(i-1).replace("www.", "dev.");
	driver.navigate().to(pagelink);
	explicitWait(2);
	PageTitle = driver.getTitle();
	System.out.println(pagelink + "~"+ PageTitle);
} catch (Exception e) {
	System.out.println(pagelink + "~"+ "Problem on the page");
	continue;
}//try-catch ends

}//for ends



}//test ends

//Test for 
@Test(invocationCount=0)	
public void getLandingPageTitles(){
openbrowser("desktop");
driver.navigate().to("https://www.personalizationmall.com/SiteMap.aspx");
//a1 = driver.findElements(By.xpath("//li/a[contains(@href,'.lp')and contains(@href,'-l')]"));
a1 = driver.findElements(By.xpath("//li/a[contains(@href,'.lp')]"));
//Storing the links in an array.
List <String> a2 = new ArrayList<String>();

for (int j = 1;j<=a1.size();j++){
	
a2.add(a1.get(j-1).getAttribute("href"));
}//for ends here

//get page titles.
String pagelink="";
String PageTitle="";
for (int i = 1;i<=a2.size();i++){

try {
//System.out.println("Value of i is " + i);
//System.out.println("Value of link is " + a2.get(i-1));
	pagelink = a2.get(i-1);
	driver.navigate().to(pagelink);
	explicitWait(2);
	PageTitle = driver.getTitle();
	System.out.println(pagelink + "~"+ PageTitle);
} catch (Exception e) {
	System.out.println(pagelink + "~"+ "Problem on the page");
	continue;
}//try-catch ends

}//for ends

driver.quit();

System.out.println("The PageTitles for mobile site starts here");
openbrowser("mobile");
for (int i = 1;i<=a2.size();i++){

try {
//System.out.println("Value of i is " + i);
//System.out.println("Value of link is " + a2.get(i-1));
	pagelink = a2.get(i-1).replace("www.", "dev.");
	driver.navigate().to(pagelink);
	explicitWait(2);
	PageTitle = driver.getTitle();
	System.out.println(pagelink + "~"+ PageTitle);
} catch (Exception e) {
	System.out.println(pagelink + "~"+ "Problem on the page");
	continue;
}//try-catch ends

}//for ends

}//test ends here

@Test(invocationCount=1)	
public void getCanonicallink(){
openbrowser("desktop");

String [] arr= s.split("~");
System.out.println("The number of pages are " +arr.length);

for (int i=1;i<=arr.length;i++){
//System.out.println("The link is "+ arr[i-1]);
driver.navigate().to(arr[i-1]);
try {
String canonlink = driver.findElement(By.xpath("html/head/link[@rel='canonical']")).getAttribute("href").toString();

	System.out.println(arr[i-1] + "  ~  "+ canonlink);
} catch (Exception e) {
System.out.println(arr[i-1] + "  ~  "+ "The canonical link not found");
continue;

}
}// for ends here

}//test ends here

@Test(invocationCount=0)
public void dummytest()
{
	openbrowser("desktop");
}


}// class ends

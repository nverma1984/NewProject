package pMall_Methods;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pMall_PageObjectRepository.*;

public class BusinessMethods extends CoreMethods {
	
	 String pmall_url = new String("https://www.personalizationmall.com/");
	 String Shipping;
public void Launch_pMallweb(){
	launchapp(pmall_url);	
}

//--Close the pop up on home page 
public void CloseHomePagePopUp(){
	HomePage HomePage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.HomePage.class);
    explicitWait(5);
	try {
		HomePage1.WEP_Close_Bn.click();

	} catch (Exception e) {
System.out.println("The Homepage pop was not displayed");
	}
	HomePage1.SignIn.click();
}

//- Login to PMall Website
public void LogintoPMall(){
	
	LoginPage LoginPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.LoginPage.class);
	LoginPage1.SignInID.clear();
	LoginPage1.SignInID.sendKeys("neeraj.verma@intsof.com");
	LoginPage1.SignInPassword.clear();;
	LoginPage1.SignInPassword.sendKeys("Neeraj01#");
	explicitWait(3);	//for watching the script
	LoginPage1.SignInButton.click();
}

//---------------------Silver stand with no personalization------------------------------

public void AddOrnamentHooktoCart(){

String productpath;
productpath =  "Curved-Silver-Christmas-Ornament-Display-Stand-i27242.item?productid=9095";
driver.navigate().to(pmall_url + productpath);
CommonPersonalizationcontrols ProductPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CommonPersonalizationcontrols.class);
ProductPage1.AddtoCartButtonPP.click();
explicitWait(10);
}

// ---------------------Ornament with Two Photos------------------------------
public void AddOrnamentwith2PhotoToCart(){
	String productpath;
	productpath =  "Personalized-Photo-Christmas-Ornament-2-Sided-i47410.item?productid=16799&sdest=Search&sdestid=86877813";
	driver.navigate().to(pmall_url + productpath);
	
	//Navigate to the personalization window
	CommonPersonalizationcontrols ProductPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CommonPersonalizationcontrols.class);
	ProductPage1.PersonalizeandAdd2Cart.click();
	explicitWait(5);

	// Open Personalization window 
	driver.switchTo().frame("pmallmodaliframe");
	
	//Upload Photo 1		
	Ornamnetwith2Photos Ornamnetwith2Photos1 = PageFactory.initElements(driver,pMall_PageObjectRepository.Ornamnetwith2Photos.class);
	Ornamnetwith2Photos1.Photo1.click();
	explicitWait(5);
	Ornamnetwith2Photos1.FileUploadButton.click();
	explicitWait(5);	
	try {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Resources\\Files\\AutoITFiles\\Ornamentwith2Photos\\FirstPhotoupload.exe");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	explicitWait(5);
	Ornamnetwith2Photos1.ConfirmationCheckbox.click();
	explicitWait(2);
	Ornamnetwith2Photos1.SaveButton.click();
	explicitWait(10);

	//Upload Photo 2
	
	Ornamnetwith2Photos1.Photo2.click();
	explicitWait(5);
	Ornamnetwith2Photos1.FileUploadButton.click();
	explicitWait(5);	
	try {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+ "\\Resources\\Files\\AutoITFiles\\Ornamentwith2Photos\\FirstPhotoupload.exe");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	explicitWait(5);
	Ornamnetwith2Photos1.ConfirmationCheckbox.click();
	explicitWait(2);
	Ornamnetwith2Photos1.SaveButton.click();
	explicitWait(20);
	
	Ornamnetwith2Photos1.AdditionalProductRadioOptionYes.click();
	Ornamnetwith2Photos1.GiftBoxRadioYes.click();
	ProductPage1.PreviewandAddtoCart.click();
	explicitWait(5);

	// Preview personalization and Add to Cart
	ProductPage1.PersonalizationConfirmationCheckbox.click();
	explicitWait(2);

	ProductPage1.AddtoCartafterpersonalization.click();


}
public void AddEmbroideredTravelCaseToCart(){

//Navigate to the product page 
String productpath;
productpath =  "Mens-Personalized-Travel-Case-p17116.prod?sdest=Search&sdestid=86461114";
driver.navigate().to(pmall_url + productpath);

//Navigate to the personalization window
CommonPersonalizationcontrols ProductPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CommonPersonalizationcontrols.class);
ProductPage1.PersonalizeandAdd2Cart.click();
explicitWait(5);

// Open Personalization window 
driver.switchTo().frame("pmallmodaliframe");

// Add personalization 
EmbroideredTravelCase embroideredTravelCase1 = PageFactory.initElements(driver,pMall_PageObjectRepository.EmbroideredTravelCase.class);
embroideredTravelCase1.SelectColor.click();
embroideredTravelCase1.MonoFirst.sendKeys("F");
embroideredTravelCase1.MonoSecond.sendKeys("S");
embroideredTravelCase1.MonoThird.sendKeys("T");
embroideredTravelCase1.AdditionalProductYes.click();
embroideredTravelCase1.GiftBoxSelect.click();
//Javascript executor
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("document.getElementById('ctpers1339660tg').style = ''" );

explicitWait(5);
embroideredTravelCase1.FontList.click();
explicitWait(2);

ProductPage1.PreviewandAddtoCart.click();
explicitWait(5);

// Preview personalization and Add to Cart

ProductPage1.PersonalizationConfirmationCheckbox.click();
explicitWait(2);

ProductPage1.AddtoCartafterpersonalization.click();


}

public void Checkout1(int ShipType){


String checkoupath = "Checkout.aspx";
String registerpagepath = "Register.aspx";

// Navigate to the checkout page
driver.navigate().to(pmall_url + checkoupath);

// Select shipping address
ShippingCheckout shippingCheckout1 = PageFactory.initElements(driver,pMall_PageObjectRepository.ShippingCheckout.class);
shippingCheckout1.SelectShippingAddress1.click();
explicitWait(10);

// Close the banner on checkout page -- Optional 
CheckoutPage checkoutPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CheckoutPage.class);

try {
	checkoutPage1.NoThanks.click();

} catch (Exception e) {
	System.out.println("The banner didn't appear on checkout page");
}

explicitWait(3);

//Select shipment type on checkout page 
if(ShipType==1){checkoutPage1.EconomyShipping.click();Shipping="Economy";}
else if (ShipType==2){checkoutPage1.StandardShipping.click();Shipping="Standard";}
else if (ShipType==3){checkoutPage1.ExpeditedShipping.click();Shipping="Expedite";}
else if (ShipType==4){checkoutPage1.RushShipping.click();Shipping="Rush";}
else if (ShipType==5){checkoutPage1.CustomerPickUp.click();Shipping="CustomerPickUp";}

explicitWait(3);

//Enter the credit card details

Select s = new Select(checkoutPage1.CardType);
s.selectByVisibleText("Visa");
explicitWait(1);//for watching the script
checkoutPage1.NameOnCard.sendKeys("Test Order");
explicitWait(1);//for watching the script
checkoutPage1.CardNumber.sendKeys("4242424242424242");
explicitWait(1);//for watching the script
checkoutPage1.CVV.sendKeys("111");
explicitWait(1);//for watching the script
Select s1 = new Select(checkoutPage1.ExpMonth);
s1.selectByVisibleText("01 - Jan");
explicitWait(1);//for watching the script
Select s2 = new Select(checkoutPage1.ExpYear);
s2.selectByValue("2019");
explicitWait(1);//for watching the script


// Place Order
checkoutPage1.PlaceYourOrder.click();
explicitWait(5);

// Copying and printing the order number generated
OrderConfirmation orderConfirmation1 = PageFactory.initElements(driver,pMall_PageObjectRepository.OrderConfirmation.class);
String ordernumber = orderConfirmation1.OrderNumber.getText();

if (ShipType!=5){
System.out.println("The order number generated is " + ordernumber + " with Shipping Type: " + Shipping + " Shipping");
}
else {System.out.println("The order number generated is " + ordernumber + " with Shipping Type: " + Shipping );}
driver.navigate().to(pmall_url + registerpagepath);

//end of function
}



}
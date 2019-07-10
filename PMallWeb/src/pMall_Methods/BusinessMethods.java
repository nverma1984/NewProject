package pMall_Methods;

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
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
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
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	LoginPage1.SignInButton.click();
}

public void AddOrnamentHooktoCart(){

String productpath;
productpath =  "Rotating-Ornament-Hook-p21994.prod?sdest=Search&sdestid=86522747";
driver.navigate().to(pmall_url + productpath);
ProductPage ProductPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.ProductPage.class);
ProductPage1.AddtoCartButtonPP.click();
explicitWait(10);
}

public void AddEmbroideredTravelCaseToCart(){
String productpath;
productpath =  "Mens-Personalized-Travel-Case-p17116.prod?sdest=Search&sdestid=86461114";
driver.navigate().to(pmall_url + productpath);
ProductPage ProductPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.ProductPage.class);
ProductPage1.PersonalizeandAdd2Cart.click();
explicitWait(10);
EmbroideredTravelCase embroideredTravelCase1 = PageFactory.initElements(driver,pMall_PageObjectRepository.EmbroideredTravelCase.class);
embroideredTravelCase1.SelectColor.click();
embroideredTravelCase1.MonoFirst.sendKeys("F");
embroideredTravelCase1.MonoSecond.sendKeys("S");
embroideredTravelCase1.MonoThird.sendKeys("T");
}

public void Checkout1(int ShipType){

String checkoupath = "Checkout.aspx";
String registerpagepath = "Register.aspx";
driver.navigate().to(pmall_url + checkoupath);
ShippingCheckout shippingCheckout1 = PageFactory.initElements(driver,pMall_PageObjectRepository.ShippingCheckout.class);
shippingCheckout1.SelectShippingAddress1.click();
explicitWait(10);
CheckoutPage checkoutPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CheckoutPage.class);
try {
	checkoutPage1.NoThanks.click();

} catch (Exception e) {
	System.out.println("The banner didn't appear on checkout page");
}
explicitWait(3);


if(ShipType==1){checkoutPage1.EconomyShipping.click();Shipping="Economy";}
else if (ShipType==2){checkoutPage1.StandardShipping.click();Shipping="Standard";}
else if (ShipType==3){checkoutPage1.ExpeditedShipping.click();Shipping="Expedite";}
else if (ShipType==4){checkoutPage1.RushShipping.click();Shipping="Rush";}
else if (ShipType==5){checkoutPage1.CustomerPickUp.click();Shipping="CustomerPickUp";}

explicitWait(5);

Select s = new Select(checkoutPage1.CardType);
s.selectByVisibleText("Visa");
explicitWait(2);
checkoutPage1.NameOnCard.sendKeys("Test Order");
explicitWait(2);
checkoutPage1.CardNumber.sendKeys("4242424242424242");
explicitWait(2);
checkoutPage1.CVV.sendKeys("111");
explicitWait(2);
Select s1 = new Select(checkoutPage1.ExpMonth);
s1.selectByVisibleText("01 - Jan");
explicitWait(2);
Select s2 = new Select(checkoutPage1.ExpYear);
s2.selectByValue("2019");
explicitWait(2);
checkoutPage1.PlaceYourOrder.click();

explicitWait(10);
OrderConfirmation orderConfirmation1 = PageFactory.initElements(driver,pMall_PageObjectRepository.OrderConfirmation.class);

String ordernumber = orderConfirmation1.OrderNumber.getText();

if (ShipType!=5){
System.out.println("The order number generated is " + ordernumber + " with Shipping Type: " + Shipping + " Shipping");
}
else {System.out.println("The order number generated is " + ordernumber + " with Shipping Type: " + Shipping );}
driver.navigate().to(pmall_url + registerpagepath);


}



}
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
	 String username = new String("neeraj.verma@intsof.com");
	 String password = new String("Neeraj01#");
	 int ShipType;
	 
//-----------------------Launch PMall Web---------------------------------------//	 
public void Launch_pMallweb(){
	launchapp(pmall_url);	
}

//----------------------------Close the pop up on home page--------------------------------//
public void CloseHomePagePopUp(){
	HomePage HomePage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.HomePage.class);
    explicitWait(5);
	try {
		HomePage1.WEP_Close_Bn.click();

	} catch (Exception e) {
    System.out.println("The Homepage pop was not displayed");
	}
}

//-----------------------------------Login to PMall Website-------------------------------------//
public void LogintoPMall(){
	
	explicitWait(3);
	
	driver.navigate().to(pmall_url + "Register.aspx");
	LoginPage LoginPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.LoginPage.class);
	LoginPage1.SignInID.clear();//clear values in text box
	LoginPage1.SignInID.sendKeys(username);
	LoginPage1.SignInPassword.clear();//clear values in text box
	LoginPage1.SignInPassword.sendKeys(password);
	explicitWait(3);	//for watching the script
	LoginPage1.SignInButton.click();
}


public void NavigatetoPersonalizationwindow(){
	//Navigate to the personalization window
		explicitWait(5);
		CommonPersonalizationcontrols ProductPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CommonPersonalizationcontrols.class);
		ProductPage1.PersonalizeandAdd2Cart.click();
		explicitWait(5);
		driver.switchTo().frame("pmallmodaliframe");//switch to pMall iframe, personalization window.
	}



//-----------------------------------------Preview a product-----------------------------------//
public void PreviewProduct(){
	explicitWait(3);	
	CommonPersonalizationcontrols ProductPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CommonPersonalizationcontrols.class);
	ProductPage1.PreviewandAddtoCart.click();
}

//-----------------------------ConfirmandAddTheProducttoCart----------------------------//
public void ConfirmandAddproductToCart(){
	explicitWait(5);
	CommonPersonalizationcontrols ProductPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CommonPersonalizationcontrols.class);
	ProductPage1.PersonalizationConfirmationCheckbox.click();
	explicitWait(2);	
	ProductPage1.AddtoCartafterpersonalization.click();
		
}


//---------------------------Navigate to the checkout page------------------------------//
public void NavigateToCheckoutPage(){

	
	String checkoupath = "Checkout.aspx";
	
	
	// Navigate to the checkout page
	driver.navigate().to(pmall_url + checkoupath);
	//driver.navigate().to("https://www.personalizationmall.com/Checkout.aspx");
	
}

//---------------------------Select Shipping Address------------------------------//


public void SelectShippingAddress(){
	explicitWait(5);
	ShippingCheckout shippingCheckout1 = PageFactory.initElements(driver,pMall_PageObjectRepository.ShippingCheckout.class);
	shippingCheckout1.SelectShippingAddress1.click();
	explicitWait(10);
}

//-----------Close the banner on checkout page if it exists---------------------------------//

public void CloseCheckoutPageBanner(){
	
	CheckoutPage checkoutPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CheckoutPage.class);
	
	try {
		checkoutPage1.NoThanks.click();
	
	} catch (Exception e) {
		System.out.println("The banner didn't appear on checkout page");
	}
	
}


//---------------------------Select Shipment Type-----------------------------//
public void SelectShipment(int ShipType){
	CheckoutPage checkoutPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CheckoutPage.class);
	this.ShipType = ShipType;
	if(ShipType==1){checkoutPage1.EconomyShipping.click();Shipping="Economy";}
	else if (ShipType==2){checkoutPage1.StandardShipping.click();Shipping="Standard";}
	else if (ShipType==3){checkoutPage1.ExpeditedShipping.click();Shipping="Expedite";}
	else if (ShipType==4){checkoutPage1.RushShipping.click();Shipping="Rush";}
	else if (ShipType==5){checkoutPage1.CustomerPickUp.click();Shipping="CustomerPickUp";}
	
}

//---------------------------Enter credit card details-----------------------------//

public void EnterCCDetails(){
	
	explicitWait(3);
	CheckoutPage checkoutPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CheckoutPage.class);
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

}

//-------------------Place order from checkout page and Print Order number from Order confirmation page-----------------------------//

public void PlaceOrder(){
	
	CheckoutPage checkoutPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CheckoutPage.class);
		
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

public void AddOrnamentwith2PhotoToCart(){
//------------------------------- Ornament with Two Photos -------------------------------------------//
	
	String productpath;
	productpath =  "Personalized-Photo-Christmas-Ornament-2-Sided-i47410.item?productid=16799&sdest=Search&sdestid=86877813";
	// Navigate to the product page
	driver.navigate().to(pmall_url + productpath);
	
	//Navigate to the personalization window
	CommonPersonalizationcontrols ProductPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.CommonPersonalizationcontrols.class);
	ProductPage1.PersonalizeandAdd2Cart.click();
	explicitWait(15);
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
	
	//Personalization of other fields	
	Ornamnetwith2Photos1.AdditionalProductRadioOptionYes.click();
	Ornamnetwith2Photos1.SecondOptionalProductRadioOptionNo.click();
	Ornamnetwith2Photos1.GiftBoxRadioYes.click();
	
	PreviewProduct();//PerviewProductandAddtoCart
	ConfirmandAddproductToCart();//Confirm product and add to cart
}



//-----------------------------------Embroidery product without a photo------------------------------------//

public void AddEmbroideredTravelCaseToCart(){

	//Navigate to the product page 
	String productpath;
	productpath =  "Mens-Personalized-Travel-Case-p17116.prod?sdest=Search&sdestid=86461114";
	driver.navigate().to(pmall_url + productpath);
	
	NavigatetoPersonalizationwindow();//Navigate to personalization window
	
	// Add personalization 
	EmbroideredTravelCase embroideredTravelCase1 = PageFactory.initElements(driver,pMall_PageObjectRepository.EmbroideredTravelCase.class);
	embroideredTravelCase1.SelectColor.click();
	embroideredTravelCase1.MonoFirst.sendKeys("F");
	embroideredTravelCase1.MonoSecond.sendKeys("S");
	embroideredTravelCase1.MonoThird.sendKeys("T");
	embroideredTravelCase1.AdditionalProductYes.click();
	embroideredTravelCase1.GiftBoxSelect.click();
	//Java script executor
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('ctpers1339660tg').style = ''" );
		explicitWait(5);
	embroideredTravelCase1.FontList.click();

	PreviewProduct();//PerviewProductandAddtoCart
	ConfirmandAddproductToCart();//Confirm product and add to cart

}

}
package pMall_TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pMall_Methods.BusinessMethods;
import pMall_PageObjectRepository.HomePage;
import pMall_PageObjectRepository.LoginPage;
import pMall_PageObjectRepository.ShippingCheckout;

public class PlaceOrder extends BusinessMethods {
	final int k=2;

@BeforeClass

public void init(){
	
	openbrowser();
}

	@Test(invocationCount=k)
	public void PlaceanOrder(){
		Launch_pMallweb();		
	    CloseHomePagePopUp();
	    for(int i =1;i<=5;i++){
	    LogintoPMall();
	    AddOrnamentHooktoCart();
        AddEmbroideredTravelCaseToCart();
        AddOrnamentwith2PhotoToCart();
	    NavigateToCheckoutPage();
	    SelectShippingAddress();
	    CloseCheckoutPageBanner();
	    SelectShipment(i);
	    EnterCCDetails();
	    PlaceOrder();
	    }	     
	    
	}
	
	@AfterClass

	public void end(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//closebrowser();
	}
	
}

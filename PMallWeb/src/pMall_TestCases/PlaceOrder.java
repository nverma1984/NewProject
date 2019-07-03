package pMall_TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pMall_Methods.BusinessMethods;
import pMall_PageObjectRepository.HomePage;
import pMall_PageObjectRepository.LoginPage;

public class PlaceOrder extends BusinessMethods {

@BeforeClass

public void init(){
	
	openbrowser();
}

	@Test
	public void Login(){
		Launch_pMallweb();		
	    CloseHomePagePopUp();
	    for(int i =1;i<=5;i++){
	    LogintoPMall();
	    AddOrnamentHooktoCart();
	    Checkout1(i);
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
		closebrowser();
	}
	
}

package pMall_TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pMall_Methods.BusinessMethods;
import pMall_PageObjectRepository.HomePage;


public class WelcomeEmailPopUpValidate_001 extends BusinessMethods {

@BeforeClass

public void init(){
	
	openbrowser();
}

	@Test
	public void Login(){
		Launch_pMallweb();		
		HomePage HomePage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.HomePage.class);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(HomePage1.WEP_Close_Bn.getText());
		
		HomePage1.WEP_Close_Bn.click();
		}
	
	@AfterClass

	public void end(){		
		//closebrowser();
	}
	
}

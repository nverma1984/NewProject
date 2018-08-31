package pMall_TestCases_FailOverTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pMall_Methods.BusinessMethods;
import pMall_PageObjectRepository.HomePage;


public class FailOver_WelcomeEmailPopUp_001 extends BusinessMethods {

	
@BeforeClass

public void init(){
	
	openbrowser();
}

	@Test
	public void Login(){
		Launch_pMallweb();		
		HomePage HomePage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.HomePage.class);
		//System.out.println(HomePage1.WEP_Close_Bn.getText());
		HomePage1.WEP_Close_Bn.click();
		}
	
	@AfterClass

	public void end(){		
		//closebrowser();
	}
	
}

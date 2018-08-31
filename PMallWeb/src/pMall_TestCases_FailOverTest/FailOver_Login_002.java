package pMall_TestCases_FailOverTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pMall_Methods.BusinessMethods;
import pMall_PageObjectRepository.HomePage;
import pMall_PageObjectRepository.LoginPage;


public class FailOver_Login_002 extends BusinessMethods {

	
@BeforeClass

public void init(){
	
	openbrowser();
}

	@Test
	public void Login(){
		Launch_pMallweb();		
		HomePage HomePage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.HomePage.class);
		System.out.println(HomePage1.WEP_Close_Bn.getText());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HomePage1.WEP_Close_Bn.click();
		HomePage1.SignIn.click();
		LoginPage LoginPage1 = PageFactory.initElements(driver,pMall_PageObjectRepository.LoginPage.class);
		LoginPage1.SignInID.sendKeys("neeraj.verma@decorist.com");
		LoginPage1.SignInPassword.sendKeys("Neeraj01#");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Desired value is "+LoginPage1.SignInButton.getAttribute("name"));
		LoginPage1.SignInButton.click();

	
		
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

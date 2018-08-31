package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath="//span[text()='close']")
    public WebElement WEP_Close_Bn;
	
	@FindBy(xpath="//div[text()='Welcome ']//a[text()= '(Sign In)']")
    public WebElement SignIn;
	
	
}

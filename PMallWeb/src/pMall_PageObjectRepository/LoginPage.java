package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy(xpath= "//input[@name='ctl00$mainContent$txtEmail']")
	public WebElement SignInID;
	
	@FindBy(xpath= "//input[@name='ctl00$mainContent$txtPassword']")
	public WebElement SignInPassword;

	@FindBy(xpath= "//input[@name='ctl00$mainContent$cmdSubmit']")
	public WebElement SignInButton;
	
	
}

package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterLogin {
	
	@FindBy(xpath= "//input[@id='searchBox']")
	public WebElement SearchBar;
	
}

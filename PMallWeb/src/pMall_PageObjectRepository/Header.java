package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {
	
	@FindBy(xpath= "//a[href='https://www.personalizationmall.com/Cart.aspx']")
	public WebElement CartIcon;
	
}

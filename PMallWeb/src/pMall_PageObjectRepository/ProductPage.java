package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	
	@FindBy(xpath= "//input[@name='ctl00$mainContent$addToCart$addToCartButton']")
	public WebElement AddtoCartButtonPP;
	
	@FindBy(xpath= "//button[@id='btnPersonalize']")
	public WebElement PersonalizeandAdd2Cart;
	
}

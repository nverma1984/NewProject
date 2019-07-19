package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonPersonalizationcontrols {
	
	@FindBy(xpath= "//input[@name='ctl00$mainContent$addToCart$addToCartButton']")
	public WebElement AddtoCartButtonPP;
	
	@FindBy(xpath= "//button[@id='btnPersonalize']")
	public WebElement PersonalizeandAdd2Cart;
	
	@FindBy(xpath= "//input[@id='checkConfirm']")
	public WebElement PersonalizationConfirmationCheckbox;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_addToCart_addToCartButton']")
	public WebElement AddtoCartafterpersonalization;
	
	@FindBy(xpath= "//a[@id='cmdShowPreview']")
	public WebElement PreviewandAddtoCart;
	
}

package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmbroideredTravelCase {
	
	@FindBy(xpath= "//iframe[@id='pmallmodaliframe']")
	public WebElement Personizationiframe;

	@FindBy(xpath= "//li[@id='ImgLI_0_1']//a")
	public WebElement SelectColor;
	
	@FindBy(xpath= "//input[@id='monpers133966rd0_0']")
	public WebElement MonoFirst;

	@FindBy(xpath= "//input[@id='monpers133966rd0_1']")
	public WebElement MonoSecond;

	@FindBy(xpath= "//input[@id='monpers133966rd0_2']")
	public WebElement MonoThird;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_pers_pers91791_buttons_0']")
	public WebElement AdditionalProductYes;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_pers_ctl27_buttons_0']")
	public WebElement GiftBoxSelect;

	@FindBy(xpath= "//a[@id='cmdShowPreview']")
	public WebElement PreviewandAddtoCart;
	
	@FindBy(xpath= "//div[@id='ctpers1339660tg']//ul/li")
	public WebElement FontList;
	
	@FindBy(xpath= "//input[@id='checkConfirm']")
	public WebElement PersonalizationConfirmationCheckbox;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_addToCart_addToCartButton']")
	public WebElement AddtoCartafterpersonalization;
	
}

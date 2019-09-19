package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Ornamnetwith2Photos {
	
	@FindBy(xpath= "//img[@id='ctl00_mainContent_pers_pers80099_selectPhotoImage']")
	public WebElement Photo1;
	
		@FindBy(xpath= "//input[@id='hFinderUploadFile']")
	public WebElement FileUploadButton;
	
	@FindBy(xpath= "//input[@id='checkConfirmPhoto']")
	public WebElement ConfirmationCheckbox;
	
	@FindBy(xpath= "//a[@id='saveCrop']")
	public WebElement SaveButton;
	
	@FindBy(xpath= "//img[@id='ctl00_mainContent_pers_pers80102_selectPhotoImage']")
	public WebElement Photo2;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_pers_pers80100_buttons_0']")
	public WebElement AdditionalProductRadioOptionYes;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_pers_pers127880_buttons_1']")
	public WebElement SecondOptionalProductRadioOptionNo;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_pers_ctl58_buttons_0']")
	public WebElement GiftBoxRadioYes;
	
	@FindBy(xpath= "//input[@id='checkConfirm']")
	public WebElement PersonalizationConfirmationCheckbox;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_addToCart_addToCartButton']")
	public WebElement AddtoCartafterpersonalization;
	
	@FindBy(xpath= "//a[@id='cmdShowPreview']")
	public WebElement PreviewandAddtoCart;
}

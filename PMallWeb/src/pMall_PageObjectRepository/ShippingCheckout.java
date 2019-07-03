package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingCheckout {
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_viewAddressBookControl_listAddresses_ctl00_cmdSendDefaultAddress']")
	public WebElement SelectShippingAddress1;
	
}

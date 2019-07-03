package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage {
	
	@FindBy(xpath= "//img[@src='images/popdownRight.png']")
	public WebElement NoThanks;
	
	//- Shipment Type radio options -//
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_listShipMethod_ctl00_rdShipMethod']")
	public WebElement EconomyShipping;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_listShipMethod_ctl01_rdShipMethod']")
	public WebElement StandardShipping;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_listShipMethod_ctl02_rdShipMethod']")
	public WebElement ExpeditedShipping;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_listShipMethod_ctl03_rdShipMethod']")
	public WebElement RushShipping;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_listShipMethod_ctl04_rdShipMethod']")
	public WebElement CustomerPickUp;
	
	//- Credit card fields--//
	
	@FindBy(xpath= "//select[@id='ctl00_mainContent_cardType']")
	public WebElement CardType;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_nameOnCard']")
	public WebElement NameOnCard;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_cardNumber']")
	public WebElement CardNumber;
	
	@FindBy(xpath= "//input[@id='ctl00_mainContent_validationNumber']")
	public WebElement CVV;
	
	@FindBy(xpath= "//select[@id='ctl00_mainContent_expMonth']")
	public WebElement ExpMonth;
	
	@FindBy(xpath= "//select[@id='ctl00_mainContent_expYear']")
	public WebElement ExpYear;
	
	@FindBy(xpath= "//input[@id='cmdPlaceOrder']")
	public WebElement PlaceYourOrder;
	
}

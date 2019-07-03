package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmation {
	
	@FindBy(xpath= "//p[text()='Your order# is ']//a")
	public WebElement OrderNumber;
	
}

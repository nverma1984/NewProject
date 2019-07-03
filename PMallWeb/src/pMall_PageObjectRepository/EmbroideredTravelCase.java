package pMall_PageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmbroideredTravelCase {

	@FindBy(xpath= "//li[@id='ImgLI_0_1']//a")
	public WebElement SelectColor;
	
	@FindBy(xpath= "//input[@id='monpers133966rd0_0']")
	public WebElement MonoFirst;

	@FindBy(xpath= "//input[@id='monpers133966rd0_1']//a")
	public WebElement MonoSecond;

	@FindBy(xpath= "//input[@id='monpers133966rd0_2']//a")
	public WebElement MonoThird;

	
}

package SeleniumFrameworkDesign.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SeleniumFrameworkDesign.AbstractComponemt.Abstractclass;

public class CartPage extends Abstractclass {

	WebDriver driver;
	public  CartPage (WebDriver driver) {
		//use super method for  calling driver value 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//	   List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css=".totalRow button")
    WebElement checkoutbtn;
	@FindBy(css=".cartSection h3")
	private List<WebElement> productTitle;
	
	public Boolean VerifyProductDisplay(String ProductName) {
		  Boolean match = productTitle.stream().anyMatch(item ->item.getText().equalsIgnoreCase("ZARA COAT 3"));
		  return match;
	}
	
	public CheckoutPage gotoCheckout() {
		checkoutbtn.click();
		CheckoutPage checkoutpage =new CheckoutPage(driver);
		return checkoutpage;
		
		
		
	}
	
	
	
	
		
	
	
}

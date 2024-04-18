package SeleniumFrameworkDesign.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SeleniumFrameworkDesign.AbstractComponemt.Abstractclass;

public class OrderPage extends Abstractclass {

	WebDriver driver;
	public  OrderPage (WebDriver driver) {
		//use super method for  calling driver value 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//	   List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));


	@FindBy(css=".tr td:nth-child(3)")
	private List<WebElement> OrderList;
	
	public Boolean VerifyOrderProductDisplay(String ProductName) {
		  Boolean match = OrderList.stream().anyMatch(item1 ->item1.getText().equalsIgnoreCase(ProductName));
		  return match;
	}
	
	
	
	
	
		
	
	
}

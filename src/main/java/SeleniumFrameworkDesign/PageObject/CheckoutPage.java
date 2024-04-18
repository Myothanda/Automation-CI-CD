package SeleniumFrameworkDesign.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SeleniumFrameworkDesign.AbstractComponemt.Abstractclass;

public class CheckoutPage extends Abstractclass {

	WebDriver driver;
	public  CheckoutPage (WebDriver driver) {
		//use super method for  calling driver value 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//	   List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css="[placeholder='Select Country']")
    WebElement country;
	@FindBy(css=".action__submit")
	WebElement submit;
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
    WebElement selectCountry;
	
	By results=By.cssSelector(".ta-results");
	
	
	
	public void SelectCoutry(String countryName) {
		 Actions a= new Actions(driver);
		 a.sendKeys(country,countryName).build().perform();
		 WaitElementAppear(results);		    
		 selectCountry.click();
		
	}
	
	public ComfirmationPage submitOrder() {
		submit.click();
		ComfirmationPage comfirmationpage=new ComfirmationPage(driver);
		return comfirmationpage;
		
	}
	
	
	
		
	
	
}

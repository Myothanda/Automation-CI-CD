package SeleniumFrameworkDesign.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SeleniumFrameworkDesign.AbstractComponemt.Abstractclass;

public class ComfirmationPage extends Abstractclass {

	WebDriver driver;
	public  ComfirmationPage (WebDriver driver) {
		//use super method for  calling driver value 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//	   List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css=".hero-primary")
    WebElement comfirmationmessage;
	
	public String verifycomfirmationMessage() {
		
		return comfirmationmessage.getText();
	}
		
	}
	
	
	
	
		
	
	


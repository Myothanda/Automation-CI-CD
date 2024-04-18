package SeleniumFrameworkDesign.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponemt.Abstractclass;

public class LandingPage extends Abstractclass{

	WebDriver driver;
	public  LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;
	
	// Add Action Method 
	
	public ProductCatalogue ApplicationSubmit(String name, String password ) {
		//action for completed sendkeys values 
		
		userEmail.sendKeys(name);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		return productCatalogue;
		
		}
	
	public String getErrorMessage() {
		WaitforWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}

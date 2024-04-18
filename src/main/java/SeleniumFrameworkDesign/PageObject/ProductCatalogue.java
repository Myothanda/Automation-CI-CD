package SeleniumFrameworkDesign.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponemt.Abstractclass;

public class ProductCatalogue extends Abstractclass {

	WebDriver driver;
	public  ProductCatalogue (WebDriver driver) {
		//use super method for  calling driver value 
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
//   List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animatin")
	WebElement spinner;
	
	By productBy = By.cssSelector(".mb-3");
	By addtoCart=By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductList() throws InterruptedException {
		Thread.sleep(3000);
		WaitElementAppear(productBy);
		return products;
	}
	
	public WebElement getElementbyName(String productName) {
		WebElement prod =products.stream().filter(s ->
	   s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	    return prod;
	}
	
	public void addToCartElement(String productName ) throws InterruptedException {
		WebElement prod= getElementbyName(productName);
		prod.findElement (addtoCart).click();
		WaitElementAppear(toastMessage);
		WaitforElementDisappear(spinner);
		
	}
	
	
	
	
		
	
	
}

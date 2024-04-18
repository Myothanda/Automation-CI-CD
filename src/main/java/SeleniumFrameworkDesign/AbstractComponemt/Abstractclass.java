package SeleniumFrameworkDesign.AbstractComponemt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumFrameworkDesign.PageObject.CartPage;
import SeleniumFrameworkDesign.PageObject.OrderPage;

public class Abstractclass {
	
	WebDriver driver;
	public Abstractclass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartbutton;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderbutton;

	public void WaitElementAppear(By findBy) {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void WaitforWebElementToAppear(WebElement findBy) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		}
		
	public void WaitforElementDisappear(WebElement sls) throws InterruptedException  {
		Thread.sleep(1000);
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(sls));
	}
	
	public CartPage gotoCardpage() {
		cartbutton.click();
		CartPage cartpage=new CartPage(driver);
		return cartpage;
		
	}
	
	public OrderPage gotoOrderPage(){
		orderbutton.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
	}
}
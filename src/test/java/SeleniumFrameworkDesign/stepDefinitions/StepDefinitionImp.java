package SeleniumFrameworkDesign.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SeleniumFrameworkDesign.PageObject.CartPage;
import SeleniumFrameworkDesign.PageObject.CheckoutPage;
import SeleniumFrameworkDesign.PageObject.ComfirmationPage;
import SeleniumFrameworkDesign.PageObject.LandingPage;
import SeleniumFrameworkDesign.PageObject.ProductCatalogue;
import SeleniumFrameworkDesign.testcompment.BaseText;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImp extends BaseText {
	public LandingPage landingpage;
	public ProductCatalogue productCatalogue;
	public ComfirmationPage comfirmationpage;
    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException{
    	
    	landingpage =lauchApplication();
    	
    }
    
    @Given("^Logged in with username (.+) and password (.+)$")
    
    public void logged_in_with_username_and_password(String username, String padssword) {
    	
    	productCatalogue= landingPage.ApplicationSubmit(username,padssword);
     
    }
    
    @When("^I add product (.+) to Cart$") 
    public void I_add_product_to_Cart (String productName) throws InterruptedException {
    	List<WebElement> products= productCatalogue.getProductList();
		productCatalogue.addToCartElement(productName);
    }
    
    @When("^Checkout (.+) and submit the order$")
    public void Checkout_and_submit_the_order(String productName) throws InterruptedException{
    	
    	CartPage cartpage= productCatalogue.gotoCardpage();
		Boolean match=cartpage.VerifyProductDisplay(productName);
	    Assert.assertTrue(match);
	    JavascriptExecutor js= (JavascriptExecutor ) driver;
	    js.executeScript("window.scrollBy(0,500)");
	   Thread.sleep(5000);

	    CheckoutPage checkoutpage =cartpage.gotoCheckout();
	    checkoutpage.SelectCoutry("india");
	     comfirmationpage=checkoutpage.submitOrder();  	
    }
    
    @Then("{string} message is displayed on ConfirmationPage")
    public void message_is_displayed_on_ConfirmationPage(String str){
    	String comfirmationMessage= comfirmationpage.verifycomfirmationMessage();
	    Assert.assertTrue(comfirmationMessage.equalsIgnoreCase(str));
	    
    }
    @Then("^\"([^\"]*)\"message is displayed$")
    public void something_message_is_displayed (String strArg1) throws Throwable {
    Assert.assertEquals(strArg1, landingPage.getErrorMessage());
    driver.close();
  
    }
}



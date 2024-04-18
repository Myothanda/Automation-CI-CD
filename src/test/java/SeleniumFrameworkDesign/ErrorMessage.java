package SeleniumFrameworkDesign;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.PageObject.CartPage;
import SeleniumFrameworkDesign.PageObject.CheckoutPage;
import SeleniumFrameworkDesign.PageObject.ComfirmationPage;
import SeleniumFrameworkDesign.PageObject.ProductCatalogue;
import SeleniumFrameworkDesign.testcompment.BaseText;

public class ErrorMessage extends BaseText {
	
	@Test(groups= {"ErrorHlanding"})
	public void verifyErrorMessage() {

	String productName= "ZARA COAT 3";	
	landingPage.ApplicationSubmit("myo123@gmail.com","Chichu18@123");
	Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage());
	}
	
	@Test
	public void VerifyProcutpageErrorMessage() throws IOException, InterruptedException
    {
		// TODO Auto-generated method stub

		String productName= "ZARA COAT 3";	
		landingPage.ApplicationSubmit("m1998@gmail.com","Chichu1998@123");
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		List<WebElement> products= productCatalogue.getProductList();
		productCatalogue.addToCartElement(productName);
		CartPage cartpage= productCatalogue.gotoCardpage();
		Boolean match=cartpage.VerifyProductDisplay("COAT 33");
	    Assert.assertFalse(match);
		    
	}

}

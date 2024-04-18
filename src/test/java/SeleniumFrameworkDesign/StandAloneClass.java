package SeleniumFrameworkDesign;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SeleniumFrameworkDesign.PageObject.CartPage;
import SeleniumFrameworkDesign.PageObject.CheckoutPage;
import SeleniumFrameworkDesign.PageObject.ComfirmationPage;
import SeleniumFrameworkDesign.PageObject.OrderPage;
import SeleniumFrameworkDesign.PageObject.ProductCatalogue;
import SeleniumFrameworkDesign.testcompment.BaseText;



public class StandAloneClass extends BaseText {
	
	//String productName= "ZARA COAT 3";
	@Test(dataProvider="getData",groups={"Phurase"})
	public void SubmitOrder(HashMap<String,String>input) throws IOException, InterruptedException
    {
		// TODO Auto-generated method stub
	
	
		landingPage.ApplicationSubmit(input.get("email"),input.get("password"));
		ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		List<WebElement> products= productCatalogue.getProductList();
		productCatalogue.addToCartElement(input.get("product"));
		CartPage cartpage= productCatalogue.gotoCardpage();
		Boolean match=cartpage.VerifyProductDisplay(input.get("product"));
	    Assert.assertTrue(match);
	    JavascriptExecutor js= (JavascriptExecutor ) driver;
	    js.executeScript("window.scrollBy(0,500)");
	    Thread.sleep(5000);
;
	    cartpage.gotoCheckout();
	    
	    CheckoutPage checkoutpage =new CheckoutPage(driver);
	    checkoutpage.SelectCoutry("india");
	    checkoutpage.submitOrder();
	    
	    ComfirmationPage comfirmationpage=new ComfirmationPage(driver);
	    String comfirmationMessage= comfirmationpage.verifycomfirmationMessage();
	    Assert.assertTrue(comfirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	    
	  	}
    //To verify ZARA COAT 3 is displaying in the order page 
	public void OrderHistoryTest() {
    	String productName="ZARA COAT 3";
    	landingPage.ApplicationSubmit("myo123@gmail.com","Chichu1998@123"); 
    	ProductCatalogue productCatalogue=new ProductCatalogue(driver);
    	productCatalogue.gotoOrderPage();
    	OrderPage orderpage= new OrderPage(driver);
	    Assert.assertFalse(orderpage.VerifyOrderProductDisplay(productName));
    }
	
	
	
	//Extend Report ----
	
    @DataProvider 
	public Object[][] getData() throws IOException  {
		
    
    List<HashMap<String,String>> data= getJsonDataToMap("D:\\new project\\SeleniumFrameworkDesign\\src\\test\\java\\SeleniumFrameworkDesign\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
}
    	
		
	}
  


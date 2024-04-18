package SeleniumFrameworkDesign.testcompment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFrameworkDesign.PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseText {
	
	public WebDriver  driver;
	public LandingPage landingPage;
	public WebDriver initializeDriver() throws IOException{
		
	//properties 	
	Properties prop= new Properties ();
	FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//SeleniumFrameworkDesign//resources//GobalData.properties");
	prop.load(fis);
	String browsername =prop.getProperty("browser");
	
	if (browsername.equalsIgnoreCase("Chrome"))
	{
		
	    WebDriverManager.chromedriver().setup();
	    driver =new ChromeDriver();
	    
	   
	}
			
	else if (browsername.equalsIgnoreCase("firefox"))
	{
			//firefox
		
			}
	
	else if (browsername.equalsIgnoreCase("edge"))
	{
			//edge
		
			}
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    return  driver;
    
  
    }
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		//Read Json data to String 
		String jsonContent= FileUtils.readFileToString(new File(filePath),
		StandardCharsets.UTF_8);
	
	   // Convert Json to HashMap // need to call Jackson data bind
	ObjectMapper mapper= new  ObjectMapper();
		 List<HashMap<String,String>> data =mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){
			 
		 });
		return data;
	}
	
	public String getScreenshot(String testCaseName ,WebDriver driver) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dr")+"//reports//"+testCaseName+".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dr")+ "//reports//"+testCaseName+".png";
	}
	
	@BeforeMethod(alwaysRun=true)
	  public LandingPage lauchApplication() throws IOException {        
	    	
	    	WebDriver driver= initializeDriver();
	    	landingPage =new LandingPage(driver);
			landingPage.goTo();
	        return landingPage;
	 

	}
	@AfterMethod(alwaysRun=true)
	public void TearDown() {
		
	driver.quit();
	
	}
	
}

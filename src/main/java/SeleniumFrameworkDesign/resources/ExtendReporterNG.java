package SeleniumFrameworkDesign.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class ExtendReporterNG{
	
	 public static ExtentReports config() {
	    	//ExtendReports, ExtenSparkReport
	    	String path=System.getProperty("user.dr")+"//reports//index.html";
	    	ExtentSparkReporter report= new ExtentSparkReporter(path);
	    	report.config().setReportName("Web Automation Testing Report ");
	    	report.config().setDocumentTitle("Test Reports");
	    	
	    	 ExtentReports extent= new ExtentReports();
	    	 extent.attachReporter(report);
	    	 extent.setSystemInfo("Tester", "Myo");
	    	 return extent;
		}
}

package test.java;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
//import main.java.utils.Constants;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentTest logger;
    public static ExtentReports extent;

    @BeforeTest
    public void beforetestmethod()
    {
    htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport.html");
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setDocumentTitle("Automation Report");
    htmlReporter.config().setReportName("Automation Test Results");
    htmlReporter.config().setTheme(Theme.DARK );
//add
    extent= new ExtentReports();
    extent.attachReporter(htmlReporter);
    extent.setSystemInfo("Automation Tester", "Mansoor Ali");
    }



    @BeforeMethod
 // @Parameters(value = {"browsername"})

    public void Launch_Site(Method testMethod) {
    logger=extent.createTest(testMethod.getName());
    browser_setup("chrome");
    driver.manage().window().maximize();
    driver.get(Constants.url);
    System.out.println("Launch Site");
    }

    @AfterMethod
    public void AfterMethod(ITestResult result)
    {
     if (result.getStatus()== ITestResult.SUCCESS){
       String methodName= result.getMethod().getMethodName();
       String logText= "Test Case: " + methodName + "passed";
         Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
         logger.log(Status.PASS, m );
     }
     else if (result.getStatus()== ITestResult.FAILURE)
     {
            String methodName= result.getMethod().getMethodName();
            String logText= "Test Case: " + methodName + "Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, m );
     }



    //driver.close();
    }



    @AfterTest
    public void After_test()
    {

        extent.flush();

    }



    public void browser_setup(String browsername)
    {
        if (browsername.equalsIgnoreCase( "chrome"))
        {   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "Drivers" + File.separator + "chromedriver.exe" );
            driver= new ChromeDriver();
        }

    }

    public void impwait(int x)
    {
        driver.manage().timeouts().implicitlyWait(x, TimeUnit.SECONDS) ;

    }

}





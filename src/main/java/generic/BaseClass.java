package generic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends FileUtils {

	public WebDriver driver;
	public FileUtils fu = new FileUtils();
	public ExtentHtmlReporter htmlReport ;
	public static ExtentReports reports;
	public static ExtentTest test;
	public WebDriverUtils wu = new WebDriverUtils();
	
	@BeforeSuite
	public void bsConfig() throws SQLException
	{
		con = fu.getCon();
		System.out.println("Database Connected");
		htmlReport = new ExtentHtmlReporter(AutoConstant.reportPath);
		htmlReport.config().setDocumentTitle("SillRaryReport");
		htmlReport.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(htmlReport);
		fu.getCon();
	}
	
	@BeforeMethod
	public void openApp() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getPropertyData("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeApp(ITestResult res)
	{
		int status = res.getStatus();
		String name = res.getName();
		
		if(status == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, res.getName()+ " TestCase Failed");
			test.log(Status.FAIL, res.getThrowable()+" TestCase Failed");
		}
		else if(status == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, res.getName()+ " TestCase Failed");
		}
		else
		{
			test.log(Status.SKIP, res.getName()+ " TestCase Failed");
		}
		
		if(status==2)
		{
			Photo p = new Photo();
			p.getScreenShot(driver, name);
		}
		driver.quit();
	}
	
	@AfterSuite
	public void asConfig() throws SQLException
	{
		htmlReport.flush();
		reports.flush();
		fu.closeCon();
		System.out.println("database closed");
	}
}

package generic;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Photo {

	public void getScreenShot(WebDriver driver, String name)
	{
		Date d = new Date();
		String currentDate = d.toString().replace(":", "-");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(AutoConstant.photoPath+currentDate+name+".png");
	}
}

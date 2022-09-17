package generic;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils {

	public void mouseHover(WebDriver driver, WebElement ele)
	{
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public void doubleClick(WebDriver driver, WebElement ele)
	{
		Actions a = new Actions(driver);
		a.doubleClick(ele).perform();
	}
	
	public void rightClick(WebDriver driver, WebElement ele)
	{
		Actions a = new Actions(driver);
		a.contextClick(ele).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement ele1 , WebElement ele2)
	{
		Actions a = new Actions(driver);
		//a.dragAndDrop(ele1, ele2).perform();
		a.clickAndHold(ele1).moveToElement(ele2).release().perform();
	}
	
	public void dropDown(WebElement ele, String text)
	{
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}
	
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToFrame(WebDriver driver)
	{
		driver.switchTo().frame(0);
	}
	
	public void switchBackFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public void switchTabs(WebDriver driver)
	{
		Set<String> child = driver.getWindowHandles();
		
		for(String e : child)
		{
			driver.switchTo().window(e);
		}
	}
	
	public void scroll(WebElement ele, WebDriver driver)
	{
		Point loc = ele.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
}

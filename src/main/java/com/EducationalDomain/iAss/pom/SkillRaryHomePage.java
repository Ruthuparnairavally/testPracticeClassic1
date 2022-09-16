package com.EducationalDomain.iAss.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillRaryHomePage {

	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsBtn;
	
	@FindBy(xpath="(//a[text()=' SkillRary Demo APP'])[2]")
	private WebElement skillRaryDemo;
	
	public SkillRaryHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getGearsBtn() {
		return gearsBtn;
	}

	public WebElement getSkillRaryDemo() {
		return skillRaryDemo;
	}
	
	public SkillRaryDemoPage demoApp(WebDriver driver)
	{
		gearsBtn.click();
		skillRaryDemo.click();
		return new SkillRaryDemoPage(driver);
	}
}

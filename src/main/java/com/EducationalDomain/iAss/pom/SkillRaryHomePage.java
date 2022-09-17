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

	@FindBy(xpath="//a[text()=' Contact Us ']")
	private WebElement contactUs;
	
	@FindBy(name="q")
	private WebElement searchtb;
	
	

	@FindBy(xpath="//input[@value='go']")
	private WebElement search;
	
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
	
	public WebElement contact()
	{
		return contactUs;
	}
	
	public ContactsPage contactUs(WebDriver driver)
	{
		contactUs.click();
		return new ContactsPage(driver);
	}
	
	public WebElement getSearchtb() {
		return searchtb;
	}

	public WebElement getSearch() {
		return search;
	}
	
	public CoreJavaPage searchCourse(String text, WebDriver driver)
	{
		searchtb.sendKeys(text);
		search.click();	
		return new CoreJavaPage(driver);
	}
}

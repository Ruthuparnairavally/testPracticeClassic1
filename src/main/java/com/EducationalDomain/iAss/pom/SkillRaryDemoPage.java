package com.EducationalDomain.iAss.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillRaryDemoPage {

	@FindBy(xpath="//a[text()='COURSE']")
	private WebElement course;
	
	@FindBy(xpath="//button[@class='dropbtn']/following-sibling::div//a[text()='Selenium Training']")
	private WebElement seleniumTraining;
	
	@FindBy(name="addresstype")
	private WebElement dropdown;
	
	public SkillRaryDemoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement coursetb()
	{
		return course;
	}
	
	public WebElement seleniumTraining()
	{
		return seleniumTraining;
	}
	
	public WebElement drpDown()
	{
		return dropdown;
	}
	
	public AddToCartPage cartPage(WebDriver driver)
	{
		seleniumTraining.click();
		return new AddToCartPage(driver);
	}
}

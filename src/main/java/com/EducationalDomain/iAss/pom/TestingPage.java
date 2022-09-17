package com.EducationalDomain.iAss.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingPage {

	@FindBy(xpath="//span[text()='19']")
	private WebElement price;
	
	@FindBy(xpath="//a[text()='munit testing ']")
	private WebElement coursename;
	
	public TestingPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPrice()
	{
		return price;
	}
	
	public WebElement getCourse()
	{
		return coursename;
	}
}

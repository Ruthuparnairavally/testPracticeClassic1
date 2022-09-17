package com.EducationalDomain.iAss.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreJavaPage {

	@FindBy(xpath="//a[text()=' Core Java For Selenium Trainin']")
	private WebElement corejava;
	
	public CoreJavaPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getjava()
	{
		return corejava;
	}
	
	public WishListPage javaSel(WebDriver driver)
	{
		corejava.click();
		return new WishListPage(driver);
	}
}

package com.EducationalDomain.iAss.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

	@FindBy(id="add")
	private WebElement plusBtn;
	
	@FindBy(xpath="//button[text()=' Add to Cart']")
	private WebElement addToCart;
	
	public AddToCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement addbtn()
	{
		return plusBtn;
	}
	
	public WebElement cartbtn()
	{
		return addToCart;
	}
	
	public void cart()
	{
		addToCart.click();
	}
	
}

package com.EducationalDomain.iAss.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(name="name")
	private WebElement fullname;
	
	@FindBy(name="sender")
	private WebElement email;
	
	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(name="message")
	private WebElement message;
	
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendbtn; 
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFullname() {
		return fullname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSuject() {
		return subject;
	}

	public WebElement getMessage() {
		return message;
	}
	
	public void send(String name, String mail,  String sub, String messg) throws InterruptedException
	{
		fullname.sendKeys(name);
		Thread.sleep(2000);
		email.sendKeys(mail);
		subject.sendKeys(sub);
		message.sendKeys(messg);
		sendbtn.click();
	}
}

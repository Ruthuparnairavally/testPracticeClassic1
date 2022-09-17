package com.EcommereceDomain.iAss.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EducationalDomain.iAss.pom.ContactsPage;
import com.EducationalDomain.iAss.pom.SkillRaryHomePage;

import generic.BaseClass;

public class TestCase2 extends BaseClass{

	@Test(dataProvider = "getData")
	public void tc2(String name, String email, String sub, String msg) throws InterruptedException, IOException
	{
		test = reports.createTest("tc2");
		
		SkillRaryHomePage sh = new SkillRaryHomePage(driver);
		wu.scroll(sh.contact(), driver);
		ContactsPage cp = sh.contactUs(driver);
		cp.send(name, email, sub, msg);
		Thread.sleep(5000);
		
		Assert.assertEquals(driver.getTitle(), fu.getPropertyData("title2"));
	}
}

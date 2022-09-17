package com.EcommereceDomain.iAss.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EducationalDomain.iAss.pom.AddToCartPage;
import com.EducationalDomain.iAss.pom.SkillRaryDemoPage;
import com.EducationalDomain.iAss.pom.SkillRaryHomePage;

import generic.BaseClass;

public class TestCase1 extends BaseClass{

	@Test
	public void tc1() throws IOException
	{
		test=reports.createTest("tc1");
		SkillRaryHomePage sh = new SkillRaryHomePage(driver);
		SkillRaryDemoPage sd = sh.demoApp(driver);
		wu.switchTabs(driver);
		wu.mouseHover(driver, sd.coursetb());
		AddToCartPage ac = sd.cartPage(driver);
		wu.doubleClick(driver, ac.addbtn());
		ac.cart();
		wu.alertAccept(driver);
		
		Assert.assertEquals(driver.getTitle(), fu.getPropertyData("title1"));
	}
}

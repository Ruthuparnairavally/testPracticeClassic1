package com.EcommereceDomain.iAss.scripts;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.EducationalDomain.iAss.pom.SkillRaryDemoPage;
import com.EducationalDomain.iAss.pom.SkillRaryHomePage;
import com.EducationalDomain.iAss.pom.TestingPage;

import generic.BaseClass;

public class TestCase3 extends BaseClass{

	@Test
	public void tc3() throws EncryptedDocumentException, IOException, InterruptedException, SQLException
	{
		test=reports.createTest("tc3");
		
		SkillRaryHomePage sh = new SkillRaryHomePage(driver);
		SkillRaryDemoPage sd = sh.demoApp(driver);
		wu.switchTabs(driver);
		String title =  fu.excelData("Sheet2", 1, 0);
		wu.dropDown(sd.drpDown(), title);
		TestingPage tp = new TestingPage(driver);
		String price = tp.getPrice().getText();
		String course = tp.getCourse().getText();
		
		String query = "Select * from testData";
		String expcourse = fu.getDatafrmDb(query, course, 1);
		String exppprice = fu.getDatafrmDb(query, price, 2);
		
		Assert.assertEquals(price, exppprice);
		Assert.assertEquals(driver.getTitle(), fu.getPropertyData("title3"));
	}
}

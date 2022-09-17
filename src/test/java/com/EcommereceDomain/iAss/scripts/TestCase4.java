package com.EcommereceDomain.iAss.scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.EducationalDomain.iAss.pom.CoreJavaPage;
import com.EducationalDomain.iAss.pom.SkillRaryHomePage;
import com.EducationalDomain.iAss.pom.WishListPage;

import generic.BaseClass;

public class TestCase4 extends BaseClass{

	@Test
	public void tc4() throws IOException, InterruptedException
	{
		test=reports.createTest("tc4");
		
		SkillRaryHomePage sh = new SkillRaryHomePage(driver);		
		CoreJavaPage cp = sh.searchCourse(fu.getPropertyData("searchtext"), driver);
		WishListPage wp = cp.javaSel(driver);
		wp.getClsalert().click();
		wu.switchToFrame(driver);
		wp.playPause();
		wu.switchBackFrame(driver);
		wp.getWishlist().click();
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), fu.getPropertyData("title4"));
	}
}

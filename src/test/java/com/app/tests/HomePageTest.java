package com.app.tests;

import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.pages.BasePage;
import com.app.pages.DressPageObjects;
import com.app.pages.HomePageObjects;


public class HomePageTest 
{
	HomePageObjects homepage;
	BasePage bp;
	DressPageObjects dressPage;
	
	public HomePageTest()
	{
		homepage = new HomePageObjects();
		bp = new BasePage();
		dressPage = new DressPageObjects();
	}

	@Test
	public void verifyMenudisplay() 
	{
		Assert.assertTrue(homepage.verifyMenuTab(), "Failed: Menu not displayed" );
	}
	
	@Test
	public void VerifypageNavigation()
	{
		homepage.ClickDressestab();
		Assert.assertEquals(dressPage.getTitle(), "DRESSES ");
		homepage.ClickWomentab();
		Assert.assertEquals(dressPage.getTitle(), "WOMEN ");
		homepage.ClickTshirttab();
		Assert.assertEquals(dressPage.getTitle(), "T-SHIRTS ");

	}
	@Test
	public void VerifyNewsletter() {
		homepage.Newslettermail("josephjoness55@gmail.com");
		Assert.assertTrue(homepage.Successalert());
	}

}

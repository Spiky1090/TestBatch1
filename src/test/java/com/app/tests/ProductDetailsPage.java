package com.app.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.pages.BasePage;
import com.app.pages.ProductDetailsObject;

public class ProductDetailsPage {

	ProductDetailsObject productdetails;
	BasePage bp;
	
	public ProductDetailsPage(){
		productdetails = new ProductDetailsObject();
		bp = new BasePage();
		}
   
   @Test
   public void VerifyTweetshare(){
	    productdetails.Clickproduct();
	    Assert.assertTrue(productdetails.Tweet());
	    Assert.assertTrue(productdetails.Share());
   }
   
   @Test
   public void Verifydescription(){
	   Assert.assertTrue(productdetails.Prodescription());
	}
}

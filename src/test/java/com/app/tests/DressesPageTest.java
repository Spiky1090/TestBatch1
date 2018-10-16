package com.app.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.app.pages.HomePageObjects;
import com.app.pages.BasePage;
import com.app.pages.DressPageObjects;

public class DressesPageTest {
	
 
   DressPageObjects dresspage;
   BasePage bp;
   HomePageObjects homepage;
   
   public DressesPageTest(){
	   dresspage = new DressPageObjects();
       bp = new BasePage();
       homepage = new HomePageObjects();
   }
  
  @Test
   public void VerifySMLtab(){
	   homepage.ClickDressestab();
	   Assert.assertTrue(dresspage.Verifylargetab(), "Failed");
	   Assert.assertTrue(dresspage.Verifymediumtab(), "Failed");
	   Assert.assertTrue(dresspage.Verifysmalltab(), "Failed");
   }
  
   @Test
   public void VerifyProductcount(){
 	   homepage.ClickDressestab();
 	   Assert.assertEquals(dresspage.getHeaderproductcount(),dresspage.getTotalproductcount(), "Failed: Count mismatched");
   } 

  @Test
  public void VerifyAddtocart(){
	  homepage.ClickDressestab();
	  Assert.assertTrue(dresspage.Addtocart(),"Failed");
	  dresspage.Clickclose();
	  
  }
  @Test
   public void VerifyProductPrices(){
	  homepage.ClickDressestab();
	  dresspage.Selectdropdown("price:asc");
	  List<Double> productPrices = dresspage.getProductPrices();
	  for(int i=0; i<productPrices.size()-1; i++ ){
		  Double first = productPrices.get(i);
		  Double second = productPrices.get(i+1);
	  Assert.assertTrue(first<second, "Failed :Its not in ascending order" );
	  
	  }
	}
}
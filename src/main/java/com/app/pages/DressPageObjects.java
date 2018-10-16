package com.app.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DressPageObjects extends BasePage{
	
	BasePage bp = new BasePage();
	HomePageObjects homepage = new HomePageObjects();
			
			
      @FindBy(xpath = "//ul//a[text() = 'L']")
	  private WebElement Large;
	  
	  @FindBy(xpath = "//ul//a[text() = 'M']")
	  private WebElement Medium;
	  
	  @FindBy(xpath = "//ul//a[text() = 'S']")
	  private WebElement Small;
	  
	  @FindBy(xpath = "//div//span[@class='cat-name']")
	  private WebElement Titlepage;
	  
	  
	  
	  public DressPageObjects(){
		  PageFactory.initElements(driver, this);
	  }

	  public boolean Verifylargetab(){
		return (bp.Displaycheck(Large));
	  }
	  public boolean Verifymediumtab(){
		return (bp.Displaycheck(Medium));
	  }
	  public boolean Verifysmalltab(){
		return (bp.Displaycheck(Small));
	  }
	  
	  public String getTitle(){
		return Titlepage.getText();
	  }

	 //* Verify Product count matching result count *//
	 
	 @FindBy(xpath = "//*[@class='heading-counter']")
	 private WebElement Header;
	 
	 @FindBys(@FindBy(xpath = "//*[@class='product_list grid row']/li"))
	 private List<WebElement> Productlist;
	 	
	 
	 
	 public int getHeaderproductcount(){
	 String number = Header.getText().split(" ")[2];
	 return Integer.parseInt(number);
	 }
	 
	 public int getTotalproductcount(){
		 return Productlist.size();
	 }

	 //* Verify add to cart *//
	 
	@FindBy(xpath = "//*[@class='product_list grid row']/li[1]")
	 private WebElement Product;
	 
    @FindBy(xpath = "//ul[@class='product_list grid row']//li[1]//span[text()='Add to cart']")
	 private WebElement Addtocart;
     
    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']/h2")
     private WebElement Addtocartmsg;	
    
    @FindBy(xpath = "//div[@class='layer_cart_product col-xs-12 col-md-6']//span[@title='Close window']")
    private WebElement Closebtn;
    
	 public boolean Addtocart(){
		 bp.Mousehover(Product);
		 Addtocart.click();
		 bp.Explicitwait(Addtocartmsg);
	return	 bp.Displaycheck(Addtocartmsg);
   
	}
	 
	 public void Clickclose(){
		 Closebtn.click();
	 }

	 /** Verify product sort by price from low to high */
	 
	@FindBy(id = "selectProductSort")
	private WebElement Sortbydropdown;
	
	@FindBy(id = "layered_ajax_loader")
	private WebElement Loadicon;
	
	@FindBys(@FindBy(xpath = "//div[@class='right-block']//*[@class ='price product-price']"))
	private List<WebElement> lstproductPrices;
	
	
	public void Selectdropdown(String optionTobeSelected){
		bp.selectFromDropDown(Sortbydropdown, optionTobeSelected);
		bp.isElementVisible(Loadicon);
		bp.isElementinVisible(Loadicon);
	}
	 
	public List<Double> getProductPrices(){
		ArrayList<Double> list = new ArrayList<Double>();
		for(WebElement element : lstproductPrices){
			String text = element.getText();
			text = text.replace("$","");
		Double price = Double.parseDouble(text);
		System.out.println("Product price" + price);
		     list.add(price);
		}
		return list;
	}
}


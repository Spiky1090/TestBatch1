package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsObject extends BasePage{

	BasePage bp = new BasePage();
	
	@FindBy(xpath = "//img[@title='Printed Chiffon Dress']")
	private WebElement Product;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-twitter']")
	private WebElement Twitter;
	
	@FindBy(xpath = "//button[@class='btn btn-default btn-facebook']")
	private WebElement Facebookshare;
	
	@FindBy (xpath = "//div[@id='short_description_content']/p")
	private WebElement Productdescription;
	
	public ProductDetailsObject(){
		PageFactory.initElements(driver, this);
	}
	
	public void Clickproduct(){
		Product.click();
	}
	
	public boolean Tweet(){
		bp.Explicitwait(Facebookshare);
		return	bp.Displaycheck(Twitter);  
	}
	
	public boolean Share(){
		bp.Explicitwait(Twitter);
		return bp.Displaycheck(Facebookshare);
	}
	
	public boolean Prodescription(){
		return bp.Displaycheck(Productdescription);
	}
	
	
}

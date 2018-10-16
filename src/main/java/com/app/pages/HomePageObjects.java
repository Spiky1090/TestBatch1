package com.app.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePageObjects extends BasePage {	

	@FindBy(xpath = "//ul[contains (  @class, 'menu-content')]/li[1]/a")
	private WebElement Women;

	@FindBy(xpath = "//ul[contains (  @class, 'menu-content')]/li[2]/a")
	private WebElement Dresses;

	@FindBy(xpath = "//ul[contains (  @class, 'menu-content')]/li[3]/a")
	private WebElement Tshirt;

	@FindBy(xpath = "//input[@id = 'newsletter-input']")
	private WebElement Newsletter;


	@FindBy(xpath = "//button[@name='submitNewsletter']")
	private WebElement submitNewsletter;
	
	@FindBy(xpath = "//p[@class='alert alert-success']")
	private WebElement Mailalert;


	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

	public void ClickDressestab() {
		Dresses.click();
	}

	public void ClickWomentab() {
		Women.click();
	}

	public void ClickTshirttab() {
		Tshirt.click();
	}

	public boolean verifyMenuTab()
	{
		return (Displaycheck(Women) && Displaycheck(Dresses)  && Displaycheck(Tshirt));
	}

	public void Newslettermail(String email){
		setText (Newsletter, email);
		submitNewsletter.click();
	}

	public boolean Successalert(){
		return (Displaycheck(Mailalert));
}
}

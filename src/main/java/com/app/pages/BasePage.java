package com.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;
	public String browser = "chrome";
		
public BasePage() {
	if (driver == null) 
	{
	if (browser.equals("chrome")) 
	{
	System.setProperty("webdriver.chrome.driver",
							"C:\\Users\\Joel Davidson\\Documents\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	} 
	//else if (browser.equals("firefox")) {		
	//System.setProperty("webdriver.gecko.driver", "Firefox Driver Server Path");
	//driver = new FirefoxDriver();
	//}
	driver.get("http://automationpractice.com/index.php");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	}

public boolean Displaycheck(WebElement element) {
	boolean res = false;
	try {
		res = element.isDisplayed();
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
		return res;
	}
		
public void setText(WebElement element, String name) {
	if (name != null) {
		element.click();
		element.clear();
		element.sendKeys(name);
}
}		

public String selectFromDropDown(WebElement element, String option) {
	Select obj = new Select(element);
	obj.selectByValue(option);
	return obj.getFirstSelectedOption().getText();
}
        

public void Explicitwait(WebElement e){
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(e));
}
		
public void Mousehover(WebElement m){
	Actions obj = new Actions (driver);
	obj.moveToElement(m).build().perform();
}
		
public boolean isElementVisible(WebElement element) {
	try {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
		}
	catch (Exception e) {
		return false;
		
	}
}
        
public boolean isElementinVisible(WebElement element) {
	try {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(element));
		return true;
	} 
	catch (Exception e) {
		return false;
}
}
}

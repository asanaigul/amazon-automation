package com.amazon.page.object.model;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;


import org.junit.Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.utils.Driver;


public class ShoppingActivity {
	
	
	AmazonPages amzPages=new AmazonPages();
	
	@Test
	public void verifyBook() {
		
		WebDriver driver = Driver.getInstance();
		String searchBook = "qa testing for beginners";
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Actions searchAction = new Actions(driver);
		searchAction.moveToElement(amzPages.searchBox);
		searchAction.click();
	
		searchAction.sendKeys(searchBook);
		searchAction.sendKeys(Keys.ENTER);
		searchAction.build().perform();
		System.out.println("We are in search Results");
		
		//verifyPriceBeforeAddtoCart
		String expectedBookPrc =  amzPages.expectedBookPrice.getAttribute("innerHTML");
		System.out.println("Expected price for the book: " + expectedBookPrc);
		
		amzPages.searchResult.click();
		
		String bookPrice = amzPages.bookPrice1.getText();
		System.out.println("Actual price for the book: " + bookPrice);
		
	
		assertEquals(expectedBookPrc,bookPrice);
		
		//proceedToChkOutAndVerifyPrice
		
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(amzPages.addtoCart)).click();
		
		
		String priceTagInTheCart = amzPages.priceInTheCart.getAttribute("innerHTML");
		
		System.out.println("Price before checkout : " + priceTagInTheCart);
		
		assertEquals(priceTagInTheCart,expectedBookPrc);
		
		System.out.println("Prices are matching");
		amzPages.prcdtoCheckout.click();
		
		driver.quit();
      
	}
	
	
	
}

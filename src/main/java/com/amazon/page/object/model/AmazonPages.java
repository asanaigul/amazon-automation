package com.amazon.page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.utils.Driver;


public class AmazonPages {
	
private WebDriver driver;
	
	public  AmazonPages(){
		this.driver=Driver.getInstance();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//form[@id='nav-search-bar-form']")
	public WebElement searchBox ;
	
	@FindBy(xpath="//a[@class='a-size-base a-link-normal a-text-normal']/span/span")
	public WebElement expectedBookPrice;
	
	@FindBy(xpath="//div[@class='s-main-slot s-result-list s-search-results sg-row']/div/span")
	public WebElement searchResult;

	@FindBy(xpath="//span[@id='newBuyBoxPrice']")
	public WebElement bookPrice1;
	//"//span/class[contains(text(),'47.49')]"));
	
	@FindBy(xpath="//span[@id='submit.add-to-cart']")
	public WebElement addtoCart; 
	
	
	@FindBy(xpath="//span[@class='a-color-price hlb-price a-inline-block a-text-bold']")
	public WebElement priceInTheCart;
	
	@FindBy(xpath="//span[@id='hlb-ptc-btn']")
	public WebElement prcdtoCheckout;
	

}

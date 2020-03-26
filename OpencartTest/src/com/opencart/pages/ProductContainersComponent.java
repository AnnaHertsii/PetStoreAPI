package com.opencart.pages;

import com.opencart.tools.RegexUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ProductContainersComponent {

    //Selectors
    private final String PRODUCT_NAME_SELECTOR = "h4 a"; // css
    private final String ADD_TO_CART_BUTTON_SELECTOR = ".//i[@class='fa fa-shopping-cart']/.."; //xpath
    private final String COMPARE_BUTTON_SELECTOR = ".//i[@class='fa fa-exchange']/.."; //xpath
    private final String PICTURE_SELECTOR = ".image a"; // css
    //TODO MISHA
    private final String ADD_TO_WISHLIST_BUTTON_SELECTOR  = "//div[@class='button-group']/button/i[contains(@class,'fa-heart')]"; //xpath
    private final String DISCOUNT_PRICE_SELECTOR = "//span[@class='price-new']"; //xpath
    private final String PRICE_SELECTOR  = "//p[contains(@class,'price') and not(child::span[@class='price-new'])]"; //xpath


    //Layout
    private WebElement productContainerLayout;

    public ProductContainersComponent(WebElement productContainerLayout) {
        this.productContainerLayout = productContainerLayout;
    }

    //Name
    public WebElement getName() {
        return productContainerLayout.findElement(By.cssSelector(PRODUCT_NAME_SELECTOR));
    }

    public String getNameText() {
        return getName().getText();
    }

    //AddToCartButton
    public WebElement getAddToCartButton() {
        return productContainerLayout.findElement(By.xpath(ADD_TO_CART_BUTTON_SELECTOR));
    }

    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }

    //CompareButton
    public WebElement getCompareButton() {
        return productContainerLayout.findElement(By.xpath(COMPARE_BUTTON_SELECTOR));
    }

    public void clickCompareButton() {
        getCompareButton().click();
    }

    //Picture
    public WebElement getPicture() {
        return productContainerLayout.findElement(By.cssSelector(PICTURE_SELECTOR));
    }

    public void clickPicture() {
        getPicture().click();
    }

    //AddToWishListButton
    public WebElement getAddToWishListButton() {
        return productContainerLayout.findElement(By.xpath(ADD_TO_WISHLIST_BUTTON_SELECTOR));
    }

    public void clickAddToWishListButton() {
        getAddToWishListButton().click();
    }

    //Price
    public WebElement getPrice() {
        try {
            return productContainerLayout.findElement(By.xpath(DISCOUNT_PRICE_SELECTOR));
        }catch(NoSuchElementException e){
            return productContainerLayout.findElement(By.xpath(PRICE_SELECTOR));
        }
    }

    public double getPriceAmount() {
        RegexUtils regexUtils = new RegexUtils();
        System.out.println(getPrice().getText());
        return regexUtils.extractFirstDouble(getPrice().getText());
    }
}
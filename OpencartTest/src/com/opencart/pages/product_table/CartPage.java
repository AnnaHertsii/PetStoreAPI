package com.opencart.pages.product_table;

import com.opencart.pages.AbstractPageWithHeader;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends AbstractPageWithHeader {

    //Components
    private List<ProductInCartContainerComponent> productInCartContainerComponents;

    public CartPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){
        productInCartContainerComponents = new ArrayList<>();
    }
}
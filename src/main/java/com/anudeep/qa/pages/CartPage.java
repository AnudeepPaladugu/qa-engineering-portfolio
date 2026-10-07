package com.anudeep.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) { super(driver); }
    public void open() { open("/view_cart"); }
    public String row() { return text(By.id("product-1")); }
    public String price() { return text(By.cssSelector("#product-1 .cart_price")); }
    public String quantity() { return text(By.cssSelector("#product-1 .cart_quantity")); }
    public String total() { return text(By.cssSelector("#product-1 .cart_total_price")); }
    public void remove() { click(By.cssSelector("#product-1 .cart_quantity_delete"));wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("product-1")));waitText("Cart is empty!"); }
    public void checkout() { click(By.cssSelector(".check_out")); }
    public String guestGate() { return text(By.id("checkoutModal")); }
    public void refresh() { driver.navigate().refresh();wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-1"))); }
}

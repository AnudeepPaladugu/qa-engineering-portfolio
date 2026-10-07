package com.anudeep.qa.pages;

import org.openqa.selenium.*;

public class ProductPage extends BasePage {
  public ProductPage(WebDriver driver) {
    super(driver);
  }

  public void openBlueTop() {
    open("/product_details/1");
    waitText("Blue Top");
  }

  public String details() {
    return text(By.cssSelector(".product-information"));
  }

  public String quantity() {
    return value(By.id("quantity"));
  }

  public void quantity(String value) {
    type(By.id("quantity"), value);
  }

  public void add() {
    click(By.cssSelector("button.cart"));
    waitText("Your product has been added to cart.");
  }
}

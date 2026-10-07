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

  public String minimum() {
    return visible(By.id("quantity")).getDomAttribute("min");
  }

  public void quantity(String value) {
    type(By.id("quantity"), value);
  }

  public void add() {
    click(By.cssSelector("button.cart"));
    waitText("Your product has been added to cart.");
  }

  public void attemptAddInvalidQuantity() {
    click(By.cssSelector("button.cart"));
    // The negative path must not require a success modal: a future rejection is valid.
    wait.until(
        d -> Boolean.TRUE.equals(((JavascriptExecutor) d).executeScript(
            "return typeof jQuery !== 'undefined' && jQuery.active === 0")));
  }
}

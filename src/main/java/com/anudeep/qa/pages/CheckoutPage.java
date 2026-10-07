package com.anudeep.qa.pages;

import org.openqa.selenium.*;

public class CheckoutPage extends BasePage {
  public CheckoutPage(WebDriver driver) {
    super(driver);
  }

  public void ready() {
    waitPath("/checkout");
    waitText("Address Details");
  }

  public String address() {
    return text(By.id("address_delivery"));
  }

  public String review() {
    return text(By.id("cart_info"));
  }

  public void placeOrder() {
    click(By.cssSelector("a[href='/payment']"));
    waitPath("/payment");
  }
}

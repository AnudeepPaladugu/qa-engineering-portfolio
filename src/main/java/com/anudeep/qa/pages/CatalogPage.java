package com.anudeep.qa.pages;

import java.util.List;
import org.openqa.selenium.*;

public class CatalogPage extends BasePage {
  private final By names = By.cssSelector(".features_items .productinfo p");

  public CatalogPage(WebDriver driver) {
    super(driver);
  }

  public void open() {
    open("/products");
    waitText("ALL PRODUCTS");
  }

  public void search(String query) {
    type(By.id("search_product"), query);
    click(By.id("submit_search"));
    waitText("SEARCHED PRODUCTS");
  }

  public List<String> names() {
    return texts(names);
  }

  public String heading() {
    return text(By.cssSelector(".features_items h2.title"));
  }

  public String blueTopCard() {
    return text(By.xpath("//div[contains(@class,'productinfo')][p='Blue Top']"));
  }

  public void womenTops() {
    open("/category_products/2");
    waitText("WOMEN - TOPS PRODUCTS");
  }

  public void polo() {
    open("/brand_products/Polo");
    waitText("BRAND - POLO PRODUCTS");
  }
}

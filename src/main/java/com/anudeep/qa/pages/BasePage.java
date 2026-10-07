package com.anudeep.qa.pages;

import com.anudeep.qa.config.Config;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public abstract class BasePage {
  protected final WebDriver driver;
  protected final WebDriverWait wait;

  protected BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(Config.waitSeconds()));
  }

  public void open(String route) {
    driver.get(Config.get("BASE_URL").replaceAll("/$", "") + route);
  }

  protected By qa(String value) {
    return By.cssSelector("[data-qa='" + value + "']");
  }

  protected WebElement visible(By by) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  protected void click(By by) {
    WebElement element = visible(by);
    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    wait.until(ExpectedConditions.elementToBeClickable(by)).click();
  }

  protected void type(By by, String value) {
    WebElement e = visible(by);
    e.clear();
    e.sendKeys(value);
  }

  protected String text(By by) {
    return visible(by).getText().trim();
  }

  protected String value(By by) {
    return visible(by).getDomProperty("value");
  }

  public String path() {
    return java.net.URI.create(driver.getCurrentUrl()).getPath();
  }

  public String bodyText() {
    return text(By.tagName("body"));
  }

  public void waitPath(String path) {
    wait.until(d -> java.net.URI.create(d.getCurrentUrl()).getPath().equals(path));
  }

  public void waitText(String value) {
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), value));
  }

  public List<String> texts(By by) {
    return driver.findElements(by).stream()
        .filter(WebElement::isDisplayed)
        .map(WebElement::getText)
        .map(String::trim)
        .toList();
  }

  public void logout() {
    click(By.cssSelector("a[href='/logout']"));
    waitPath("/login");
  }

  public String loggedInName() {
    return text(By.partialLinkText("Logged in as"));
  }

  public boolean loggedIn() {
    return !driver.findElements(By.partialLinkText("Logged in as")).isEmpty();
  }

  public boolean signupLinkVisible() {
    return visible(By.cssSelector("a[href='/login']")).isDisplayed();
  }
}

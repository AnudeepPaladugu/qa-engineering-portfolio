package com.anudeep.qa.pages;

import org.openqa.selenium.*;

public class AccountPage extends BasePage {
  public AccountPage(WebDriver driver) {
    super(driver);
  }

  public void continueAfterCreation() {
    click(qa("continue-button"));
    wait.until(d -> loggedIn());
  }

  public void deleteOwnedAccount() {
    click(By.cssSelector("a[href='/delete_account']"));
    waitText("ACCOUNT DELETED!");
  }
}

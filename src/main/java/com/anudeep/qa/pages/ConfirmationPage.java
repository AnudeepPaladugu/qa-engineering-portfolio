package com.anudeep.qa.pages;

import org.openqa.selenium.*;

public class ConfirmationPage extends BasePage {
    public ConfirmationPage(WebDriver driver) { super(driver); }
    public String confirmation() { waitText("Congratulations! Your order has been confirmed!");return bodyText(); }
}

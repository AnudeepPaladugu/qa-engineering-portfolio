package com.anudeep.qa.pages;

import org.openqa.selenium.*;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) { super(driver); }
    public void syntheticDetails() {
        type(qa("name-on-card"),"QA Portfolio");type(qa("card-number"),"4111111111111111");
        type(qa("cvc"),"123");type(qa("expiry-month"),"12");type(qa("expiry-year"),"2030");
    }
    public void confirm() { click(qa("pay-button")); }
    public boolean nameMissing() { return (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valueMissing",visible(qa("name-on-card"))); }
}

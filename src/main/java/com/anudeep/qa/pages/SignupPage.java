package com.anudeep.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BasePage {
    public SignupPage(WebDriver driver) { super(driver); }
    public void fillRequired(String password) {
        waitText("ENTER ACCOUNT INFORMATION");
        type(qa("password"),password);
        type(qa("first_name"),"QA");type(qa("last_name"),"Portfolio");
        type(qa("address"),"Test Street");new Select(visible(qa("country"))).selectByVisibleText("India");
        type(qa("state"),"Andhra Pradesh");type(qa("city"),"Vijayawada");
        type(qa("zipcode"),"520001");type(qa("mobile_number"),"9999999999");
    }
    public void create() { click(qa("create-account"));waitText("ACCOUNT CREATED!"); }
}

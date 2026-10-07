package com.anudeep.qa.pages;

import org.openqa.selenium.*;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) { super(driver); }
    public void open() { open("/login");waitText("Login to your account"); }
    public void email(String email) { type(qa("login-email"),email); }
    public void password(String password) { type(qa("login-password"),password); }
    public void submitLogin() { click(qa("login-button")); }
    public void login(String email,String password) { email(email);password(password);submitLogin();wait.until(d -> loggedIn()); }
    public String loginEmailRequired() { return visible(qa("login-email")).getDomProperty("required"); }
    public String loginPasswordRequired() { return visible(qa("login-password")).getDomProperty("required"); }
    public String passwordType() { return visible(qa("login-password")).getDomAttribute("type"); }
    public boolean emailMissing() { return (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].validity.valueMissing",visible(qa("login-email"))); }
    public String loginError() { return text(By.cssSelector(".login-form p")); }
    public void signupName(String name) { type(qa("signup-name"),name); }
    public void signupEmail(String email) { type(qa("signup-email"),email); }
    public void submitSignup() { click(qa("signup-button")); }
    public String signupError() { return text(By.cssSelector(".signup-form p")); }
}

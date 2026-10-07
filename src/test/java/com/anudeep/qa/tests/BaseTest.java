package com.anudeep.qa.tests;

import com.anudeep.qa.config.Config;
import com.anudeep.qa.drivers.Drivers;
import com.anudeep.qa.pages.*;
import com.anudeep.qa.support.*;
import io.qameta.allure.Allure;
import java.lang.reflect.Method;
import java.util.UUID;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.*;

public abstract class BaseTest implements IHookable {
  protected LoginPage login;
  protected CatalogPage catalog;
  protected ProductPage product;
  protected CartPage cart;
  protected CheckoutPage checkout;
  protected PaymentPage payment;
  protected ConfirmationPage confirmation;
  private String ownedEmail;
  private boolean accountCreated;

  @Override
  public void run(IHookCallBack callback, ITestResult result) {
    CaseId id = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CaseId.class);
    Allure.label("testCaseId", id.value());
    Allure.label("priority", id.priority());
    Allure.parameter("Environment", Config.get("ENVIRONMENT"));
    Allure.parameter("Browser", Config.get("BROWSER"));
    Evidence.checkpoint("START");
    long start = System.nanoTime();
    callback.runTestMethod(result);
    Throwable failure = result.getThrowable();
    String status =
        failure instanceof org.testng.SkipException ? "SKIPPED" : failure != null ? "FAIL" : "PASS";
    Evidence.finish(status, (System.nanoTime() - start) / 1_000_000, failure);
    result.setAttribute("evidenceFinished", true);
  }

  @BeforeMethod(alwaysRun = true)
  public void setup(Method method) {
    Evidence.begin(method.getAnnotation(CaseId.class).value(), method.getName());
    ownedEmail = null;
    accountCreated = false;
    Drivers.start();
    login = new LoginPage(Drivers.get());
    catalog = new CatalogPage(Drivers.get());
    product = new ProductPage(Drivers.get());
    cart = new CartPage(Drivers.get());
    checkout = new CheckoutPage(Drivers.get());
    payment = new PaymentPage(Drivers.get());
    confirmation = new ConfirmationPage(Drivers.get());
  }

  protected String register() {
    String password = Config.required("TEST_PASSWORD");
    ownedEmail = "qa-portfolio-" + UUID.randomUUID() + "@example.com";
    Allure.step(
        "Register a unique synthetic UI account",
        () -> {
          login.open();
          login.signupName("QA Portfolio");
          login.signupEmail(ownedEmail);
          login.submitSignup();
          SignupPage signup = new SignupPage(Drivers.get());
          signup.fillRequired(password);
          signup.create();
          accountCreated = true;
          Evidence.observe("ACCOUNT CREATED! displayed for owned synthetic account");
          new AccountPage(Drivers.get()).continueAfterCreation();
        });
    return ownedEmail;
  }

  protected void addTwo() {
    Allure.step(
        "Add two Blue Top units",
        () -> {
          product.openBlueTop();
          Evidence.checkpoint("BEFORE_ADD");
          product.quantity("2");
          product.add();
          cart.open();
        });
  }

  protected void reviewOrder() {
    register();
    addTwo();
    cart.checkout();
    checkout.ready();
  }

  @AfterMethod(alwaysRun = true)
  public void teardown() {
    try {
      if (accountCreated && Drivers.get() != null) {
        if (!login.loggedIn()) {
          login.open();
          login.login(ownedEmail, Config.required("TEST_PASSWORD"));
        }
        new AccountPage(Drivers.get()).deleteOwnedAccount();
      }
      Evidence.cleanup("PASS", null);
    } catch (RuntimeException e) {
      Evidence.cleanup("FAIL", e);
      throw e;
    } finally {
      try {
        Drivers.stop();
      } finally {
        Evidence.clear();
      }
    }
  }
}

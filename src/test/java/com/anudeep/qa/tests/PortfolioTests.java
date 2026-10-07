package com.anudeep.qa.tests;

import com.anudeep.qa.config.Config;
import com.anudeep.qa.pages.*;
import com.anudeep.qa.support.*;
import io.qameta.allure.*;
import java.util.UUID;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(EvidenceListener.class)
@Epic("Automation Exercise customer workflows")
public class PortfolioTests extends BaseTest {
  private void observed(String value) {
    Evidence.observe(value);
  }

  @Test(groups = {"smoke", "regression", "sanity", "ui"})
  @CaseId("TC-UI-001")
  @Severity(SeverityLevel.NORMAL)
  @Description("Verify required login fields and masked password type")
  public void loginForm() {
    login.open();
    Assert.assertEquals(login.loginEmailRequired(), "true");
    Assert.assertEquals(login.loginPasswordRequired(), "true");
    Assert.assertEquals(login.passwordType(), "password");
    observed("/login rendered; email/password required=true; password type=password");
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-002")
  @Severity(SeverityLevel.CRITICAL)
  @Description("Unknown credentials display the application's exact login rejection")
  public void invalidLogin() {
    login.open();
    login.email("nobody-" + UUID.randomUUID() + "@example.com");
    login.password(UUID.randomUUID().toString());
    login.submitLogin();
    String error = login.loginError();
    Assert.assertEquals(error, "Your email or password is incorrect!");
    Assert.assertEquals(login.path(), "/login");
    observed("Observed login error: " + error + "; URL path=/login");
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-003")
  @Severity(SeverityLevel.NORMAL)
  @Description("Blank login email is rejected by browser required-field validity")
  public void requiredLoginEmail() {
    login.open();
    login.submitLogin();
    Assert.assertTrue(login.emailMissing(), "Email should have validity.valueMissing=true");
    Assert.assertEquals(login.path(), "/login");
    observed("Blank email validity.valueMissing=true; URL path=/login");
  }

  @Test(groups = {"smoke", "regression", "critical", "ui"})
  @CaseId("TC-UI-004")
  @Severity(SeverityLevel.CRITICAL)
  @Description("UI registration creates a unique account and authenticates the new user")
  public void registerAccount() {
    register();
    Assert.assertEquals(login.loggedInName(), "Logged in as QA Portfolio");
    observed("Registration completed; navigation displays " + login.loggedInName());
  }

  @Test(groups = {"smoke", "regression", "critical", "ui"})
  @CaseId("TC-UI-005")
  @Severity(SeverityLevel.BLOCKER)
  @Description("A newly registered account can log out and authenticate with its own credentials")
  public void validLogin() {
    String email = register();
    login.logout();
    login.login(email, Config.required("TEST_PASSWORD"));
    Assert.assertEquals(login.loggedInName(), "Logged in as QA Portfolio");
    observed("Login accepted registered credentials; navigation displays " + login.loggedInName());
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-006")
  @Severity(SeverityLevel.CRITICAL)
  @Description("Logout returns to login and removes authenticated navigation")
  public void logout() {
    register();
    login.logout();
    Assert.assertEquals(login.path(), "/login");
    Assert.assertFalse(login.loggedIn());
    Assert.assertTrue(login.signupLinkVisible());
    observed("Logout navigated to /login; authenticated name absent; Signup / Login visible");
  }

  @Test(groups = {"smoke", "regression", "ui"})
  @CaseId("TC-UI-007")
  @Severity(SeverityLevel.CRITICAL)
  @Description("Catalog exposes Blue Top with its inspected price")
  public void catalog() {
    catalog.open();
    Assert.assertFalse(catalog.names().isEmpty());
    Assert.assertTrue(catalog.blueTopCard().contains("Rs. 500"));
    observed("Catalog heading=" + catalog.heading() + "; Blue Top card=" + catalog.blueTopCard());
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-008")
  @Severity(SeverityLevel.NORMAL)
  @Description("Search for top includes both a name match and an observed Tops & Shirts category match")
  public void searchTop() {
    catalog.open();
    catalog.search("top");
    var names = catalog.names();
    Assert.assertFalse(names.isEmpty());
    Assert.assertTrue(names.contains("Blue Top"), "Missing known product-name match: " + names);
    Assert.assertTrue(
        names.contains("Little Girls Mr. Panda Shirt"), "Missing observed category match: " + names);
    observed("top search returned " + names.size() + " products, including Blue Top and the Tops & Shirts category item Little Girls Mr. Panda Shirt: " + names);
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-009")
  @Severity(SeverityLevel.MINOR)
  @Description("A unique unknown search displays no product cards")
  public void searchNoMatch() {
    catalog.open();
    catalog.search("qa-no-product-" + UUID.randomUUID());
    Assert.assertEquals(catalog.names().size(), 0);
    observed("SEARCHED PRODUCTS displayed with zero product cards");
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-010")
  @Severity(SeverityLevel.NORMAL)
  @Description("Blue Top detail matches the inspected catalog fixture and default quantity")
  public void productDetails() {
    product.openBlueTop();
    String d = product.details();
    for (String value :
        new String[] {
          "Blue Top", "Rs. 500", "Availability: In Stock", "Condition: New", "Brand: Polo"
        }) Assert.assertTrue(d.contains(value), "Missing product detail: " + value);
    Assert.assertEquals(product.quantity(), "1");
    observed("Product details=" + d + "; initial quantity=" + product.quantity());
  }

  @Test(groups = {"smoke", "regression", "critical", "ui"})
  @CaseId("TC-UI-011")
  @Severity(SeverityLevel.BLOCKER)
  @Description("Two Blue Top units at Rs. 500 produce a cart line total of Rs. 1000")
  public void cartTotal() {
    addTwo();
    Assert.assertEquals(cart.price(), "Rs. 500");
    Assert.assertEquals(cart.quantity(), "2");
    Assert.assertEquals(cart.total(), "Rs. 1000");
    observed(
        "Cart Blue Top: unit="
            + cart.price()
            + "; quantity="
            + cart.quantity()
            + "; total="
            + cart.total());
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-012")
  @Severity(SeverityLevel.CRITICAL)
  @Description("Removing the only cart row reveals the empty-cart state")
  public void removeCartItem() {
    addTwo();
    cart.remove();
    Assert.assertTrue(cart.bodyText().contains("Cart is empty!"));
    observed("Deleted Blue Top row; Cart is empty! displayed");
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-013")
  @Severity(SeverityLevel.CRITICAL)
  @Description("Same-session refresh retains quantity and cart total")
  public void cartPersists() {
    addTwo();
    cart.refresh();
    Assert.assertEquals(cart.quantity(), "2");
    Assert.assertEquals(cart.total(), "Rs. 1000");
    observed("After refresh: quantity=" + cart.quantity() + "; total=" + cart.total());
  }

  @Test(groups = {"smoke", "regression", "critical", "ui"})
  @CaseId("TC-UI-014")
  @Severity(SeverityLevel.CRITICAL)
  @Description("Guest checkout presents the registration/login gate")
  public void guestCheckout() {
    addTwo();
    cart.checkout();
    String gate = cart.guestGate();
    Assert.assertTrue(gate.contains("Register / Login account to proceed on checkout."));
    observed("Guest checkout modal=" + gate);
  }

  @Test(groups = {"regression", "critical", "ui"})
  @CaseId("TC-UI-015")
  @Severity(SeverityLevel.BLOCKER)
  @Description(
      "Authenticated review carries the synthetic delivery address and two-unit order total")
  public void checkoutReview() {
    reviewOrder();
    String address = checkout.address();
    for (String v :
        new String[] {
          "QA Portfolio", "Test Street", "Vijayawada", "Andhra Pradesh", "520001", "India"
        }) Assert.assertTrue(address.contains(v), "Delivery address missing " + v);
    String review = checkout.review();
    Assert.assertTrue(review.contains("Blue Top"));
    Assert.assertTrue(review.contains("Total Amount"));
    Assert.assertTrue(review.contains("Rs. 1000"));
    Assert.assertEquals(cart.quantity(), "2");
    observed("Checkout delivery address=" + address + "; review=" + review);
  }

  @Test(groups = {"smoke", "regression", "critical", "ui"})
  @CaseId("TC-UI-016")
  @Severity(SeverityLevel.BLOCKER)
  @Description("The full simulated purchase confirms an order using test-only card input")
  public void completeOrder() {
    reviewOrder();
    checkout.placeOrder();
    Evidence.checkpoint("BEFORE_PAYMENT");
    payment.syntheticDetails();
    payment.confirm();
    String text = confirmation.confirmation();
    Assert.assertTrue(text.contains("ORDER PLACED!"));
    Assert.assertTrue(text.contains("Congratulations! Your order has been confirmed!"));
    observed(
        "Confirmation URL="
            + confirmation.path()
            + "; ORDER PLACED!; Congratulations! Your order has been confirmed!");
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-017")
  @Severity(SeverityLevel.CRITICAL)
  @Description("A blank payment name keeps the browser on the payment form")
  public void paymentRequiredName() {
    reviewOrder();
    checkout.placeOrder();
    payment.confirm();
    Assert.assertTrue(payment.nameMissing());
    Assert.assertEquals(payment.path(), "/payment");
    observed("Name on Card validity.valueMissing=true; URL path=/payment");
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-018")
  @Severity(SeverityLevel.CRITICAL)
  @Description("Signup rejects the email belonging to this test's existing account")
  public void duplicateSignup() {
    String email = register();
    login.logout();
    login.signupName("QA Portfolio");
    login.signupEmail(email);
    login.submitSignup();
    String error = login.signupError();
    Assert.assertEquals(error, "Email Address already exist!");
    observed("Duplicate signup displayed: " + error + "; URL=" + login.path());
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-019")
  @Severity(SeverityLevel.NORMAL)
  @Description("Women Tops category includes Blue Top")
  public void categoryFilter() {
    catalog.womenTops();
    Assert.assertEquals(catalog.heading(), "WOMEN - TOPS PRODUCTS");
    Assert.assertTrue(catalog.names().contains("Blue Top"));
    observed("Category heading=" + catalog.heading() + "; names=" + catalog.names());
  }

  @Test(groups = {"regression", "ui"})
  @CaseId("TC-UI-020")
  @Severity(SeverityLevel.NORMAL)
  @Description("Polo brand subset includes Blue Top")
  public void brandFilter() {
    catalog.polo();
    Assert.assertEquals(catalog.heading(), "BRAND - POLO PRODUCTS");
    Assert.assertTrue(catalog.names().contains("Blue Top"));
    observed("Brand heading=" + catalog.heading() + "; names=" + catalog.names());
  }
}

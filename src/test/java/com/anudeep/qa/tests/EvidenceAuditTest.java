package com.anudeep.qa.tests;

import com.anudeep.qa.support.*;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.*;

/** Intentional framework check, excluded from all application suites. */
@Listeners(EvidenceListener.class)
public class EvidenceAuditTest extends BaseTest {
  @Test(groups = "evidence-audit")
  @CaseId("AUDIT-001")
  @Description("Intentional assertion failure verifies failure screenshot and non-zero Maven exit")
  public void intentionalFailure() {
    login.open();
    Evidence.observe("Login page rendered before intentional audit failure");
    Assert.fail("INTENTIONAL EVIDENCE AUDIT FAILURE — not an application defect");
  }
}

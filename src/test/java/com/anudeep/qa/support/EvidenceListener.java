package com.anudeep.qa.support;

import org.testng.*;

public class EvidenceListener implements ITestListener {
  @Override
  public void onTestStart(ITestResult result) {
    Evidence.writeLog("TEST_BODY_START", "RUNNING", null);
  }

  @Override
  public void onTestSuccess(ITestResult r) {
    finish(r, "PASS");
  }

  @Override
  public void onTestFailure(ITestResult r) {
    finish(r, "FAIL");
  }

  @Override
  public void onTestSkipped(ITestResult r) {
    finish(r, "SKIPPED");
  }

  private void finish(ITestResult r, String status) {
    // The hook captures normal outcomes while Allure's test lifecycle is active.
    // The listener covers skipped bodies (for example a setup failure).
    if (!Boolean.TRUE.equals(r.getAttribute("evidenceFinished")))
      Evidence.finish(status, r.getEndMillis() - r.getStartMillis(), r.getThrowable());
  }
}

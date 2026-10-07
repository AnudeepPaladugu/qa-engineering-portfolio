package com.anudeep.qa.support;

import org.testng.*;
import io.qameta.allure.Allure;
import com.anudeep.qa.config.Config;

public class EvidenceListener implements ITestListener {
    @Override public void onTestStart(ITestResult result) {
        CaseId id=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CaseId.class);
        Allure.label("testCaseId",id.value());Allure.label("priority",id.priority());
        Allure.parameter("Environment",Config.get("ENVIRONMENT"));Allure.parameter("Browser",Config.get("BROWSER"));
        Evidence.writeLog("TEST_BODY_START","RUNNING",null);Evidence.checkpoint("START");
    }
    @Override public void onTestSuccess(ITestResult r) { finish(r,"PASS"); }
    @Override public void onTestFailure(ITestResult r) { finish(r,"FAIL"); }
    @Override public void onTestSkipped(ITestResult r) { finish(r,"SKIPPED"); }
    private void finish(ITestResult r,String status) { Evidence.finish(status,r.getEndMillis()-r.getStartMillis(),r.getThrowable()); }
}

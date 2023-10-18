package com.qa.listeners;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import extentReport.ExtentLogger;
import extentReport.ExtentReport;

public class Listiner implements ITestListener, ISuiteListener {

	public void onStart(ISuite suite) {
		try {
			ExtentReport.intReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		// ExtentReport.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + "---" + "is passed");
	}

	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + "---" + "is failed");
	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + "---" + "is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}

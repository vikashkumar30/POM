package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener{

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		Reporter.log("Screenshot Attached");
		
	}

	public void onTestFailure(ITestResult arg0) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=\"d:\\screenshot\\error.jpg\" target=\"_blank\">Screenshot Link</a>");
		
	}

	public void onTestSkipped(ITestResult arg0) {
	Reporter.log("Screenshot Attached");
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		Reporter.log("Screenshot Attached");
		
	}

	
}

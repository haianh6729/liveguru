package utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.ITestResult;

/* Get/set fail status for test case
 * Set fail message to Report HTML (ReportNG/TestNG)
 * Insert to Verify Function at BaseTest class
 */
public class VerificationFailures extends HashMap<ITestResult, List<Throwable>> {
	
	private static final long serialVersionUID = 1L;
	private static VerificationFailures failures;
	
	private VerificationFailures() {
		super();
	}

	public static VerificationFailures getFailures() {
		if (failures == null) {
			failures = new VerificationFailures();
		}
		return failures;
	}

	public List<Throwable> getFailuresForTest(ITestResult result) {
		List<Throwable> exceptions = get(result);
		return exceptions == null ? new ArrayList<Throwable>() : exceptions;
	}

	public void addFailureForTest(ITestResult result, Throwable throwable) {
		List<Throwable> exceptions = getFailuresForTest(result);
		exceptions.add(throwable);
		put(result, exceptions);
	}

	
}
package listeners;

import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.io.File;

import static config.Constants.SCREENSHOT_DIR;
import static date.DateFormatter.getFormattedNowDate;
import static utils.Screenshot.takeScreenshot;

@Listeners
public class TestListener implements ITestListener {
    private static final Logger LOGGER = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Starting the test with name " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Passing the test with name " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotName = result.getInstance() + "_" + getFormattedNowDate();
        if (result.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(TestCaseId.class)) {
            screenshotName = screenshotName + "_" +
                    result
                            .getMethod()
                            .getConstructorOrMethod()
                            .getMethod()
                            .getAnnotation(TestCaseId.class)
                            .testRailCaseId();
        }
        screenshotName = screenshotName + ".jpg";
        String screenshotPath = SCREENSHOT_DIR + screenshotName;
        File screenshot = new File(screenshotPath);
        WebDriver driver = ((TestsBase) result.getInstance()).driver;
        takeScreenshot(screenshot, result.getInstance() + getFormattedNowDate(), driver);
        LOGGER.debug("Failing the test with name " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}

package listeners;

import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
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

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotName = result.getInstance() +"_"+ getFormattedNowDate();
        if (result.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(TestCaseId.class)) {
            screenshotName = screenshotName+"_"+
                    result
                            .getMethod()
                            .getConstructorOrMethod()
                            .getMethod()
                            .getAnnotation(TestCaseId.class)
                            .testRailCaseId();
        }
        screenshotName = screenshotName+".jpg";
        String screenshotPath = SCREENSHOT_DIR + screenshotName;
        File screenshot = new File(screenshotPath);
        WebDriver driver = ((TestsBase)result.getInstance()).driver;
        takeScreenshot(screenshot, result.getInstance() + getFormattedNowDate(), driver);
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

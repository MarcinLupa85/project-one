package listeners;

import com.circlekeurope.testrail.testng.TestRailListener;

import static config.Constants.SCREENSHOT_DIR;
import static date.DateFormatter.getFormattedNowDate;
import static services.config.TestRailServiceConfig.testRailApi;

public class TestRailTestNgListener extends TestRailListener {

    public TestRailTestNgListener() {
        super(testRailApi(), 12, 80, "EV Test Automation "+getFormattedNowDate(), SCREENSHOT_DIR);
    }
}

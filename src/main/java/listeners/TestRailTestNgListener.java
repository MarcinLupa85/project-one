package listeners;

import com.circlekeurope.testrail.testng.TestRailListener;

import static config.Constants.SCREENSHOT_DIR;
import static date.DateFormatter.getFormattedNowDate;
import static services.config.TestRailServiceConfig.testRailApi;

public class TestRailTestNgListener extends TestRailListener {

    public static final int PROJECT_ID = 12;
    public static final int SUITE_ID = 50;

    public TestRailTestNgListener() {
        super(testRailApi(), PROJECT_ID, SUITE_ID, "Master "+getFormattedNowDate(), SCREENSHOT_DIR);
    }
}

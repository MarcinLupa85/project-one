package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.Listeners;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static config.Constants.RESULT_FILE;
import static utils.FilesUtils.appendTextToFile;

@Listeners
public class SuiteListener implements ISuiteListener {

    public static final String FAIL = "fail";
    public static final String PASS = "pass";

    @Override
    public void onStart(ISuite suite) {
    }

    @Override
    public void onFinish(ISuite suite) {
        testStatusForJenkins(suite);
    }

    private void testStatusForJenkins(ISuite suite) {
        List<String> content = new ArrayList<>();
        if (suite.getResults().entrySet().stream().anyMatch(result -> result.getValue().getTestContext().getFailedTests().size() > 0
                || result.getValue().getTestContext().getSkippedTests().size() > 0)) {
            content.add(FAIL);
        } else {
            content.add(PASS);
        }
        appendTextToFile(content, Paths.get(RESULT_FILE));
    }
}
import com.circlekeurope.testrail.client.annotations.TestCaseId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SampleTest {
    private static final Logger LOGGER = LogManager.getLogger(SampleTest.class);

    @TestCaseId(testRailCaseId = 2863)
    @Test
    public void testSomething() {
        LOGGER.info("KABOOM!!");
    }
}

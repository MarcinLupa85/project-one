import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SampleTest {

    @TestCaseId(testRailCaseId = 2863)
    @Test
    public void testSomething() {
        System.out.println("KABOOM!!");
    }
}

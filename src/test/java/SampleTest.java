import com.circlekeurope.testrail.client.annotations.TestCaseId;
import org.testng.annotations.Test;

public class SampleTest {

    @TestCaseId(testRailCaseId = 2863)
    @Test
    public void testSomething() {
        System.out.println("KABOOM!!");
    }
}

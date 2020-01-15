import config.TestsBase;
import operations.HomePageOperations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactWithCircleKTests extends TestsBase {
    private HomePageOperations homePageOperations;

    @BeforeClass
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);
    }

    @Test
    public void testOpenContactSection() {
        homePageOperations.openContactSection();
        assertThat(driver.getCurrentUrl()).contains("/kontakt");
    }

}

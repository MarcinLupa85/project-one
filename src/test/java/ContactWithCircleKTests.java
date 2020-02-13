import config.TestsBase;
import operations.HomePageOperations;
import operations.TopMenuOperations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactWithCircleKTests extends TestsBase {
    private HomePageOperations homePageOperations;
    private TopMenuOperations topMenuOperations;

    @BeforeClass
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);
        topMenuOperations = new TopMenuOperations(driver);
    }

    @Test
    public void testOpenContactPage() {
        topMenuOperations.openContactPage();
        assertThat(driver.getCurrentUrl()).contains("/kontakt");
    }


}

import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EaseePurchaseFlowWithExtraTest extends TestsBase {

    private HomePageOperations homePageOperations;
    private CustomizationPageOperations customizationPageOperations;
    private CkidPageOperations ckidPageOperations;
    private AddressPageOperations addressPageOperations;
    private SummaryPageOperations summaryPageOperations;



    @BeforeClass
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);



    }

    @Test
    public void testOpenContactSection() {
        //homePageOperations.openContactSection();
        assertThat(driver.getCurrentUrl()).contains("/kontakt");
    }


}







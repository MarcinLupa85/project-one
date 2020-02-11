import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class EaseePurchaseWithNoExtraTest extends TestsBase {

     private HomePageOperations homePageOperations;
     private CustomizationPageOperations customizationPageOperations;
     private CkidPageOperations ckidPageOperations;
     private AddressPageOperations addressPageOperations;
     private SummaryPageOperations summaryPageOperations;
     private CompletePageOperations completePageOperations;



    @BeforeClass
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);
        customizationPageOperations = new CustomizationPageOperations(driver);
        ckidPageOperations = new CkidPageOperations(driver);
        addressPageOperations = new AddressPageOperations(driver);
        summaryPageOperations = new SummaryPageOperations(driver);
        completePageOperations = new CompletePageOperations(driver);
    }

    @Test
    public void testEaseePurchaseFlowWithNoExtra() {
        homePageOperations.openEaseePurchaseFlow();
        assertThat(driver.getCurrentUrl()).contains("/hjemmelading-bestill/customize-order");
        customizationPageOperations.clickNextButton();
        assertThat(driver.getCurrentUrl().contains("circlekid-core"));
        ckidPageOperations.logInWithCredentials("michal.sepczuk+1@edge1s.com","Emobility1");
        assertThat(driver.getCurrentUrl().contains("house-order/delivery-order"));
        //pytanie: czy powinienem tworzyć metody tak by zwracały obiekt PageOperations, tak aby można było chainować metody na tej samej stronie?
        addressPageOperations.fillBillingAddress("Test Addresse 582");
        addressPageOperations.fillBillingCity("Test Billing City");
        addressPageOperations.fillBillingZipCode("72433");
        addressPageOperations.clickNext();
        assertThat(driver.getCurrentUrl().contains("hjemmelading-bestill/confirm-order"));
        summaryPageOperations.tickTcCheckbox();
        summaryPageOperations.clickNext();
        assertThat(driver.getCurrentUrl().contains("hjemmelading-bestill/complete"));
        completePageOperations.clickBack();
        assertThat(driver.getCurrentUrl().contains("/home"));
    }
}



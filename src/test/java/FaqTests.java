import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FaqTests extends TestsBase {
    private HomePageOperations homePageOperations;
    private OnTheGoPageOperations onTheGoPageOperations;
    private HousePageOperations housePageOperations;
    private ApartmentPageOperations apartmentPageOperations;
    private NavbarOperations navbarOperations;
    private CookiePanelOperations cookiePanelOperations;

    @BeforeMethod
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);
        onTheGoPageOperations = new OnTheGoPageOperations(driver);
        housePageOperations = new HousePageOperations(driver);
        apartmentPageOperations = new ApartmentPageOperations(driver);
        navbarOperations = new NavbarOperations(driver);
        cookiePanelOperations = new CookiePanelOperations(driver);
    }

    @TestCaseId(testRailCaseId = 1208)
    @Test
    public void homePageGoToFaqTest() {
        homePageOperations.goToFaq();
    }

    @TestCaseId(testRailCaseId = 1206)
    @Test
    public void onTheGoPageGoToFaqTest() {
        navbarOperations.openOnTheGoPage();
        onTheGoPageOperations.goToFaq();
    }

    @TestCaseId(testRailCaseId = 1207)
    @Test
    public void housePageGoToFaqTest() {
        navbarOperations.openHousePage();
        housePageOperations.goToFaq();
    }

    @TestCaseId(testRailCaseId = 1209)
    @Test
    public void apartmentPageGoToFaqTest() {
        navbarOperations.openNavbarDropdown();
        navbarOperations.openApartmentPage();
        apartmentPageOperations.goToFaq();
    }
}

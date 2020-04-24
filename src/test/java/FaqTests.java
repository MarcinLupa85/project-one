import config.TestsBase;
import operations.ApartmentPageOperations;
import operations.CookiePanelOperations;
import operations.HomePageOperations;
import operations.NavbarOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FaqTests extends TestsBase {
    private HomePageOperations homePageOperations;
    private ApartmentPageOperations apartmentPageOperations;
    private NavbarOperations navbarOperations;
    private CookiePanelOperations cookiePanelOperations;

    @BeforeMethod
    private void initOperations() {
        homePageOperations = new HomePageOperations(driver);
        apartmentPageOperations = new ApartmentPageOperations(driver);
        navbarOperations = new NavbarOperations(driver);
        cookiePanelOperations = new CookiePanelOperations(driver);
    }

    @Test
    public void homePageGoToFaqTest() {
        homePageOperations.goToFaq();
    }

    @Test
    public void apartmentPageGoToFaqTest() {
        navbarOperations.openNavbarDropdown();
        navbarOperations.openApartmentPage();
        apartmentPageOperations.goToFaq();
    }

    @Test
    public void housePageGoToFaqTest() {

    }
}

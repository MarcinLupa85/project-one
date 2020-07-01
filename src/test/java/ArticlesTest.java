import com.circlekeurope.testrail.client.annotations.TestCaseId;
import config.TestsBase;
import operations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class ArticlesTest extends TestsBase {
    private NavbarOperations navbarOperations;
    private ArticlesPageOperations articlesPageOperations;
    private OnTheGoPageOperations onTheGoPageOperations;
    private HousePageOperations housePageOperations;
    private ApartmentPageOperations apartmentPageOperations;
    private DeveloperPageOperations developerPageOperations;

    @BeforeMethod
    private void initOperations() {
        navbarOperations = new NavbarOperations(driver);
        articlesPageOperations = new ArticlesPageOperations(driver);
        onTheGoPageOperations = new OnTheGoPageOperations(driver);
        housePageOperations = new HousePageOperations(driver);
        apartmentPageOperations = new ApartmentPageOperations(driver);
        developerPageOperations = new DeveloperPageOperations(driver);
    }

    @TestCaseId(testRailCaseId = 2858)
    @Test
    public void goAndCheckToArticlesTest() throws TimeoutException {
        navbarOperations.openAndVerifyArticlesPage();
    }

    @TestCaseId(testRailCaseId = 2859)
    @Test
    public void checkOnTheGoArticlesTest() throws TimeoutException {
        navbarOperations.openAndVerifyArticlesPage();
        List<String> OTGTitles = articlesPageOperations.listThreeOnTheGoArticles();
        navbarOperations.openOnTheGoPage();
        onTheGoPageOperations.compareTitles(OTGTitles);

    }

    @TestCaseId(testRailCaseId = 2860)
    @Test
    public void checkHouseArticlesPage() throws TimeoutException {
        navbarOperations.openAndVerifyArticlesPage();
        List<String> houseTitles = articlesPageOperations.listThreeHouseArticles();
        navbarOperations.openHousePage();
        housePageOperations.compareTitles(houseTitles);
    }

    @TestCaseId(testRailCaseId = 2861)
    @Test
    public void checkApartmentArticlesPage() throws TimeoutException {
        navbarOperations.openAndVerifyArticlesPage();
        List<String> apartmentTitles = articlesPageOperations.listThreeApartmentArticles();
        navbarOperations.openNavbarDropdown();
        navbarOperations.openApartmentPage();
        apartmentPageOperations.compareTitles(apartmentTitles);
    }

    @TestCaseId(testRailCaseId = 2862)
    @Test
    public void checkDeveloperArticlesPage() throws TimeoutException {
        navbarOperations.openAndVerifyArticlesPage();
        List<String> developerTitles = articlesPageOperations.listThreeDeveloperArticles();
        navbarOperations.openNavbarDropdown();
        navbarOperations.openDeveloperPage();
        apartmentPageOperations.compareTitles(developerTitles);
    }

}

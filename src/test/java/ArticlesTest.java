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

    @TestCaseId(testRailCaseId = 1183)
    @Test
    public void goAndCheckToArticlesTest() throws TimeoutException {
        navbarOperations.openArticlesPage();
        articlesPageOperations.assertNewsPageTitle();
    }

    @TestCaseId(testRailCaseId = 1186)
    @Test
    public void checkOnTheGoArticlesTest() throws TimeoutException {
        navbarOperations.openArticlesPage();
        List<String> OTGTitles = articlesPageOperations.addToList("Ladestasjoner");
        navbarOperations.openOnTheGoPage();
        onTheGoPageOperations.compareTitles(OTGTitles);
    }

    @TestCaseId(testRailCaseId = 1187)
    @Test
    public void checkHouseArticlesPage() throws TimeoutException {
        navbarOperations.openArticlesPage();
        List<String> houseTitles = articlesPageOperations.addToList("Hjemmelading");
        navbarOperations.openHousePage();
        housePageOperations.compareTitles(houseTitles);
        housePageOperations.openHouseAndCabinPage();
        apartmentPageOperations.compareTitles(houseTitles);
    }

    @TestCaseId(testRailCaseId = 1189)
    @Test
    public void checkCompanyArticlesPage() throws TimeoutException {
        navbarOperations.openArticlesPage();
        List<String> companyTitles = articlesPageOperations.addToList("Bedrift");
        navbarOperations.openCompanyPage();
        apartmentPageOperations.compareTitles(companyTitles);
    }

    @TestCaseId(testRailCaseId = 6097)
    @Test
    public void checkDeveloperArticlesPage() throws TimeoutException {
        navbarOperations.openArticlesPage();
        List<String> developerTitles = articlesPageOperations.addToList("Ladepartnere");
        developerPageOperations.openDeveloperPage();
        developerPageOperations.compareTitles(developerTitles);
    }


    @TestCaseId(testRailCaseId = 5720)
    @Test
    public void checkPartnerArticlesPage() throws TimeoutException {
        navbarOperations.openArticlesPage();
        List<String> partnerTitles = articlesPageOperations.addToList("Referanser");
        navbarOperations.openPartnerPage();
        developerPageOperations.compareTitles(partnerTitles);
    }
}

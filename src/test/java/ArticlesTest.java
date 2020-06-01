import config.TestsBase;
import operations.ArticlesPageOperations;
import operations.HousePageOperations;
import operations.NavbarOperations;
import operations.OnTheGoPageOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeoutException;

public class ArticlesTest extends TestsBase {
    private NavbarOperations navbarOperations;
    private ArticlesPageOperations articlesPageOperations;
    private OnTheGoPageOperations onTheGoPageOperations;
    private HousePageOperations housePageOperations;

    @BeforeMethod
    private void initOperations() {
        navbarOperations = new NavbarOperations(driver);
        articlesPageOperations = new ArticlesPageOperations(driver);
        onTheGoPageOperations = new OnTheGoPageOperations(driver);
        housePageOperations = new HousePageOperations(driver);
    }


    @Test
    public void goAndCheckToArticlesTest() throws TimeoutException {
        navbarOperations.openAndVerifyArticlesPage();
    }

    @Test
    public void checkOnTheGoArticlesTest() throws TimeoutException {
        navbarOperations.openAndVerifyArticlesPage();
        List<String> OTGTitles = articlesPageOperations.listThreeOnTheGoArticles();
        navbarOperations.openOnTheGoPage();
        onTheGoPageOperations.compareTitles(OTGTitles);

    }
    @Test
    public void checkHouseArticlesPage() throws TimeoutException {
        navbarOperations.openAndVerifyArticlesPage();
        List<String> houseTitles = articlesPageOperations.listThreeHouseArticles();
        navbarOperations.openHousePage();
        housePageOperations.compareTitles(houseTitles);
    }

}

import config.TestsBase;
import operations.ArticlesPageOperations;
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

    @BeforeMethod
    private void initOperations() {
        navbarOperations = new NavbarOperations(driver);
        articlesPageOperations = new ArticlesPageOperations(driver);
        onTheGoPageOperations = new OnTheGoPageOperations(driver);
    }


    @Test
    public void goToArticlesTest() throws TimeoutException {
        navbarOperations.openAndVerifyArticlesPage();
    }

    @Test
    public void checkOnTheGoArticlesTest() throws TimeoutException {
        navbarOperations.openAndVerifyArticlesPage();
        List<String> titles = articlesPageOperations.listThreeOnTheGoArticles();
        navbarOperations.openOnTheGoPage();
        onTheGoPageOperations.compareTitles(titles);

    }
}

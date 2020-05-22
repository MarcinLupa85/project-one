import config.TestsBase;
import operations.NavbarOperations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArticlesTest extends TestsBase {
    private NavbarOperations navbarOperations;

    @BeforeMethod
    private void initOperations() {
        navbarOperations = new NavbarOperations(driver);
    }

    @Test
    public void goToArticlesTest() {
        navbarOperations.openArticlesPage();
    }

    @Test
    public void checkOnTheGoArticlesTest() {
        navbarOperations.openArticlesPage();


    }
}

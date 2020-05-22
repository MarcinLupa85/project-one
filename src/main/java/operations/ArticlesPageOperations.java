package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.ArticlesPageObject;
import utils.WaitUtils;

public class ArticlesPageOperations {
    private ArticlesPageObject articlesPageObject;
    private WaitUtils waitUtils;

    public ArticlesPageOperations(WebDriver driver) {
        articlesPageObject = new ArticlesPageObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void ListThreeOnTheGoArticles() {
        articlesPageObject.getCategoryName().stream()
            .limit(3);
    }
}

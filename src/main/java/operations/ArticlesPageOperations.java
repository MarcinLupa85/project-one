package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.ArticlesPageObject;
import utils.WaitUtils;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

public class ArticlesPageOperations {
    private ArticlesPageObject articlesPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public ArticlesPageOperations(WebDriver driver) {
        articlesPageObject = new ArticlesPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public List<String> listThreeOnTheGoArticles() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        List<String> listThreeOnTheGoArticles = articlesPageObject.getArticleBody()
                .stream()
                .filter(webElement -> webElement.findElement(By.className("article__category")).getText().contains("Hurtiglading"))
                .map(webElement -> webElement.findElement(By.className("article__title")).getText())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(listThreeOnTheGoArticles);
        return listThreeOnTheGoArticles;
    }

    public List<String> listThreeHouseArticles() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        List<String> listThreeOnTheGoArticles = articlesPageObject.getArticleBody()
                .stream()
                .filter(webElement -> webElement.findElement(By.className("article__category")).getText().contains("Hjemmelading"))
                .map(webElement -> webElement.findElement(By.className("article__title")).getText())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(listThreeOnTheGoArticles);
        return listThreeOnTheGoArticles;
    }


}

package operations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import pageobjects.ArticlesPageObject;
import utils.WaitUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ArticlesPageOperations {
    private static final Logger LOGGER = LogManager.getLogger(ArticlesPageOperations.class);
    private ArticlesPageObject articlesPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public ArticlesPageOperations(WebDriver driver) {
        articlesPageObject = new ArticlesPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public List<String> addToList(String category) throws TimeoutException {
        List<String> listOfArticles = new ArrayList<>();
        List<String> subListOfArticles;
        while (listOfArticles.size() < 3) {
            waitUtils.waitForDocumentReadyState();
            subListOfArticles = articlesPageObject.getArticleTitleCategoryList()
                    .stream()
                    .filter(webElement -> webElement.findElement(By.className("article-tile__category")).getText().contains(category))
                    .map(webElement -> webElement.findElement(By.className("article-tile__title")).getText())
                    .limit(3)
                    .collect(Collectors.toList());
            listOfArticles.addAll(subListOfArticles);
            try {
                articlesPageObject.getNextButton().click();
            } catch (NoSuchElementException e2) {
                LOGGER.error("No more pages to load", e2);
                break;
            }
        }
        return listOfArticles.stream().limit(3).collect(Collectors.toList());
    }

    public void assertNewsPageTitle() throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        assertThat(driver.findElement(By.xpath("//h1[contains(text(), 'Ladenytt')]")).isDisplayed());
    }
}
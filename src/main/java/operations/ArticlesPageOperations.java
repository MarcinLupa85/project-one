package operations;

import com.google.inject.internal.cglib.transform.$ClassTransformer;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.ArticlesPageObject;
import utils.WaitUtils;

import java.util.ArrayList;
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

    public List<String> addToList(String category) throws TimeoutException {
        List<String> listOfArticles = new ArrayList<>();
        List<String> subListOfArticles;
        while (listOfArticles.size()<3) {
        waitUtils.waitForDocumentReadyState();
            subListOfArticles = articlesPageObject.getArticleTitleCategoryList()
                .stream()
                .filter(webElement -> {
                    try {
                        if (webElement.findElement(By.className("article-tile__category")) != null
                                && StringUtils.contains(webElement.findElement(By.className("article-tile__category")).getText(), category)) {
                            return true;
                        }
                    } catch(NoSuchElementException e){
                        System.out.println("NoSuchElementException occured");
                    }
                    return false;
                })
                .map(webElement -> webElement.findElement(By.className("article-tile__title")) != null ? webElement.findElement(By.className("article-tile__title")).getText() : "NO_TITLE_FOUND")
                .limit(3)
                .collect(Collectors.toList());
            listOfArticles.addAll(subListOfArticles);
            articlesPageObject.getNextButton().click();
        }
        return listOfArticles.stream().limit(3).collect(Collectors.toList());
    }
}
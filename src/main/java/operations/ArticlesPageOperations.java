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
//    private  List<String> listOfArticles = new ArrayList<>();

    public ArticlesPageOperations(WebDriver driver) {
        articlesPageObject = new ArticlesPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
//        this.listOfArticles = listOfArticles;
    }

//    private class Article {
//        String articleTitle = articlesPageObject.getArticleTitle().getText();
//        String articleCategory = articlesPageObject.getArticleCategory().getText();
//    }
//
//    public List<String> listArticles(String category){
//        List<Article> articles = new ArrayList<>();
//        String categoryName = driver.findElement(By.className("article-tile__category")).getText();
//        for (article : articles) {
//            if(categoryName == category){
//                articles.add(articleTitle);
//            }
//        }
//    }


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


//    private List<String> listThreeArticles(String category) throws TimeoutException {
//        while (listOfArticles.size()<3) {
//            waitUtils.waitForDocumentReadyState();
//            List<String> listOfArticles = articlesPageObject.getArticleTitleCategoryList()
//                    .stream()
//                    .filter(webElement -> webElement.findElement(By.className("article-tile__category")).getText().contains(category))
//                    .map(webElement -> webElement.findElement(By.className("article-tile__title")).getText())
////                .limit(3)
//                    .collect(Collectors.toList());
//            articlesPageObject.getNextButton().click();
//            System.out.println(listOfArticles);
//            return listOfArticles;
//        }
//        return listOfArticles;
//    }

//    public List<String> addToList(String category) throws TimeoutException {
//        while (listOfArticles.size()<3) {
//            waitUtils.waitForDocumentReadyState();
//            List<String> listOfArticles = articlesPageObject.getArticleTitleCategoryList()
//                    .stream()
//                    .filter(webElement -> webElement.findElement(By.className("article-tile__category")).getText().contains(category))
//                    .map(webElement -> webElement.findElement(By.className("article-tile__title")).getText())
////                .limit(3)
//                    .collect(Collectors.toList());
//            articlesPageObject.getNextButton().click();
//            return listOfArticles;
//        }
//        System.out.println(listOfArticles);
//        return listOfArticles;
//        String abc = listOfArticles.get(0);
//    }
//}

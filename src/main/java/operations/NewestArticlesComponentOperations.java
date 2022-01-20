package operations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.WithNewestArticlePageObject;
import utils.WaitUtils;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class NewestArticlesComponentOperations {
    private static final Logger LOGGER = LogManager.getLogger(NewestArticlesComponentOperations.class);
    private final WithNewestArticlePageObject page;
    private WaitUtils waitUtils;

    public NewestArticlesComponentOperations(WithNewestArticlePageObject page, WebDriver driver) {
        this.page = page;
        waitUtils = new WaitUtils(driver);
    }

    public void compareTitles(List<String> apartmentTitles) throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        List<String> compareTitles = page.getArticleBody().get(0).findElements(By.className("article-tile__title"))
                .stream()
                .map(WebElement::getText).collect(Collectors.toList());
        compareTitles.forEach(LOGGER::info);
        assertThat(apartmentTitles).hasSameSizeAs(compareTitles);
        apartmentTitles.forEach(title -> assertThat(compareTitles).contains(title));
    }
}

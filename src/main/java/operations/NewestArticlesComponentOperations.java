package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.WithNewestArticlePageObject;
import utils.WaitUtils;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class NewestArticlesComponentOperations {
    private final WithNewestArticlePageObject page;
    private WaitUtils waitUtils;

    public NewestArticlesComponentOperations(WithNewestArticlePageObject page, WebDriver driver) {
        this.page = page;
        waitUtils = new WaitUtils(driver);
    }

    public void compareTitles(List<String> apartmentTitles) throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        List<String> compareTitles = page.getArticleBody().stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(apartmentTitles).hasSameSizeAs(compareTitles);
        apartmentTitles.forEach(title -> assertThat(compareTitles).contains(title));
    }
}

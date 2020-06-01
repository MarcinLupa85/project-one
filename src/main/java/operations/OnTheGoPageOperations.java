package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.OnTheGoPageObject;
import utils.WaitUtils;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;

public class OnTheGoPageOperations {
    private OnTheGoPageObject onTheGoPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public OnTheGoPageOperations(WebDriver driver) {
        onTheGoPageObject = new OnTheGoPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void goToFaq() {
        WebElement readMoreFaqButton = onTheGoPageObject.getReadMoreFaqButton();
        waitUtils.waitForVisiblityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContains("/on-the-go",2);
        assertThat(driver.getCurrentUrl()).contains("/on-the-go");
    }

    public void compareTitles(List<String> titles) throws TimeoutException {
        waitUtils.waitForDocumentReadyState();
        List<String> compareTitles = onTheGoPageObject.getArticleBody().stream().map(WebElement::getText).collect(Collectors.toList());
        assertThat(titles).hasSameSizeAs(compareTitles);
        titles.forEach(title -> assertThat(compareTitles).contains(title));
    }
}

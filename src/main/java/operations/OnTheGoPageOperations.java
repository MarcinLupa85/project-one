package operations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.OnTheGoPageObject;
import utils.WaitUtils;

import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.assertj.core.api.Assertions.assertThat;

public class OnTheGoPageOperations {
    private static final Logger LOGGER = LogManager.getLogger(OnTheGoPageOperations.class);
    private OnTheGoPageObject onTheGoPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;
    private NewestArticlesComponentOperations newestArticlesComponentOperations;

    public OnTheGoPageOperations(WebDriver driver) {
        onTheGoPageObject = new OnTheGoPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        newestArticlesComponentOperations = new NewestArticlesComponentOperations(onTheGoPageObject, driver);
    }

    public void goToFaq() {
        WebElement readMoreFaqButton = onTheGoPageObject.getReadMoreFaqButton();
        waitUtils.waitForVisibilityOf(readMoreFaqButton);
        waitUtils.bringElementToViewport(readMoreFaqButton);
        readMoreFaqButton.click();
        waitUtils.waitForUrlToContain("/ladestasjoner/faq", 2);
        assertThat(driver.getCurrentUrl()).contains("/ladestasjoner/faq");
    }

    public void compareTitles(List<String> OTGTitles) throws TimeoutException {
        newestArticlesComponentOperations.compareTitles(OTGTitles);
        OTGTitles.forEach(LOGGER::info);
    }
}

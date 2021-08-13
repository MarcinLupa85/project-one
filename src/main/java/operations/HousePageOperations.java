package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.HousePageObject;
import utils.WaitUtils;

import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import static config.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;

public class HousePageOperations {
    private HousePageObject housePageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;
    private NewestArticlesComponentOperations newestArticlesComponentOperations;
    private NavbarOperations navbarOperations;

    public HousePageOperations(WebDriver driver) {
        housePageObject = new HousePageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        newestArticlesComponentOperations = new NewestArticlesComponentOperations(housePageObject, driver);
        navbarOperations = new NavbarOperations(driver);
    }

    public void goToFaq() {
        housePageObject.getHouseFAQ().click();
        waitUtils.waitForUrlToContains("/hjemmelading/faq",2);
        assertThat(driver.getCurrentUrl()).contains("/hjemmelading/faq");
    }

    public void compareTitles(List<String> houseTitles) throws TimeoutException {
        newestArticlesComponentOperations.compareTitles(houseTitles);
        System.out.println(houseTitles);
    }

}

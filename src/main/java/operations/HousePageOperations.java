package operations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageobjects.HousePageObject;

import java.util.List;
import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static testdata.EvRoutes.Navbar.HOUSEANDHUT_PAGE;

public class HousePageOperations extends BaseOperations {
    private static final Logger LOGGER = LogManager.getLogger(HousePageOperations.class);
    private HousePageObject housePageObject;
    private NewestArticlesComponentOperations newestArticlesComponentOperations;

    public HousePageOperations(WebDriver driver) {
        super(driver);
        housePageObject = new HousePageObject(driver);
        newestArticlesComponentOperations = new NewestArticlesComponentOperations(housePageObject, driver);
    }

    public void goToFaq() {
        housePageObject.getHouseFAQ().click();
        waitUtils.waitForUrlToContain("/hjemmelading/faq", 2);
        assertThat(driver.getCurrentUrl()).contains("/hjemmelading/faq");
    }

    public void compareTitles(List<String> houseTitles) throws TimeoutException {
        newestArticlesComponentOperations.compareTitles(houseTitles);
        houseTitles.forEach(LOGGER::info);
    }

    public void openHouseAndCabinPage() {
        driver.navigate().to(BASE_URL + HOUSEANDHUT_PAGE);
    }

}

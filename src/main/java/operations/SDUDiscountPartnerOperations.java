package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.SDUDiscountPartnerPageObject;
import utils.WaitUtils;

import static config.Constants.BASE_URL;

public class SDUDiscountPartnerOperations {
    private WaitUtils waitUtils;
    private WebDriver driver;
    private SDUDiscountPartnerPageObject sduDiscountPartnerPageObject;

    public SDUDiscountPartnerOperations(WebDriver driver) {
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
        sduDiscountPartnerPageObject = new SDUDiscountPartnerPageObject(driver);
    }

    public void goToObosDiscountPage(){
        driver.navigate().to(BASE_URL + "/partnere/obos");
    }

    public void goToCoopDiscountPage(){
        driver.navigate().to(BASE_URL + "/partnere/coop");
    }
    public void goToNafDiscountPage(){
        driver.navigate().to(BASE_URL + "/partnere/naf");
    }

}

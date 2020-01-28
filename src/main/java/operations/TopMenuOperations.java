package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.TopMenuObject;
import utils.WaitUtils;

public class TopMenuOperations {

    private TopMenuObject topMenuObject;
    private WaitUtils waitUtils;

    public TopMenuOperations(WebDriver driver) {
        topMenuObject = new TopMenuObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void openAboutUsPage() {
        topMenuObject.getAboutUsLink().click();
        waitUtils.waitForUrlToContains("/team");
    }

    public void openContactPage() {
        topMenuObject.getContactLink().click();
        waitUtils.waitForUrlToContains("/kontakt");
    }

    public void openFaqPage() {
        topMenuObject.getFaqLink().click();
        waitUtils.waitForUrlToContains("/spørsmål-og-svar");
    }

    public void openOtgPage() {
        topMenuObject.getOtgLink().click();
        waitUtils.waitForUrlToContains("/ladestasjoner");
    }

    public void openHousePage() {
        topMenuObject.getHouseLink().click();
        waitUtils.waitForUrlToContains("/hjemmelading");
    }

    public void openApartmentPage() {
        topMenuObject.getApartmentLink().click();
        waitUtils.waitForUrlToContains("/sameie-borettslag");
    }

    public void openUtbyggerPage() {
        topMenuObject.getUtbyggerLink().click();
        waitUtils.waitForUrlToContains("/utbygger");
    }

    public void openBusinessPage() {
        topMenuObject.getBusinessLink().click();
        waitUtils.waitForUrlToContains("/bedrift");
    }

    public void openStationMapPage() {
        topMenuObject.getStationMapLink().click();
        waitUtils.waitForUrlToContains("/ladekart");
    }

    public void openNewsPage() {
        topMenuObject.getNewsLink().click();
        waitUtils.waitForUrlToContains("/nyheter/1");
    }

    public void openJoinUsPage() {
        topMenuObject.getJoinUsLink().click();
        waitUtils.waitForUrlToContains("/ladeapp");
    }
}

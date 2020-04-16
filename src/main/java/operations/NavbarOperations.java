package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.NavbarObject;
import utils.WaitUtils;

public class NavbarOperations {

    private NavbarObject navbarObject;
    private WaitUtils waitUtils;

    public NavbarOperations(WebDriver driver) {
        navbarObject = new NavbarObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void openAboutUsPage() {
        navbarObject.getAboutUsLink().click();
        waitUtils.waitForUrlToContains("/team");
    }

    public void openContactPage() {
        waitUtils.waitForElement(navbarObject.getContactLink());
        navbarObject.getContactLink().click();
        waitUtils.waitForUrlToContains("/kontakt");
    }

    public void openFaqPage() {
        navbarObject.getFaqLink().click();
        waitUtils.waitForUrlToContains("/spørsmål-og-svar");
    }

    public void openOtgPage() {
        navbarObject.getOtgLink().click();
        waitUtils.waitForUrlToContains("/ladestasjoner");
    }

    public void openHousePage() {
        navbarObject.getHouseLink().click();
        waitUtils.waitForUrlToContains("/hjemmelading");
    }

    public void openNavbarDropdown() {
        navbarObject.getNavbarDropdown().click();
    }

    public void openApartmentPage() {
        navbarObject.getApartmentLink().click();
        waitUtils.waitForUrlToContains("/sameie-borettslag");
    }

    public void openDeveloperPage() {
        navbarObject.getDeveloperLink().click();
        waitUtils.waitForUrlToContains("/utbygger");
    }

    public void openBusinessPage() {
        navbarObject.getBusinessLink().click();
        waitUtils.waitForUrlToContains("/bedrift");
    }

    public void openStationMapPage() {
        navbarObject.getStationMapLink().click();
        waitUtils.waitForUrlToContains("/ladekart");
    }

    public void openNewsPage() {
        navbarObject.getNewsLink().click();
        waitUtils.waitForUrlToContains("/nyheter/1");
    }

    public void openJoinUsPage() {
        navbarObject.getJoinUsLink().click();
        waitUtils.waitForUrlToContains("/ladeapp");
    }

    public void openFacebookPage() {
        navbarObject.getFacebookLink().click();
        waitUtils.waitForUrlToContains("facebook.com/circleknorge/");
    }

    public void openInstagramPage() {
        navbarObject.getInstagramLink().click();
        waitUtils.waitForUrlToContains("instagram.com/circleknorge/");
    }

    public void openYoutubePage() {
        navbarObject.getYoutubeLink().click();
        waitUtils.waitForUrlToContains("youtube.com/playlist?list=PLOt-ClfT-VEgU-nxudMqsINMByvW94ala");
    }
}

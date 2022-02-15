package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.CustomizationPageObject;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static testdata.EvRoutes.Partner.CUSTOMIZED_PAGE;

public class CustomizationPageOperations extends BaseOperations {

    private CustomizationPageObject customizationPageObject;

    public CustomizationPageOperations(WebDriver driver) {
        super(driver);
        customizationPageObject = new CustomizationPageObject(driver);
    }

    public void clickSubmitButton() throws TimeoutException {
        WebElement submitButton = customizationPageObject.getSubmitButton();
        waitUtils.waitForVisibilityOf(submitButton);
        waitUtils.waitForDocumentReadyState();
        submitButton.click();
        waitUtils.waitForPresenceOf(By.id("CybotCookiebotDialogBody"));
    }

    public void tickExtraCheckbox() {
        waitUtils.waitForElementToBeClickable(customizationPageObject.getInstallationCheckbox()).click();
        customizationPageObject.getExtraCheckbox().click();
    }

    public void tickInstallationCheckbox() {
        waitUtils.waitForElementToBeClickable(customizationPageObject.getInstallationCheckbox()).click();
    }

    public void tickUtilityCheckbox() {
        waitUtils.waitForElementToBeClickable(customizationPageObject.getUtilityCheckbox()).click();
    }

    public void addEqualizer() {
        waitUtils.waitForElementToBeClickable(customizationPageObject.getAddEqualizer()).click();
    }

    //TODO add usage of that method in tests or remove if not needed
    public void addCharger() {
        customizationPageObject.getEaseeNumberSelector().click();
    }

    public void goToNafSDUPartner() {
        driver.navigate().to(BASE_URL + CUSTOMIZED_PAGE + "Y21-740505");
        waitUtils.waitForVisibilityOf(customizationPageObject.getSubmitButton());
    }

    public void goToSmbSDUPartner() {
        driver.navigate().to(BASE_URL + CUSTOMIZED_PAGE + "Y21-832885");
        waitUtils.waitForVisibilityOf(customizationPageObject.getSubmitButton());
    }

    public void goToIglandSDUPartner() {
        driver.navigate().to(BASE_URL + CUSTOMIZED_PAGE + "Y21-950539");
        waitUtils.waitForVisibilityOf(customizationPageObject.getSubmitButton());
    }

    public void goToMDULight() {
        driver.navigate().to(BASE_URL + CUSTOMIZED_PAGE + "Y21-580541");
        waitUtils.waitForVisibilityOf(customizationPageObject.getSubmitButton());
    }

    public void goToMDUReady() {
        driver.navigate().to(BASE_URL + CUSTOMIZED_PAGE + "Y21-18954");
        waitUtils.waitForVisibilityOf(customizationPageObject.getSubmitButton());
    }

    //TODO add usage of that method in tests or remove if not needed
    public void goToMDULeasing() {
        driver.navigate().to(BASE_URL + CUSTOMIZED_PAGE + "Y21-35010");
        waitUtils.waitForVisibilityOf(customizationPageObject.getSubmitButton());
        driver.findElement(By.xpath("//*[contains(text(),'Leie av ladeboks')]")).click();
    }

    public void checkPriceFormat() {
        assertThat(customizationPageObject.getTotalPrice().getText()).containsPattern("\\s\\d+.\\d{3},-");
    }

    //TODO add usage of that method in tests or remove if not needed
    public void checkMDULeasingPriceFormat() {
        assertThat(customizationPageObject.getSubscriptionPrice().getText()).containsPattern("\\s\\d{3},-");
    }

    public void fillMembershipNumber(String membershipNumber) {
        waitUtils.waitForVisibilityOf(customizationPageObject.getMembershipNumber());
        customizationPageObject.getMembershipNumber().sendKeys(membershipNumber);
    }
}

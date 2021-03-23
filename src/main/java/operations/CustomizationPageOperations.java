package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.CustomizationPageObject;
import utils.WaitUtils;

import java.util.concurrent.TimeoutException;

import static config.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomizationPageOperations {

    private CustomizationPageObject customizationPageObject;
    private WaitUtils waitUtils;
    WebDriver driver;

    public CustomizationPageOperations(WebDriver driver) {
        customizationPageObject = new CustomizationPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void clickSubmitButton() throws TimeoutException {
        WebElement submitButton = customizationPageObject.getSubmitButton();
        waitUtils.waitForVisiblityOf(submitButton);
        waitUtils.waitForDocumentReadyState();
        submitButton.click();
        waitUtils.waitForPresentOf(By.id("CybotCookiebotDialogBody"));
    }


//TODO change metod to be more universal (mennekes, cables) using ENUM
    private void selectEaseeAmount (Integer value) {
        WebElement selectContainer = customizationPageObject.getEaseeNumberSelector();
        selectContainer.click();
        WebElement optionsContainer = selectContainer.findElement(By.cssSelector("div.selector-dropdown.visible"));
        optionsContainer.findElements(By.cssSelector("div.option-box"))
                .stream()
                .filter(element ->element.getText().equals(String.valueOf(value)))
                .findFirst()
                .get()
                .click();
    }

    public void tickExtraCheckbox() {
        customizationPageObject.getInstallationCheckbox().click();
        customizationPageObject.getExtraCheckbox().click();
    }

    public void tickInstallationCheckbox() {
        customizationPageObject.getInstallationCheckbox().click();
    }

    public void addEqualizer() {
        customizationPageObject.getAddEqualizer().click();
    }

    public void goToSDUPartner() {
        driver.navigate().to(BASE_URL + "bestill/Y21-74576");
        waitUtils.waitForVisiblityOf(customizationPageObject.getSubmitButton());
    }

    public void goToMDULight() {
        driver.navigate().to(BASE_URL + "bestill/Y21-785527");
        waitUtils.waitForVisiblityOf(customizationPageObject.getSubmitButton());
    }

    public void goToMDUReady() {
        driver.navigate().to(BASE_URL + "bestill/Y21-723430");
        waitUtils.waitForVisiblityOf(customizationPageObject.getSubmitButton());
    }

    public void goToMDULeasing() {
        driver.navigate().to(BASE_URL + "bestill/Y21-682527");
        waitUtils.waitForVisiblityOf(customizationPageObject.getSubmitButton());
    }

    public void checkSDUPartnerPrices() {
        assertThat(customizationPageObject.getTotalPrice().getText()).containsPattern("\\s6.895,-");
    }

    public void checkMDULightPrices() {
        assertThat(customizationPageObject.getTotalPrice().getText()).containsPattern("\\s19.990,-");
    }
    public void checkMDUReadyPrices() {
        assertThat(customizationPageObject.getTotalPrice().getText()).containsPattern("\\s16.990,-");
    }

    public void checkMDULeasingPrices() {
        assertThat(customizationPageObject.getTotalPrice().getText()).containsPattern("\\s199,-");
    }

    public void fillMembershipNumber(String membershipNumber) {
        waitUtils.waitForVisiblityOf(customizationPageObject.getMembershipNumber());
        customizationPageObject.getMembershipNumber().sendKeys(membershipNumber);
    }

}

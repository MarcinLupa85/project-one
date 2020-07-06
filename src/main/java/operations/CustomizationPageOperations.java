package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.CustomizationPageObject;
import utils.WaitUtils;

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

    public void clickSubmitButton() {
        WebElement submitButton = customizationPageObject.getSubmitButton();
        waitUtils.waitForVisiblityOf(submitButton);
        submitButton.click();
        waitUtils.waitForPresentOf(By.id("submit-registration-step-one"));
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

    public void goToBigTrial() {
        driver.navigate().to(BASE_URL + "apartment-order/customize-order?id=8226947439e34584a4e13a641408e2ac");
        waitUtils.waitForVisiblityOf(customizationPageObject.getSubmitButton());
    }

    public void goToBig() {
        driver.navigate().to(BASE_URL + "apartment-order/customize-order?id=5a134d8704314215bccbd8b38129dffc");
        waitUtils.waitForVisiblityOf(customizationPageObject.getSubmitButton());
    }

    public void goToInglandGarasjen() {
        driver.navigate().to(BASE_URL + "hjemmelading-bestill/customize-order?offer_id=28a3d121e93045d8bae308dbfbcc17ca");
        waitUtils.waitForVisiblityOf(customizationPageObject.getSubmitButton());
    }

    public void goToObos() {
        driver.navigate().to(BASE_URL + "hjemmelading-bestill/customize-order?offer_id=0b0c7f3a588611ea8e2d0242ac130003");
        waitUtils.waitForVisiblityOf(customizationPageObject.getSubmitButton());
    }

    public void goToPolestar() {
        driver.navigate().to(BASE_URL + "hjemmelading-bestill/customize-order?offer_id=22857be80c644c47a2d40c37ed9da68c");
        waitUtils.waitForVisiblityOf(customizationPageObject.getSubmitButton());;
    }

    public void checkBigTrialPrices() {
        WebElement totalPrice = customizationPageObject.getTotalPrice();
        assertThat(totalPrice.getText()).containsPattern("kr\\s20.990,-");
        WebElement subscriptionFee = customizationPageObject.getSubscriptionFee();
        assertThat(subscriptionFee.getText()).containsPattern("kr\\s89,-");
    }

    public void checkBigPrices() {
        WebElement totalPrice = customizationPageObject.getTotalPrice();
        assertThat(totalPrice.getText()).containsPattern("kr\\s22.990,-");
        WebElement subscriptionFee = customizationPageObject.getSubscriptionFee();
        assertThat(subscriptionFee.getText()).containsPattern("kr\\s89,-");
    }

    public void checkInglandGarasjenPrice() {
        WebElement totalPrice = customizationPageObject.getTotalPrice();
        assertThat(totalPrice.getText()).containsPattern("kr\\s7.895,-");
    }

    public void checkObosPrice() {
        tickExtraCheckbox();
        WebElement totalPrice = customizationPageObject.getTotalPrice();
        assertThat(totalPrice.getText()).containsPattern("kr\\s14.490,-");
    }

    public void checkPolestarPrice() {
        tickInstallationCheckbox();
        WebElement totalPrice = customizationPageObject.getTotalPrice();
        assertThat(totalPrice.getText()).containsPattern("kr\\s15.490,-");
    }

    public void fillMembershipNumber(String membershipNumber) {
        customizationPageObject.getMembershipNumber().sendKeys(membershipNumber);
    }
}

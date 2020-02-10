package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.CustomizationPageObject;
import utils.WaitUtils;

import java.util.List;

public class CustomizationPageOperations {

    private CustomizationPageObject customizationPageObject;
    private WaitUtils waitUtils;

    public CustomizationPageOperations(WebDriver driver) {
        customizationPageObject = new CustomizationPageObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void clickNextButton() {
        customizationPageObject.getNextButton().click();
        waitUtils.waitForUrlToContains("circlekid");
    }

    public void clickBackButton() {
        customizationPageObject.getBackButton().click();
        waitUtils.waitForUrlToContains("/hjemmelading");
    }

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
        customizationPageObject.getExtraCheckbox().click();
    }

}

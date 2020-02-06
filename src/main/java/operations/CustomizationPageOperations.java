package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.CustomizationPageObject;
import pageobjects.HomePageObject;
import utils.WaitUtils;

import java.util.List;

public class CustomizationPageOperations {

    private CustomizationPageObject customizationPageObject;
    private WaitUtils waitUtils;

    public CustomizationPageOperations(WebDriver driver) {
        customizationPageObject = new CustomizationPageObject(driver);
        waitUtils = new WaitUtils(driver);
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


    public WebElement selectMennekesAmount() {
        return purchaseFlowEaseeLink;
    }

    public WebElement tickExtraCheckbox() {
        return purchaseFlowEaseeLink;
    }

    public WebElement tickExtraCheckbox() {
        return purchaseFlowEaseeLink;
    }

    public WebElement tickExtraCheckbox() {
        return purchaseFlowEaseeLink;
    }
}

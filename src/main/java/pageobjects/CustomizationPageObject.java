package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomizationPageObject
{
    public CustomizationPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li#id1 app-number-selector")
    private WebElement easeeNumberSelector;

    @FindBy(css = "label.custom-control-center")
    private WebElement installlationCheckbox;

    @FindBy(css= "label[for='join-extra']")
    private WebElement extraCheckbox;

    @FindBy(css = "a[href=\"/hjemmelading\"]")
    private WebElement backButton;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public WebElement getEaseeNumberSelector() { return easeeNumberSelector; }

    public WebElement getInstalllationCheckbox() {return installlationCheckbox; }

    public WebElement getExtraCheckbox() { return extraCheckbox; }

    public WebElement getBackButton() {
        return backButton;
    }

    public WebElement getSubmitButton() { return submitButton; }

}

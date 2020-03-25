package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPageObject {

     public GmailPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input#identifierId")
    private WebElement emailInput;

    @FindBy(css = "input[name=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "span.RveJvd")
    private WebElement nextButton;

    @FindBy(css = "table[aria-readonly=\"true\"] tr:first-child td:nth-child(6)")
    private WebElement firstEmailRow;

    @FindBy(css = "span[style=\"color:rgb(82,78,79);font-size:12pt\"]")
    private WebElement contactFormData;

    @FindBy(css ="div.iH.bzn div.G-tF div.T-I.J-J5-Ji.nX.T-I-ax7.T-I-Js-Gs.mA")
    private WebElement deleteButton;


    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public WebElement getFirstEmailRow() {
        return firstEmailRow;
    }

    public WebElement getContactFormData() {
        return contactFormData;
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }
}

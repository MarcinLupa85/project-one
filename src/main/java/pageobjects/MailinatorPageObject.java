package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailinatorPageObject {
    public MailinatorPageObject(WebDriver driver)  {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addOverlay")
    private WebElement enterMailName;

    @FindBy(css = "input[class='flat']")
    private WebElement mailCheckbox;

    @FindBy(css = "button[title='Delete Emails']")
    private WebElement deleteButton;

    public WebElement getEnterMailName() { return enterMailName; }

    public WebElement getMailCheckbox() { return mailCheckbox; }

    public WebElement getDeleteButton() { return deleteButton; }
}

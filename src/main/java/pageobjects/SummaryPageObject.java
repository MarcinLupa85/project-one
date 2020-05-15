package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPageObject {

    public SummaryPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.custom-radio")
    private WebElement tcCheckbox;

    @FindBy(css = "button[type=submit]")
    private WebElement finishOrderButton;

    public WebElement getFinishOrderButton() { return finishOrderButton; }

    public WebElement getTcCheckbox() { return tcCheckbox; }
}

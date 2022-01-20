package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ContactPageObject extends EvPage {

    public ContactPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement fullNameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "phone")
    private WebElement telephoneNumberInput;

    @FindBy(css = "[id='companyName']")
    private WebElement companyNameInput;

    @FindBy(id = "description")
    private WebElement commentInput;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

}

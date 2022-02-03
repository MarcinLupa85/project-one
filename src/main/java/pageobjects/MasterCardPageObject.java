package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class MasterCardPageObject extends EvPage {
    public MasterCardPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button[data-action='Logg inn']")
    private WebElement logInButton;

    @FindBy(css = "img[alt='Circle K EXTRA Mastercard']")
    private WebElement mastercardBanner;

}

package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CompletePageObject extends EvPage {

    public CompletePageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(text(),'Tilbake til forsiden')]")
    private WebElement backButton;

}

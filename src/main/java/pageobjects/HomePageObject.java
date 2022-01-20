package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePageObject extends EvPage {

    public HomePageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='/elbillading/faq'].btn")
    private WebElement readMoreFaqButton;

    @FindBy(css = "a[href='/elbillading/kontakt-oss'].btn")
    private WebElement contactButton;

}

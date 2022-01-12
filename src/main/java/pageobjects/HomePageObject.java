package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class HomePageObject {

    public HomePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[href='/elbillading/faq'].btn")
    private WebElement readMoreFaqButton;

    @FindBy(css = "a[href='/elbillading/kontakt-oss'].btn")
    private WebElement contactButton;

}

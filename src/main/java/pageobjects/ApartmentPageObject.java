package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ApartmentPageObject extends EvPage implements WithNewestArticlePageObject {

    public ApartmentPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "email")
    private WebElement mail;

    @FindBy(id = "zipCode")
    private WebElement zipCode;

    @FindBy(xpath = "//*[contains(text(),'Send')]")
    private WebElement contactSubmitButton;

    @FindBy(css = "[href='/elbillading/ladetjenester/faq'].btn-primary")
    private WebElement readMoreFaqButton;

    @FindBy(css = "ev-articles-list")
    private List<WebElement> articleBody;

    @FindBy(css = "[class='heading-4']")
    private WebElement thankYouText;

    @FindBy(xpath = "//*[contains(text(),'til borettslag og sameie')]")
    private WebElement redirectToFormButton;

}

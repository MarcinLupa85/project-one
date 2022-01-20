package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class DeveloperPageObject extends EvPage implements WithNewestArticlePageObject {

    public DeveloperPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "membershipOrganization")
    private WebElement membershipOrganization;

    @FindBy(id = "parkingUnits")
    private WebElement parkingUnits;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "ev-articles-list")
    private List<WebElement> articleBody;

}

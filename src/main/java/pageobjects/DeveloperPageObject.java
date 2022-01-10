package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeveloperPageObject implements WithNewestArticlePageObject {
    private DeveloperPageObject developerPageObject;

    public DeveloperPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
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
    private WebElement comapany;

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

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getCompanyNameInput() {
        return comapany;
    }

    public WebElement getMembershipOrganization() {
        return membershipOrganization;
    }

    public WebElement getParkingUnits() {
        return parkingUnits;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public List<WebElement> getArticleBody() {
        return articleBody;
    }
}

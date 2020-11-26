package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DeveloperPageObject implements WithNewestArticlePageObject{
    private DeveloperPageObject developerPageObject;

    public DeveloperPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "mobile")
    private WebElement mobile;

    @FindBy(id = "company")
    private WebElement comapany;

    @FindBy(css = "[id='00N580000082RAX']")
    private WebElement projectName;

    @FindBy(css = "[id='00N1x000001qwx1']")
    private WebElement parkingPlaces;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy (css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(css = "ev-articles-list")
    private List<WebElement> articleBody;

    public WebElement getFirstName() { return firstName; }

    public WebElement getLastName() { return lastName; }

    public WebElement getEmail() { return email; }

    public WebElement getMobile() { return mobile; }

    public WebElement getCompanyNameInput() { return comapany; }

    public WebElement getProjectName() { return projectName; }

    public WebElement getParkingPlaces() { return  parkingPlaces; }

    public WebElement getDescription() { return  description; }

    public WebElement getSubmitButton() { return  submitButton; }

    public List<WebElement> getArticleBody() { return articleBody; }
}
package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ApartmentPageObject implements WithNewestArticlePageObject{
    private ApartmentPageObject apartmentPageObject;

    public ApartmentPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "email")
    private WebElement mail;

    @FindBy(xpath = "//*[contains(text(),'Send')]")
    private WebElement contactSubmitButton;

    @FindBy(css = "[href='/elbillading/ladetjenester/faq'].btn-primary")
    private WebElement readMoreFaqButton;

    @FindBy(css = "ev-articles-list")
    private List<WebElement> articleBody;

    @FindBy(css = "[class='heading-4']")
    private WebElement thankYouText;

    @FindBy(xpath ="//*[contains(text(),'til borettslag og sameie')]" )
    private WebElement redirectToFormButton;

    public WebElement getName() { return name; }

    public WebElement getPhone() { return phone; }

    public WebElement getCompanyNameInput() { return company; }

    public WebElement getMail() { return mail; }

    public WebElement getContactSubmitButton() { return contactSubmitButton; }

    public WebElement getReadMoreFaqButton() { return readMoreFaqButton; }

    public List<WebElement> getArticleBody() { return articleBody; }

    public WebElement getThankYouText() {return thankYouText;}

    public WebElement getRedirectToFormButton() { return redirectToFormButton; }
}

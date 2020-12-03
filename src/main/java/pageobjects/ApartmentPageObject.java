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

    @FindBy(xpath = "//*[contains(text(),'Send')]")
    private WebElement contactSubmitButton;

    @FindBy(css = "[href='/sp%C3%B8rsm%C3%A5l-og-svar/apartment'].btn-primary")
    private WebElement readMoreFaqButton;

    @FindBy(css = "ev-articles-list")
    private List<WebElement> articleBody;

    public WebElement getName() { return name; }

    public WebElement getPhone() { return phone; }

    public WebElement getCompanyNameInput() { return company; }

    public WebElement getContactSubmitButton() { return contactSubmitButton; }

    public WebElement getReadMoreFaqButton() { return readMoreFaqButton; }

    public List<WebElement> getArticleBody() { return articleBody; }
}

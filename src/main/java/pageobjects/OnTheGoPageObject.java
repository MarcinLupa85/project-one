package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class OnTheGoPageObject implements WithNewestArticlePageObject {
    public OnTheGoPageObject(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(css = "[href='/elbillading/ladestasjoner/faq'].btn-primary")
    private WebElement readMoreFaqButton;

    @FindBy(css = "ev-articles-list")
    private List<WebElement> articleBody;

    public WebElement getReadMoreFaqButton() { return readMoreFaqButton; }

    @Override
    public List<WebElement> getArticleBody() { return articleBody; }
}

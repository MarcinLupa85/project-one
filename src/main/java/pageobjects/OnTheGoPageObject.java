package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class OnTheGoPageObject implements WithNewestArticlePageObject {
    public OnTheGoPageObject(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(css = "[href='/sp%C3%B8rsm%C3%A5l-og-svar/on-the-go'].btn-primary")
    private WebElement readMoreFaqButton;

    @FindBy(css = "h4.article__title")
    private List<WebElement> articleBody;

    public WebElement getReadMoreFaqButton() { return readMoreFaqButton; }

    @Override
    public List<WebElement> getArticleBody() { return articleBody; }
}

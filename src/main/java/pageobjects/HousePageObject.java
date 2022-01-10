package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HousePageObject implements WithNewestArticlePageObject {
    public HousePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "ev-articles-list")
    private List<WebElement> articleBody;

    @FindBy(css = "a[href='/elbillading/hjemmelading/faq'].nav-link")
    private WebElement houseFAQ;

    public List<WebElement> getArticleBody() {
        return articleBody;
    }

    public WebElement getHouseFAQ() {
        return houseFAQ;
    }
}

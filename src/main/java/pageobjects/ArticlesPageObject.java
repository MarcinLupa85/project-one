package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ArticlesPageObject {
    public ArticlesPageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.article__category")
    private List<WebElement> categoryName;

    @FindBy(css = "article__title")
    private List<WebElement> titleName;

    @FindBy(css = "div.article__body")
    private List<WebElement> articleBody;

    public List<WebElement> getCategoryName() { return categoryName; }

    public List<WebElement>  getTitleName() { return titleName; }

    public List<WebElement> getArticleBody() { return articleBody; }
}

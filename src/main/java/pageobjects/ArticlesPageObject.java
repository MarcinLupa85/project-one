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

    @FindBy(xpath = ".//div[contains(@class, 'article-tile__category')]/ancestor::ev-article-tile")
    private List<WebElement> articleTitleCategoryList;

    @FindBy(css = "article-tile__category")
    private WebElement articleCategory;

    @FindBy(css = "article-tile__title")
    private WebElement articleTitle;

    @FindBy(css = "li.page-item.page-item__next")
    private WebElement nextButton;

    public List<WebElement> getArticleTitleCategoryList() { return articleTitleCategoryList; }

    public WebElement getArticleCategory() { return articleCategory; }

    public WebElement getArticleTitle() { return articleTitle; }

    public WebElement getNextButton() { return nextButton; }

}

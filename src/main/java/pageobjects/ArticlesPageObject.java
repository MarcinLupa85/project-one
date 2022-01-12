package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class ArticlesPageObject {
    public ArticlesPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//div[contains(@class, 'article-tile__category')]/ancestor::ev-article-tile")
    private List<WebElement> articleTitleCategoryList;

    @FindBy(css = "li.page-item.page-item__next")
    private WebElement nextButton;

}

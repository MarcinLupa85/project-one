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

    @FindBy(css = "div[class='category']")
    private List<WebElement> categoryName;

    @FindBy(css = "div[class='title']")
    private List<WebElement> titleName;

    public List<WebElement> getCategoryName() { return categoryName; }

    public List<WebElement>  getTitleName() { return titleName; }
}

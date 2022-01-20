package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class HousePageObject extends EvPage implements WithNewestArticlePageObject {
    public HousePageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "ev-articles-list")
    private List<WebElement> articleBody;

    @FindBy(css = "a[href='/elbillading/hjemmelading/faq'].nav-link")
    private WebElement houseFAQ;

}

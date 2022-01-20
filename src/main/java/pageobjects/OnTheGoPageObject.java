package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class OnTheGoPageObject extends EvPage implements WithNewestArticlePageObject {
    public OnTheGoPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='/elbillading/ladestasjoner/faq'].btn-primary")
    private WebElement readMoreFaqButton;

    @FindBy(css = "ev-articles-list")
    private List<WebElement> articleBody;

}

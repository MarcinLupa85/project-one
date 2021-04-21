package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HousePageObject implements WithNewestArticlePageObject{
    public HousePageObject(WebDriver driver) { PageFactory.initElements(driver, this); }

    @FindBy(css = "[href='/elbillading/hjemmelading/faq'].btn-primary")
    private WebElement readMoreFaqButton;

    @FindBy(css = "ev-articles-list")
    private List<WebElement> articleBody;

    @FindBy(css = "a[href='/elbillading/bestill?with=1140449']")
    private WebElement purchaseFlowCableLink;

    public WebElement getReadMoreFaqButton() { return readMoreFaqButton; }

    public List<WebElement> getArticleBody() { return articleBody; }

    public WebElement getPurchaseFlowCableLink() { return purchaseFlowCableLink; }
}

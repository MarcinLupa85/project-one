package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

    private TopMenuObject topMenuObject;

    public HomePageObject(WebDriver driver) {
        topMenuObject =  new TopMenuObject(driver);
        PageFactory.initElements(driver, this);
    }

    //czy trzeba scrollowac strone w dol, zeby wykonac .click() na elemencie ktorego nie widac na ekranie?
    @FindBy(css = "a[href='/hjemmelading-bestill/customize-order?id=1'].buttons-wrapper__btn btn btn-primary")
    private WebElement purchaseFlowEaseeLink;

    @FindBy(css = "a[href='/hjemmelading-bestill/customize-order?id=0'].buttons-wrapper__btn btn btn-primary")
    private WebElement purchaseFlowMennekesLink;



    public WebElement getPurchaseFlowEaseeLink() {
        return purchaseFlowEaseeLink;
    }
    public WebElement getPurchaseFlowMennekesLink() {
        return purchaseFlowMennekesLink;
    }
}

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPageObject {
    public ProductsPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='/elbillading/bestill?with=1140446']")
    private WebElement purchaseFlowEaseeLink;

    @FindBy(css = "a[href='/elbillading/bestill?with=1166018']")
    private WebElement purchaseFlowEqualizerLink;

    @FindBy(css = "a[href='/elbillading/bestill?with=1140449']")
    private WebElement purchaseFlowCableLink;

    @FindBy(css = "button.btn-primary")
    private WebElement purchaseInstallationButton;

    public WebElement getPurchaseFlowEaseeLink() { return purchaseFlowEaseeLink; }
    public WebElement getPurchaseFlowEqualizerLink() { return purchaseFlowEqualizerLink; }
    public WebElement getPurchaseFlowCableLink() { return purchaseFlowCableLink; }
    public WebElement getPurchaseInstallationButton() { return purchaseInstallationButton; }
}

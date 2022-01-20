package pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ProductsPageObject extends EvPage {
    public ProductsPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href='/elbillading/bestill?with=1140446']")
    private WebElement purchaseFlowEaseeLink;

    @FindBy(css = "a[href='/elbillading/bestill?with=1166018']")
    private WebElement purchaseFlowEqualizerLink;

    @FindBy(css = "a[href='/elbillading/bestill?with=1140449']")
    private WebElement purchaseFlowCableLink;

    @FindBy(css = "button.btn-primary")
    private WebElement purchaseInstallationButton;

}

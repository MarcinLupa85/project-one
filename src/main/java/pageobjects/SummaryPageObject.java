package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummaryPageObject {

    public SummaryPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li#id0 [rel=\"event:mennekes_popup\"]")
    private WebElement chargerCompatibilityLink;

    @FindBy(css = "li#id0 [href=\"/documents/Mennekes%20Compact%20Produktinformasjon.pdf\"]")
    private WebElement mennekesPdfLink;

    @FindBy(css = "li#id2 [rel=\"event:fenix_info\"]")
    private WebElement cableCompatibilityLink;

    @FindBy(css = "li#id1 [href=\"/documents/Circle%20K%20Easee%20produktinformasjon.pdf\"]")
    private WebElement easeePdfLink;

    @FindBy(css = "li#id1 [rel=\"event:easee_popup\"]")
    private WebElement aboutAbonamentLink;

    @FindBy(css = ".product-option-wrapper__option--link")
    private WebElement productChangeLink;

    @FindBy(css = "app-tile:nth-child(6) .address-line--link")
    private WebElement billingAddressChangeLink;

    @FindBy(css = "app-tile:nth-child(8) .address-line--link")
    private WebElement installationAddressChangeLink;

    @FindBy(css = "a[rel=\"event:terms\"]")
    private WebElement tcLink;

    @FindBy(css = "div.acceptance:first-child input")
    private WebElement tcCheckbox;

    @FindBy(css = "div.acceptance:nth-child(2) input")
    private WebElement fastInstallationCheckbox;

    @FindBy(css = "button[type=submit]")
    private WebElement finishOrderButton;

    public WebElement getFinishOrderButton() {
        return finishOrderButton;
    }

    public WebElement getChargerCompatibilityLink() {
        return chargerCompatibilityLink;
    }

    public WebElement getMennekesPdfLink() {
        return mennekesPdfLink;
    }

    public WebElement getCableCompatibilityLink() {
        return cableCompatibilityLink;
    }

    public WebElement getEaseePdfLink() {
        return easeePdfLink;
    }

    public WebElement getAboutAbonamentLink() {
        return aboutAbonamentLink;
    }

    public WebElement getProductChangeLink() {
        return productChangeLink;
    }

    public WebElement getBillingAddressChangeLink() {
        return billingAddressChangeLink;
    }

    public WebElement getInstallationAddressChangeLink() {
        return installationAddressChangeLink;
    }

    public WebElement getTcLink() {
        return tcLink;
    }

    public WebElement getTcCheckbox() {
        return tcCheckbox;
    }

    public WebElement getFastInstallationCheckbox() {
        return fastInstallationCheckbox;
    }

}

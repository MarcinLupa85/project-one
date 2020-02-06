package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CustomizationPageObject
{

    public CustomizationPageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getEaseeNumberSelector() {
        return easeeNumberSelector;
    }

    @FindBy(css = "li#id1 app-number-selector")
    private WebElement easeeNumberSelector;

    public List<WebElement> getNumberOfZero() {
        return numberOfZero;
    }


    @FindBy(css = "#id1 app-number-selector")
    private WebElement selectContainer;


    @FindBy(css = ".selector-dropdown > .ng-star-inserted:first-child")
    private List<WebElement> numberOfZero;

    @FindBy(css = ".selector-dropdown > .ng-star-inserted:nth-child(2)")
    private List<WebElement> numberOfOne;

    @FindBy(css = ".selector-dropdown > .ng-star-inserted:nth-child(3)")
    private List<WebElement> numberOfTwo;

    @FindBy(css = ".selector-dropdown > .ng-star-inserted:nth-child(4)")
    private List<WebElement> numberOfThree;

    @FindBy(css = ".selector-dropdown > .ng-star-inserted:nth-child(5)")
    private List<WebElement> numberOfFour;

    @FindBy(css = "li#id2 app-number-selector")
    private WebElement cableNumberSelector;

    @FindBy(css = "li#id0 app-number-selector")
    private WebElement mennekesNumberSelector;

    @FindBy(css = "li#id1 .option.ng-star-inserted:first-child")
    private WebElement easeeGreyColorSelector;

    @FindBy(css = "li#id1 .option.ng-star-inserted:nth-child(2)")
    private WebElement easeeBlackColorSelector;

    @FindBy(css = "li#id1 .option.ng-star-inserted:nth-child(3)")
    private WebElement easeeWhiteColorSelector;

    @FindBy(css = "li#id1 .option.ng-star-inserted:nth-child(4)")
    private WebElement easeeRedColorSelector;

    @FindBy(css = "li#id1 .option.ng-star-inserted:nth-child(5)")
    private WebElement easeeBlueColorSelector;


    @FindBy(css = "li#id2 .selector")
    private WebElement cableType;

    @FindBy(css = "li#id0 .selector")
    private WebElement mennekesPower;

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

    @FindBy(css = ".extra-club-discount .radio-circle")
    private WebElement extraCheckbox;

    @FindBy(css = ".extra-club-discount a")
    private WebElement extraTCLink;

    @FindBy(css = "a[href=\"/hjemmelading\"]")
    private WebElement backButton;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement nextButton;


}

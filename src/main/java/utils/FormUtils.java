package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;
import org.openqa.selenium.WebElement;

public class FormUtils {

    private WaitUtils waitUtils;
    private WebDriver driver;
    public FormUtils(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//p[contains(text(), \"Melding sendt\")]")
    private WebElement sentMessage;

    public void fillField(WebElement element, String text){
        waitUtils.waitForVisiblityOf(element);
        element.sendKeys(text);
    }

    public void clickSend() {
        submitButton.click();
        waitUtils.waitForVisiblityOf(sentMessage);
    }

}

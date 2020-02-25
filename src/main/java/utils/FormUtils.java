package utils;

import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
import org.openqa.selenium.WebElement;

public class FormUtils {

    private WaitUtils waitUtils;
    private WebDriver driver;
    public FormUtils(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    public void fillField(WebElement element, String text){
        waitUtils.waitForVisiblityOf(element);
        element.sendKeys(text);
    }

}

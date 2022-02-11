package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public abstract class BaseOperations {
    protected final WaitUtils waitUtils;
    protected final WebDriver driver;

    public BaseOperations(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    protected void fillField(WebElement element, String text){
        waitUtils.waitForVisibilityOf(element);
        element.sendKeys(text);
    }

}

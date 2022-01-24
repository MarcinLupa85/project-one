package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public abstract class BaseOperations {
    private final WaitUtils waitUtils;
    private final WebDriver driver;

    public BaseOperations(WebDriver driver) {
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    protected void fillField(WebElement element, String text){
        waitUtils.waitForVisibilityOf(element);
        element.sendKeys(text);
    }

}

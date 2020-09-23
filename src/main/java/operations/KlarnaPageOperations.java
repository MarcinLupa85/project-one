package operations;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.KlarnaPageObject;
import utils.WaitUtils;
import java.util.concurrent.TimeoutException;

public class KlarnaPageOperations {
    KlarnaPageObject klarnaPageObject;
    WaitUtils waitUtils;
    private WebDriver webDriver;

    public KlarnaPageOperations(WebDriver driver) {
        klarnaPageObject = new KlarnaPageObject(driver);
        waitUtils = new WaitUtils(driver);
        webDriver = driver;
    }

    public void clickBuyButton(){
        waitUtils.waitForElement(klarnaPageObject.getBuyButton());
        waitUtils.waitForElementToBeClickable(klarnaPageObject.getBuyButton());
        klarnaPageObject.getBuyButton().click();
    }

    public void fillForm() {
        WebElement klarnaIframe = klarnaPageObject.getKlarnaIFrame();
        waitUtils.waitForVisiblityOf(klarnaIframe);
        webDriver.switchTo().frame(klarnaIframe);
        waitUtils.waitForVisiblityOf(klarnaPageObject.getPostalCode());
        klarnaPageObject.getPostalCode().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        klarnaPageObject.getPostalCode().sendKeys("3004");
        klarnaPageObject.getNationalID().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        klarnaPageObject.getNationalID().sendKeys("250850-14407");
        klarnaPageObject.getNationalID().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        klarnaPageObject.getAddress().sendKeys("Dronninggata 28");
        klarnaPageObject.getCity().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        klarnaPageObject.getCity().sendKeys("Drammen");
        klarnaPageObject.getPhone().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        klarnaPageObject.getPhone().sendKeys("+4745558584");
        klarnaPageObject.getFinishButton().click();
        // cannot think of a wait here since literally the same button is clicked after reloading but found nothing to catch the reload with
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        klarnaPageObject.getFinishButton().click();
        webDriver.switchTo().defaultContent();
    }
}

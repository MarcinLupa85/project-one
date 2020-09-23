package operations;

import org.openqa.selenium.*;
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
        klarnaPageObject.getAddress().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        klarnaPageObject.getAddress().sendKeys("Dronninggata 28");
        klarnaPageObject.getCity().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        klarnaPageObject.getCity().sendKeys("Drammen");
        klarnaPageObject.getPhone().sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        klarnaPageObject.getPhone().sendKeys("+4745558584");
        klarnaPageObject.getFinishButton().click();
        By bekrefteBy = By.xpath(".//div[@id='identification-dialog__footer-button-wrapper']//span[text()='Bekrefte']/parent::div");
        waitUtils.waitForElementToBeClickable(bekrefteBy);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;
        jsExecutor.executeScript("arguments[0].click()", webDriver.findElement(bekrefteBy));
        webDriver.switchTo().defaultContent();
    }
}

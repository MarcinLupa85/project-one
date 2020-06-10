package operations;

import java.lang.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageobjects.MailinatorPageObject;
import utils.FormUtils;
import utils.WaitUtils;
import static org.assertj.core.api.Assertions.assertThat;

public class MailinatorPageOperations {
    private MailinatorPageObject mailinatorPageObject;
    private WebDriver webDriver;
    private FormUtils formUtils;
    private WaitUtils waitUtils;

    public MailinatorPageOperations(WebDriver driver) {
        mailinatorPageObject = new MailinatorPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils = new FormUtils(driver);
        webDriver = driver;

    }

    public void checkMailinator(String email) {
        String mailinatorPageURL = "https://www.mailinator.com/";
        webDriver.navigate().to(mailinatorPageURL);
        waitUtils.waitForElement(mailinatorPageObject.getEnterMailName());
        formUtils.fillField(mailinatorPageObject.getEnterMailName(), email);
        mailinatorPageObject.getEnterMailName().sendKeys(Keys.ENTER);
        waitUtils.waitForElement(mailinatorPageObject.getMailCheckbox());
        mailinatorPageObject.getMailCheckbox().click();
        mailinatorPageObject.getDeleteButton().click();
    }

    public void checkMailContent(String email) throws TimeoutException {
        String mailinatorPageURL = "https://www.mailinator.com/";
        webDriver.navigate().to(mailinatorPageURL);
        waitUtils.waitForElement(mailinatorPageObject.getEnterMailName());
        formUtils.fillField(mailinatorPageObject.getEnterMailName(), email);
        mailinatorPageObject.getEnterMailName().sendKeys(Keys.ENTER);
        mailinatorPageObject.getFirstMail().click();
        waitUtils.waitForElement(mailinatorPageObject.getMailBody());
        waitUtils.waitForDocumentReadyState();
        final WebDriver mailText = webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("iframe[name='msg_body']")));
        assertThat(mailText.getPageSource()).contains("snart som mulig");
    }

}

package operations;

import java.lang.*;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.MailinatorPageObject;
import utils.FormUtils;
import utils.WaitUtils;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.Dimension;

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

    private void checkMail(String email) throws TimeoutException {
        String mailinatorPageURL = "https://www.mailinator.com/";
        webDriver.navigate().to(mailinatorPageURL);
        waitUtils.waitForElement(mailinatorPageObject.getEnterMailName());
        formUtils.fillField(mailinatorPageObject.getEnterMailName(), email);
        mailinatorPageObject.getEnterMailName().sendKeys(Keys.ENTER);
        waitUtils.waitForDocumentReadyState();
        mailinatorPageObject.getFirstMail().click();
        WebElement mailBody = mailinatorPageObject.getMailBody();
        Dimension d = new Dimension(1366,657);
        webDriver.manage().window().setSize(d);
        if (!mailBody.isDisplayed()){
            mailinatorPageObject.getFirstMail().click();
        }
        waitUtils.waitForElement(mailBody);
        waitUtils.waitForDocumentReadyState();
        WebElement mailFrame = webDriver.findElement(By.cssSelector("iframe[name='msg_body']"));
        webDriver.switchTo().frame(mailFrame);
    }

    public void checkMailForPhrase(String email) throws TimeoutException {
        checkMail(email);
        assertThat(webDriver.getPageSource()).contains("at installasjonen skal");
    }

    public void checkMailForLackOfPhrase(String email) throws TimeoutException {
        checkMail(email);
        assertThat(webDriver.getPageSource()).doesNotContain("snart som mulig");
    }

}

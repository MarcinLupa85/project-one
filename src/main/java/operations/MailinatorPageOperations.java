package operations;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.MailinatorPageObject;
import utils.FormUtils;
import utils.WaitUtils;
import org.openqa.selenium.Dimension;

public class MailinatorPageOperations {
    private MailinatorPageObject mailinatorPageObject;
    private WebDriver webDriver;
    private FormUtils formUtils;
    private WaitUtils waitUtils;
    private SoftAssertions softAssertions;

    public MailinatorPageOperations(WebDriver driver) {
        mailinatorPageObject = new MailinatorPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils = new FormUtils(driver);
        webDriver = driver;
        softAssertions = new SoftAssertions();
    }

    private void checkMail(String email) throws TimeoutException {
        String mailinatorPageURL = "https://www.mailinator.com/";
        webDriver.navigate().to(mailinatorPageURL);
        waitUtils.waitForElementToBeClickable(mailinatorPageObject.getEnterMailName());
        formUtils.fillField(mailinatorPageObject.getEnterMailName(), email);
        mailinatorPageObject.getEnterMailName().sendKeys(Keys.ENTER);
        waitUtils.waitForDocumentReadyState();
//        List<WebElement> mailList = new ArrayList<>();
//        int count = 0;
//        while (count < 3 && mailList.isEmpty()) {
//            webDriver.navigate().refresh();
//            mailList.add(mailinatorPageObject.getFirstMail());
//            count++;
//        }
        softAssertions.assertThat(mailinatorPageObject.getFirstMail()).withFailMessage(email + "has failed email presence validation");
        waitUtils.waitForElementToBeClickable(mailinatorPageObject.getFirstMail());
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
        softAssertions.assertThat(webDriver.getPageSource()).withFailMessage(email + "has failed validation").contains("at installasjonen skal");
        softAssertions.assertThat(webDriver.getPageSource()).withFailMessage(email + "has failed comment validation").contains("Test comment");
    }

    public void checkMailForLackOfPhrase(String email) throws TimeoutException {
        checkMail(email);
        softAssertions.assertThat(webDriver.getPageSource()).withFailMessage(email + "has failed content validation").doesNotContain("snart som mulig");
        softAssertions.assertThat(webDriver.getPageSource()).withFailMessage(email + "has failed comment validation").contains("Test comment");
    }

    public SoftAssertions getSoftAssertions() {
        return softAssertions;
    }
}

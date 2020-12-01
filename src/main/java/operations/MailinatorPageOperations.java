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
        List<WebElement> mailList = new ArrayList<>();
        int count = 0;
        while (count < 3 && mailList.isEmpty()) {
            webDriver.navigate().refresh();
            mailList.add(mailinatorPageObject.getFirstMail());
            count++;
        }
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
        softAssertions.assertThat(webDriver.getPageSource()).contains("at installasjonen skal").withFailMessage(email + "has failed validation");
        softAssertions.assertThat(webDriver.getPageSource()).contains("Test comment").withFailMessage(email + "has failed comment validation");
    }

    public void checkMailForLackOfPhrase(String email) throws TimeoutException {
        checkMail(email);
        softAssertions.assertThat(webDriver.getPageSource()).doesNotContain("snart som mulig").withFailMessage(email + "has failed content validation");
        softAssertions.assertThat(webDriver.getPageSource()).contains("Test comment").withFailMessage(email + "has failed comment validation");
    }

    public SoftAssertions getSoftAssertions() {
        return softAssertions;
    }
}

package operations;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.GmailPageObject;
import pageobjects.HomePageObject;
import utils.FormUtils;
import utils.WaitUtils;

public class GmailPageOperations {

    private GmailPageObject gmailPageObject;
    private WaitUtils waitUtils;
    private FormUtils formUtils;
    private WebDriver driver;

    public GmailPageOperations(WebDriver driver) {
        gmailPageObject = new GmailPageObject(driver);
        waitUtils = new WaitUtils(driver);
        formUtils = new FormUtils(driver);
        this.driver = driver;
    }

    public void openLatestMail() {
        driver.navigate().to("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F");
        formUtils.fillField(gmailPageObject.getEmailInput(), "evtestautomation@gmail.com");
        gmailPageObject.getNextButton().click();
        formUtils.fillField(gmailPageObject.getPasswordInput(), "Emobility1");
        gmailPageObject.getNextButton().click();
        waitUtils.waitForElement(gmailPageObject.getFirstEmailRow()).click();
    }

    public String getContactFormData(){
       return waitUtils.waitForElement(gmailPageObject.getContactFormData()).getText();
    }

    public void deleteMail() {
        waitUtils.waitForElement(gmailPageObject.getDeleteButton()).click();

    }
}

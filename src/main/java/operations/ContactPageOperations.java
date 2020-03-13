package operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.ContactPageObject;
import utils.WaitUtils;

public class ContactPageOperations {

    private ContactPageObject contactPageObject;
    private WaitUtils waitUtils;

    public ContactPageOperations(WebDriver driver) {
        contactPageObject = new ContactPageObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void fillFullName(String name) {
        WebElement fullName = contactPageObject.getFullNameInput();
        waitUtils.waitForVisiblityOf(fullName);
        fullName.sendKeys(name);
    }

    public void fillEmail(String email) {
        WebElement emailInput = contactPageObject.getEmailInput();
        waitUtils.waitForVisiblityOf(emailInput);
        emailInput.sendKeys(email);
    }

    public void fillPhoneNumber(String number) {
        WebElement phoneNumber = contactPageObject.getTelephoneNumberInput();
        waitUtils.waitForVisiblityOf(phoneNumber);
        phoneNumber.sendKeys(number);
    }

    public void fillCompanyName(String company) {
        WebElement companyName = contactPageObject.getCompanyNameInput();
        waitUtils.waitForVisiblityOf(companyName);
        companyName.sendKeys(company);
    }

    public void fillComment(String comment) {
        WebElement commentInput = contactPageObject.getCommentInput();
        waitUtils.waitForVisiblityOf(commentInput);
        commentInput.sendKeys(comment);
    }

    public void clickSend() {
        contactPageObject.getSubmitButton().click();
        waitUtils.waitForVisiblityOf(contactPageObject.getSentMessage());
    }

    public void clickBack() {
        contactPageObject.getBackButton().click();
        waitUtils.waitForUrlToContains("/home");

    }


}

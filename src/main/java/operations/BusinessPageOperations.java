package operations;

import org.openqa.selenium.WebDriver;
import pageobjects.BusinessPageObject;
import utils.FormUtils;
import utils.WaitUtils;

public class BusinessPageOperations {

        private BusinessPageObject businessPageObject;
        private WaitUtils waitUtils;
        private FormUtils formUtils;

        public BusinessPageOperations(WebDriver driver) {
            businessPageObject = new BusinessPageObject(driver);
            waitUtils = new WaitUtils(driver);
            formUtils = new FormUtils(driver);
        }

    public void fillForm(String name, String email, String number, String company, String comment) {
        waitUtils.bringElementToViewport(businessPageObject.getFullNameInput());
        formUtils.fillField(businessPageObject.getFullNameInput(), name);
        formUtils.fillField(businessPageObject.getEmailInput(), email);
        formUtils.fillField(businessPageObject.getTelephoneNumberInput(), number);
        formUtils.fillField(businessPageObject.getCompanyNameInput(), company);
        formUtils.fillField(businessPageObject.getCommentInput(), comment);
    }

    public void clickSend() {
        businessPageObject.submitButton().click();
    }
}
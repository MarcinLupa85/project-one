package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.CkidPageObject;
import utils.WaitUtils;

public class CkidPageOperations {

    private CkidPageObject ckidPageObject;
    private WaitUtils waitUtils;
    private WebDriver driver;

    public CkidPageOperations (WebDriver driver) {
        ckidPageObject = new CkidPageObject(driver);
        waitUtils = new WaitUtils(driver);
        this.driver = driver;
    }

    public void logInWithCredentials(String username, String password) {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click()", ckidPageObject.getLoginLink());
        waitUtils.waitForPresentOf(By.cssSelector("input[type=email]"));
        ckidPageObject.getEmailInput().sendKeys(username);
        ckidPageObject.getPasswordInput().sendKeys(password);
        ckidPageObject.getLoginButton().click();
    }

    public void registerNewUser(String phoneNumber, String username, String password) {

        waitUtils.waitForPresentOf(By.cssSelector("input#edit-phone-number"));
        ckidPageObject.getCountryCodeInput().sendKeys("48");
        ckidPageObject.getPhoneNumberInput().sendKeys(phoneNumber);
        ckidPageObject.getSendCodeButton().click();
        waitUtils.waitForPresentOf(By.cssSelector("input#validation-code-input"));
        // universal SMS code for test CKID environments
        ckidPageObject.getSmsCodeInput().sendKeys("000000");
        ckidPageObject.getVerifyCodeButton().click();
        waitUtils.waitForPresentOf(By.cssSelector("input[type=email"));
        ckidPageObject.getEmailInput().sendKeys(username);
        ckidPageObject.getPasswordInput().sendKeys(password);
        ckidPageObject.getFirstNameInput().sendKeys("Michal");
        ckidPageObject.getLastNameInput().sendKeys("Sepczuk");
        ckidPageObject.getCountrySelect().selectByValue("string:NORWAY");
        waitUtils.waitForPresentOf(By.cssSelector("input[type=checkbox]"));
        ckidPageObject.getCkidTcCheckbox().click();
        //ckidPageObject.getEvTcCheckbox().click();

        //Accepted in review
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click()", ckidPageObject.getRegisterButton());
    }

}

package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.CkidPageObject;
import utils.WaitUtils;

public class CkidPageOperations {

    private CkidPageObject ckidPageObject;
    private WaitUtils waitUtils;

    public CkidPageOperations (WebDriver driver) {
        ckidPageObject = new CkidPageObject(driver);
        waitUtils = new WaitUtils(driver);
    }

    public void logInWithCredentials(String username, String password) {
        ckidPageObject.getEmailInput().sendKeys(username);
        ckidPageObject.getPasswordInput().sendKeys(password);
        ckidPageObject.getLoginButton().click();
    }

}

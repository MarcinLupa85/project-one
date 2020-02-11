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

//        WebElement loginLink = ckidPageObject.getLoginLink();
//        waitUtils.waitForVisiblityOf(loginLink);
//        waitUtils.waitForClickabiltyOf(loginLink);
//        loginLink.click();



        waitUtils.waitForPresentOf(By.cssSelector("input[type=email]"));

        ckidPageObject.getEmailInput().sendKeys(username);
        ckidPageObject.getPasswordInput().sendKeys(password);
        ckidPageObject.getLoginButton().click();
//
//
//        driver.findElement(By.cssSelector("input[type=email]")).sendKeys(username);
//        driver.findElement(By.cssSelector("input[type=password]")).sendKeys(password);
//        driver.findElement(By.cssSelector("button#login-submit-button")).click();
    }

}

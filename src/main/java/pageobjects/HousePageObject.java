package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HousePageObject {

    private TopMenuObject topMenuObject;

    public HousePageObject(WebDriver driver) {
        topMenuObject =  new TopMenuObject(driver);
        PageFactory.initElements(driver, this);
    }

}

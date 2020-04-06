package pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HousePageObject {

    private NavbarObject navbarObject;

    public HousePageObject(WebDriver driver) {
        navbarObject =  new NavbarObject(driver);
        PageFactory.initElements(driver, this);
    }

}

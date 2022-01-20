package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class EvPage {
    protected final WebDriver driver;

    public EvPage(WebDriver driver) {
        this.driver = driver;
        initWebElements();
    }

    private void initWebElements() {
        PageFactory.initElements(driver, this);
    }
}

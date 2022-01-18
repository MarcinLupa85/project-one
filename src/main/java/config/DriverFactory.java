package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static config.Constants.DRIVER_TYPE;
import static config.DriverTypes.*;

public class DriverFactory {

    public WebDriver webDriver;

    public WebDriver startBrowser() {
        switch (DRIVER_TYPE) {
            case CHROME:
                webDriver = new ChromeDriver(CapabilitiesProvider.getChromeCapabilities());
                webDriver.manage().window().maximize();
                break;
            case REMOTE_DEBUG:
                try {
                    webDriver = new RemoteWebDriver(
                            new URL(Constants.DEBUG_HUB_URL),
                            CapabilitiesProvider.getChromeCapabilities()
                    );
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                webDriver.manage().window().maximize();
                break;
            case REMOTE_CHROME:
                try {
                    webDriver = new RemoteWebDriver(
                            new URL(Constants.TEST_HUB_URL),
                            CapabilitiesProvider.getChromeCapabilities()
                    );
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
        }
        webDriver.manage().deleteAllCookies();
        return webDriver;
    }
}

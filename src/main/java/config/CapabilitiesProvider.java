package config;

import enums.OsFamily;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

import static config.Constants.*;

public class CapabilitiesProvider {

    private static OsFamily osFamilyDetect() {
        if (SystemUtils.IS_OS_LINUX) {
            return OsFamily.LINUX;
        }
        if (SystemUtils.IS_OS_MAC) {
            return OsFamily.MAC;
        }
        if (SystemUtils.IS_OS_WINDOWS) {
            return OsFamily.WINDOWS;
        }
        return OsFamily.OTHER;
    }

    public static ChromeOptions getChromeCapabilities() {
        String driverBinName;

        switch (osFamilyDetect()) {
            case WINDOWS:
                driverBinName = WIN_DRIVER_BINARY_NAME;
                break;
            case LINUX:
                driverBinName = LINUX_DRIVER_BINARY_NAME;
                break;
            case MAC:
                driverBinName = MAC_DRIVER_BINARY_NAME;
                break;
            default:
                driverBinName = "";
                break;
        }

        System.setProperty(
                "webdriver.chrome.driver",
                "src/test/resources/driver-binaries/" + driverBinName
        );

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        chromeOptions.addArguments("--lang=en");
        return chromeOptions;
    }

}

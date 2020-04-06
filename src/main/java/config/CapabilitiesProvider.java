package config;


import enums.OsFamily;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

import static config.Constants.*;
import static org.openqa.selenium.firefox.FirefoxDriver.PROFILE;

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
                "src/test/resources/driver-binaries/"+driverBinName
        );

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        chromeOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        return chromeOptions;
    }

    public static FirefoxOptions getFirefoxCapabilities() {
        System.setProperty(
                "webdriver.gecko.driver",
                System.getProperty("user.dir") + "/src/test/resources/geckodriver_macos"
        );

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        firefoxOptions.setCapability(PROFILE, configuredFirefoxProfile());
        firefoxOptions.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
        return firefoxOptions;
    }

    private static FirefoxProfile configuredFirefoxProfile() {
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.cache.disk.enable", false);
        firefoxProfile.setPreference("browser.cache.memory.enable", false);
        firefoxProfile.setPreference("browser.cache.offline.enable", false);
        firefoxProfile.setPreference("network.http.use-cache", false);
        firefoxProfile.setPreference("browser.tabs.remote.autostart", false);
        firefoxProfile.setPreference("browser.tabs.remote.autostart.2", false);
        firefoxProfile.setPreference("dom.max_chrome_script_run_time", 0);
        firefoxProfile.setPreference("dom.max_script_run_time", 0);
//        firefoxProfile.setPreference("browser.download.dir", DOWNLOAD_REPORT_DIR);
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", ".images/jpeg, application/pdf, application/octet-stream, application/zip, text/csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        firefoxProfile.setPreference("pdfjs.disabled", true);
        //disable Acrobat plugin for previewing PDFs in Firefox (if you have Adobe reader installed on your computer)
        firefoxProfile.setPreference("plugin.scan.Acrobat", "99.0");
        firefoxProfile.setPreference("plugin.scan.plid.all", false);
        return firefoxProfile;
    }


}

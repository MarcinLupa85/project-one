package config;

import java.util.Optional;

import static java.io.File.separator;
import static java.lang.System.getProperty;

public class Constants {

    public static final String TEST_HUB_URL = "http://test_hub:4444/wd/hub";
    public static final String DEBUG_HUB_URL = "http://localhost:4444/wd/hub";
    public static final String BASE_URL = "https://circlekno-unstable.test.cksites.net/elbillading";
    public static final String DRIVER_TYPE = Optional.ofNullable(System.getenv("driver_type")).orElse("remote_chrome");
    public static final String LINUX_DRIVER_BINARY_NAME = "chromedriver_linux";
    public static final String MAC_DRIVER_BINARY_NAME = "chromedriver_mac";
    public static final String WIN_DRIVER_BINARY_NAME = "chromedriver.exe";
    public static final String REPORT_DIR = getProperty("user.dir") + separator + "report" + separator;
    public static final String RESULT_FILE = REPORT_DIR + "result_file";
    public static final String SCREENSHOT_DIR = REPORT_DIR + "screenshots" + separator;
}
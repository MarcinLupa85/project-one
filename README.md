# ev-test-automation

## Project requirements
- java11 at least
- gradle
- chrome browser and chromedriver to run tests locally

As a ev-test-automation is using [testrail client](https://github.com/circlekeurope/testrail-client-java) integration as a submodule then to clone the repository you need to run specific commands
```
git clone git@github.com:circlekeurope/ev-test-automation.git
git submodule init
git submodule update
```

Tests use chromedriver and chrome as a default browser. Each test can be run on local and remote environment. 
Please specify environment variable **driver_type** and set it to **chrome** to use local browser.

Please note that project is using
```
System.setProperty(
                "webdriver.chrome.driver",
                "src/test/resources/driver-binaries/" + driverBinName
        );
```

Please adjust chromedriver to your local version of chrome browser.

Remote execution of the test is defined in [Docker compose file](docker-compose.yml) and test run command for gradle
in [run tests](run_tests.sh)

Jenkins job connected with this test project is defined in
[Emobility pipeline configuration file](https://github.com/circlekeurope/jenkins-config/blob/master/buildconfigs/emobility/emobility-pipelines.yaml)

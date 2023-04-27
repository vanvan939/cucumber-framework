package StepDefinitions;

import Managers.FileReaderManager;
import Utilities.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;


public class Hooks {

    TestContext testContext;
    WebDriver webDriver;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setUp() {
        webDriver = testContext.getDriverManager().getDriver();
//        webDriver.get(FileReaderManager.getInstance().getConfigFileReader().getUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
        testContext.getDriverManager().closeDriver();
    }
}

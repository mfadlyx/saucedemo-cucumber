package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utlis.Contants;
import com.juaracoding.utlis.ScenarioTests;
import com.juaracoding.utlis.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {

    static WebDriver driver;

    static ExtentTest extentTest;

    static ExtentReports reports = new ExtentReports("target/extent-report.html");

    @Before
    public static void setUp() {
        DriverSingleton.getInstance(Contants.FIREFOX);
        driver = DriverSingleton.getDriver();
        ScenarioTests[] tests = ScenarioTests.values();
        extentTest = reports.startTest(tests[Utils.testCount].getScenarioTestName());
        Utils.testCount++;
    }

    @AfterStep
    public void getResultTest(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            String screenshotPath = Utils.getScreenshot(driver, scenario.getName()
                    .replace(" ", " "));
            extentTest.log(LogStatus.FAIL,scenario.getName()+"\n"
                    +extentTest.addScreenCapture(screenshotPath));
        }
    }

    @After
    public void endScenarioTest(){
        reports.endTest(extentTest);
        reports.flush();
    }

    @AfterAll
    public static void finish() {
        Utils.delay(5);
        DriverSingleton.closeObjectInstance();
    }
}

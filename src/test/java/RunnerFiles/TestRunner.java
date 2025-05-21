package RunnerFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;


@Test
@CucumberOptions(
        features = "C://Users/KSPL/IdeaProjects/Dotslip/src/test/resources/FeatureFiles/FeatureFiles/Dotslip",
        glue = {"Stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@Dotslip")

public class TestRunner extends AbstractTestNGCucumberTests {
    static {
        System.out.println("TestRunner is running");
    }
}


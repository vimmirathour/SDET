package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@Activity1_2",
    plugin = {"html: reports/html_report.html"},
    monochrome = true
)

public class ActivitiesRunner {
    //empty
}
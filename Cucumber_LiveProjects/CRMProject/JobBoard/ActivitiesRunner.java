package Test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@jobactivity1_4",
    strict = true,
    plugin = {"html: src/target/html_report.html"}
   
)

public class ActivitiesRunner {}
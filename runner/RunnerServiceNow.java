package assignment.week6.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	features = "src/main/java/featuresServiceNow",
glue ="assignment.servicenowBDD",
monochrome = true
)

public class RunnerServiceNow extends AbstractTestNGCucumberTests{

}

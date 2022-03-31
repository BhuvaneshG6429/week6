package assignment.week6.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	features = "src/main/java/features/MergeLead.feature",
					glue ="assignment.week6day1",
					monochrome = true
					)
public class RunTest extends AbstractTestNGCucumberTests{
			
}

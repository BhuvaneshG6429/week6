package assignment.week6.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions(	features = "src/main/java/featuresLeafTaps",
	glue ="assignment.week6day2",
	monochrome = true,
	publish = true,
	tags = "@smoke"
	)
public class RunTestDay2 extends AbstractTestNGCucumberTests{
	
}

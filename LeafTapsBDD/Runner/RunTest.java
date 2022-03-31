package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	features = "src/main/java/features",
					glue ="steps",
					monochrome = true,
					publish = true,
					tags = "@smoke and @regression")
public class RunTest extends AbstractTestNGCucumberTests{
			

}

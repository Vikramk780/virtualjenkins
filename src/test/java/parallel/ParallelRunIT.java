package parallel;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failedrerun.txt"
				}, 
		monochrome = true,
		glue = { "parallel" },
		features = { "C:\\Users\\kvikram\\newEclipse\\CucumberProjectWithPom\\src\\test\\resources\\parallel\\EventhubPage.feature","C:\\Users\\kvikram\\newEclipse\\CucumberProjectWithPom\\src\\test\\resources\\parallel\\IntegrationMesh.feature" }
)

public class ParallelRunIT extends AbstractTestNGCucumberTests {
	
	
	
	
	
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
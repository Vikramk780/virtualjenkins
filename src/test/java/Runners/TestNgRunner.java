package Runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	
		features = {"./src/test/resources/parallel"},
		glue = {"parallel"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","html:target/cucumberreports/htmlreport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"}
		)

public class TestNgRunner extends AbstractTestNGCucumberTests{

	//below code can be used for paraller execution//
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();}
	
	
}

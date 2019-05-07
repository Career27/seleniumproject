package com.dlg.web.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" }, strict = false, dryRun=false , features = { "src/test/resources/features" },
glue = { "com.dlg.steps"}, tags={"@vehicle_check"})
public class CucumberRunnerDLG {
	

}













package com.w2a.cucumber.parallel.google.runners;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features="src/test/resources/com/w2a/cucumber/parallel/google/features/search-outline.feature",
		glue="com.w2a.cucumber.parallel.google"
		
		
		)
public class SearchOutlineFeature {

	@Test
	public void runCuke(){
		new TestNGCucumberRunner(getClass()).runCukes();
	}

}

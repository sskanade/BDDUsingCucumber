package com.w2a.cucumber.parallel.google;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import com.w2a.cucumber.parallel.extent.ExtentManager;
import com.w2a.cucumber.parallel.extent.ExtentTestManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleSteps extends BaseSteps {

	protected Scenario scenario;
	static String scenarioName;
	static int x=0;	
	
	@Before
	public void before(Scenario scenario){
		x=x+1;
		this.scenario = scenario;
		scenarioName = scenario.getName();
		ExtentTestManager.startTest("Scenario Number : "+x+" -> "+scenario.getName());
		ExtentTestManager.getTest().log(Status.INFO, "Scenario Started : "+scenario.getName());
	}
	
	@After
	public void after(Scenario scenario){
		if(scenario.isFailed()){
			ExtentTestManager.logFail("Scanario Failed");
			ExtentTestManager.addScreenShotsOnFailure();
		} else {
			ExtentTestManager.logPass("Scanario Passed");
		}
		
		ExtentManager.getReporter().flush();
		stopWebDriver();
	}
	@Given("^launch browser '(.*?)'$")
	public void launch_browser_firefox(String browserName) throws Throwable {
		ExtentTestManager.logInfo("Launching browser: "+browserName);
		startWebDriver(browserName);
	}

	@When("^user navigates to '(.*?)'$")
	public void user_navigates_to_http_google_com(String url) throws Throwable {
		navigate(url);
	}

	@Then("^user enter search term '(.*?)'$")
	public void user_enter_search_term_Way_Automation_Selenium(String searchText) throws Throwable {
		ExtentTestManager.logInfo("Entering the value in searchbox: "+searchText);
		getDriver().findElement(By.name("q")).sendKeys(searchText);
	}

	@And("^click on search button$")
	public void click_on_search_button() throws Throwable {
	//	Thread.sleep(2000);
		ExtentTestManager.logInfo("clicking search button: ");
		getDriver().findElement(By.name("btnK")).click();
	}


}

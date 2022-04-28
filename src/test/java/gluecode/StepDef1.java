package gluecode;

import org.openqa.selenium.OutputType;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.FlightsPage;
import pages.HomePage;
import utilities.SiteUtility;

public class StepDef1 
{
	public Shared sh;
	//dependency injection by constructor
	public StepDef1(Shared x)
	{
		sh=x;
	}
	
	@Given("open {string} browser")
	public void method1(String bn) 
	{
	    sh.u=new SiteUtility();
	    sh.driver=sh.u.openBrowser(bn);
	    sh.w=sh.u.defineWait(sh.driver, 20, 500);
	    sh.obj1=new HomePage(sh.driver);
	    sh.obj2=new FlightsPage(sh.driver);
	}
	
	@Given("launch {string} site")
	public void method2(String url) throws Exception 
	{
		sh.u.launchSite(sh.driver, "QA");
	}

	@When("search flights from {string} to {string}")
	public void method3(String from, String to) throws Exception 
	{
		if(sh.obj1.isFromFieldDisplayed())
		{
			sh.s.log("From field is displayed");
			sh.obj1.fillFrom(from, sh.w);
			byte[] a=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(a, "image/png", "Test Passed");
		}
		if(sh.obj1.isToFieldDisplayed())
		{
			sh.s.log("To field is displayed");
			sh.obj1.fillTo(to,sh.w);
			byte[] a=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(a, "image/png", "Test Passed");
		}
		else
		{
			sh.s.log("From & To fields are not displayed");
			System.exit(0);
			byte[] a=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(a, "image/png", "Test Failed");
			Assert.fail();
		}
		
	}

	@When("select {int} , {string} , {int}")
	public void method5(Integer year , String month, Integer day) throws Exception 
	{
	    
		sh.obj1.selectDate(sh.driver, year, month, day);
	    
	}
	
	@When("select {int} , {string} and {int}")
	public void method6(Integer year , String month, Integer day) throws Exception 
	{
		sh.obj1.clickOnReturnCalendar(sh.w);
		sh.obj1.selectDate(sh.driver, year, month, day);
	}
	
	@When("click on search flights")
	public void method7() throws Exception
	{
		sh.obj1.clickSearchFlight();
	}
	
	@Then("flights table should be displayed")
	public void method8()
	{
		if(sh.obj2.isDepartureFlightsTableDisplayed())
		{
			if(sh.obj2.isReturnFlightsTableDisplayed())
			{
				sh.s.log("Flights were displayed");
				byte[] a=sh.driver.getScreenshotAs(OutputType.BYTES);
				sh.s.attach(a, "image/png", "Test Passed");
			}
		}
		else
		{
			sh.s.log("Flights were not displayed");
			System.exit(0);
			byte[] a=sh.driver.getScreenshotAs(OutputType.BYTES);
			sh.s.attach(a, "image/png", "Test failed");
		}
	}
	
	 @When("close site")
	 public void method9()
	 {
		 sh.u.closeSite(sh.driver);
	 }
	
}

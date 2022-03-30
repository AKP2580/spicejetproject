package gluecode;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FlightsPage;
import pages.HomePage;

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
	    if(bn.equalsIgnoreCase("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
		    sh.driver=new ChromeDriver();
		    sh.driver.manage().window().maximize();
	    }
	    else
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	sh.driver=new FirefoxDriver();
	    	sh.driver.manage().window().maximize();		
	    }
		
	    sh.obj1=new HomePage(sh.driver);
	    sh.obj2=new FlightsPage(sh.driver);
	}
	
	@Given("launch {string} site")
	public void method2(String url) throws Exception 
	{
		sh.driver.get(url);
		Thread.sleep(10000);
	}

	@When("search flights from {string} to {string}")
	public void method3(String from, String to) throws Exception 
	{
		if(sh.obj1.isFromFieldDisplayed())
		{
			sh.s.log("From field is displayed");
			sh.obj1.fillFrom(from);
		}
		if(sh.obj1.isToFieldDisplayed())
		{
			sh.s.log("To field is displayed");
			sh.obj1.fillTo(to);
			Thread.sleep(5000);
		}
		else
		{
			sh.s.log("From & To fields are not displayed");
			System.exit(0);
		}
	}

	@When("select {int} , {string} , {int}")
	public void method5(Integer year , String month, Integer day) throws Exception 
	{
	    
		sh.obj1.selectDate(sh.driver, year, month, day);
	    Thread.sleep(5000);
	    
	}
	
	@When("select {int} , {string} and {int}")
	public void method6(Integer year , String month, Integer day) throws Exception 
	{
		sh.obj1.clickOnReturnCalendar();
		sh.obj1.selectDate(sh.driver, year, month, day);
	}
	
	@When("click on search flights")
	public void method7() throws Exception
	{
		sh.obj1.clickSearchFlight();
		Thread.sleep(10000);
	}
	
	@Then("flights table should be displayed")
	public void method8()
	{
		if(sh.obj2.isDepartureFlightsTableDisplayed())
		{
			if(sh.obj2.isReturnFlightsTableDisplayed())
			{
				sh.s.log("Flights were displayed");
			}
		}
		else
		{
			sh.s.log("Flights were not displayed");
			System.exit(0);
		}
	}
	
	 @When("close site")
	 public void method9()
	 {
		 sh.driver.close();
	 }
	
}

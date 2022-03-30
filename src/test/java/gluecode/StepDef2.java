package gluecode;

import io.cucumber.java.en.Then;

public class StepDef2 
{
	public Shared sh;
	//dependency injection by constructor
	public StepDef2(Shared x)
	{
		sh=x;
	}
	
	@Then("select lowest fare flight for Departure")
	public void method9() throws Exception
	{
		sh.s.log("No of Departure flights" +sh.obj2.getNoOfDepartureFlights());
		sh.obj2.clickLowestFareFlightForDeparture(sh.driver);
		Thread.sleep(5000);
	}
	
	@Then("select lowest fare flight for Return")
	public void method10() throws Exception
	{
		sh.s.log("No of Return flights" +sh.obj2.getNoOfReturnFlights());
		sh.obj2.clickLowestFareFlightForReturn(sh.driver);
		Thread.sleep(5000);
	}
}

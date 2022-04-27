package gluecode;

import io.cucumber.java.en.Then;

public class StepDef3 
{
	public Shared sh;
	//dependency injection by constructor
	public StepDef3(Shared x)
	{
		sh=x;
	}
	
	@Then("select highest fare flight for Departure")
	public void method11() throws Exception
	{
		sh.s.log("No of Departure flights" +sh.obj2.getNoOfDepartureFlights());
		sh.obj2.clickHighestFareFlightForDeparture(sh.driver);
	}
	
	@Then("select highest fare flight for Return")
	public void method12() throws Exception
	{
		sh.s.log("No of Return flights" +sh.obj2.getNoOfReturnFlights());
		sh.obj2.clickHighestFareFlightForReturn(sh.driver);
	}
	
	@Then("click continue")
	public void method13() throws Exception
	{
		sh.obj2.clickContinue(sh.w);
	}
}

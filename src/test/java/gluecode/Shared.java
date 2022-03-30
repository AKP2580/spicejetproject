package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.FlightsPage;
import pages.HomePage;

public class Shared 
{
	public RemoteWebDriver driver;
	public HomePage obj1;
	public FlightsPage obj2;
	public Scenario s;
	
	@Before
	public void method(Scenario x)
	{
		s=x;
	}
}

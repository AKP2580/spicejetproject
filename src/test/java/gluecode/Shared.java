package gluecode;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.FlightsPage;
import pages.HomePage;
import utilities.SiteUtility;

public class Shared 
{
	public RemoteWebDriver driver;
	public HomePage obj1;
	public FlightsPage obj2;
	public Scenario s;
	public FluentWait<RemoteWebDriver> w;
	public SiteUtility u;
	
	@Before
	public void method(Scenario x)
	{
		s=x;
	}
}

package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import utilities.DivTableUtilityClass;

public class FlightsPage 
{
	
	@FindBy(xpath="(//div[text()='SpiceMAX']/following::div[2])[1]") private WebElement depatureFlightsTable;
	@FindBy(xpath="(//div[text()='SpiceMAX']/following::div[2])[2]") private WebElement returnFlightsTable;
	@FindBy(xpath="//div[@data-testid='continue-search-page-cta']") private WebElement clickcontinue;
	
	//constructor method
		public FlightsPage(RemoteWebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//operatational & observational methods
		public boolean isDepartureFlightsTableDisplayed()
		{
			if(depatureFlightsTable.isDisplayed())
			{
				return(true);
			}
			else
			{
				return(false);
			}
		}
		
		public boolean isReturnFlightsTableDisplayed()
		{
			if(returnFlightsTable.isDisplayed())
			{
				return(true);
			}
			else
			{
				return(false);
			}
		}
		
		public int getNoOfDepartureFlights()
		{
			DivTableUtilityClass obj=new DivTableUtilityClass();
			return(obj.getChildDIVCount(depatureFlightsTable));
		}
		
		public int getNoOfReturnFlights()
		{
			DivTableUtilityClass obj=new DivTableUtilityClass();
			return(obj.getChildDIVCount(returnFlightsTable));
		}
		
		public void clickHighestFareFlightForDeparture(RemoteWebDriver driver)
		{
			DivTableUtilityClass obj=new DivTableUtilityClass();
			List<WebElement> flights=obj.getChildDIVs(depatureFlightsTable);
			int hfare=0;
			for(WebElement flight:flights)
			{
				driver.executeScript("arguments[0].scrollIntoView();", flight);
				By b=By.xpath("child::div/div[2]/div[1]//span/parent::div");
				String value=obj.getDIVValue(driver, flight, b);
				String num=value.replaceAll("[^0-9]",""); //replace other than digits with blank
				if(hfare==0)
				{
					hfare=Integer.parseInt(num);
				}
				else if(hfare<Integer.parseInt(num))
				{
					hfare=Integer.parseInt(num);
					flight.findElement(By.xpath("child::div/div[2]/div[1]//*[name()='svg']/ancestor::div[2]")).click();
					
				}
				
			}
			System.out.println(hfare);
		}
		
		public void clickHighestFareFlightForReturn(RemoteWebDriver driver)
		{
			DivTableUtilityClass obj =new DivTableUtilityClass();
			List<WebElement> flights=obj.getChildDIVs(returnFlightsTable);
			int hfare=0;
			for(WebElement flight:flights)
			{
				driver.executeScript("arguments[0].scrollIntoView();", flight);
				By b=By.xpath("child::div/div[2]/div[1]//span/parent::div");
				String value=obj.getDIVValue(driver, flight, b);
				String num=value.replaceAll("[^0-9]",""); //replace other than digits with blank
				if(hfare==0)
					
				{
					hfare=Integer.parseInt(num);
				}
				else if(hfare<Integer.parseInt(num))
				{
					hfare=Integer.parseInt(num);
					flight.findElement(By.xpath("child::div/div[2]/div[1]//*[name()='svg']/ancestor::div[2]")).click();
					
				}
				
			}
			System.out.println(hfare);
		}
		
		public void clickLowestFareFlightForDeparture(RemoteWebDriver driver)
		{
			DivTableUtilityClass obj=new DivTableUtilityClass();
			List<WebElement> flights=obj.getChildDIVs(depatureFlightsTable);
			int Ifare=0;
			for(WebElement flight:flights)
			{
				By b=By.xpath("child::div/div[2]/div[1]//span/parent::div");
				String value=obj.getDIVValue(driver, flight, b);
				String num=value.replaceAll("[^0-9]",""); //replace other than digits with blank
				if(Ifare==0)
				{
					Ifare=Integer.parseInt(num);
				}
				else if(Ifare>Integer.parseInt(num))
				{
					Ifare=Integer.parseInt(num);
					flight.findElement(By.xpath("child::div/div[2]/div[1]//*[name()='svg']")).click();
					
				}
				
			}
			System.out.println(Ifare);
		}
		
		public void clickLowestFareFlightForReturn(RemoteWebDriver driver)
		{
			DivTableUtilityClass obj=new DivTableUtilityClass();
			List<WebElement> flights=obj.getChildDIVs(returnFlightsTable);
			int Ifare=0;
			for(WebElement flight:flights)
			{
				
				By b=By.xpath("child::div/div[2]/div[1]//span/parent::div");
				String value=obj.getDIVValue(driver, flight, b);
				String num=value.replaceAll("[^0-9]",""); //replace other than digits with blank
				if(Ifare==0)
				{
					Ifare=Integer.parseInt(num);
				}
				else if(Ifare>Integer.parseInt(num))
				{
					Ifare=Integer.parseInt(num);
					flight.findElement(By.xpath("child::div/div[2]/div[1]//*[name()='svg']")).click();
					
				}
				
			}
			System.out.println(Ifare);
		}
		
		public void clickContinue(FluentWait<RemoteWebDriver> w) throws Exception
		{
			w.until(ExpectedConditions.elementToBeClickable(clickcontinue)).click();
		}
		
}

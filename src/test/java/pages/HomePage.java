package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.DivCalendarUtilityClass;

public class HomePage 
{
	
	//locate element
	@FindBy(xpath="//div[text()='From']/following::input[1]") private WebElement from;
	@FindBy(xpath="//div[text()='To']/following::input[1]") private WebElement to;
	@FindBy(xpath="(//div[text()='Departure Date']/following::*[name()='svg'])[1]") private WebElement openDepartureCalender;
	@FindBy(xpath="//div[contains(@data-testid,'undefined-month')]/ancestor::div[2]") private WebElement calendar;
	@FindBy(xpath="(//div[text()='Return Date']/following::*[name()='svg'])[1]") private WebElement openReturnCalender;
	@FindBy(xpath="//div[@data-testid='home-page-flight-cta']") private WebElement searchFlights;
	//constructor method
	public HomePage(RemoteWebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//operatational & observational methods
	public boolean isFromFieldDisplayed()
	{
		if(from.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public boolean isToFieldDisplayed()
	{
		if(to.isDisplayed())
		{
			return(true);
		}
		else
		{
			return(false);
		}
	}
	public void fillFrom(String x) throws Exception
	{
		from.sendKeys(x);
		Thread.sleep(5000);
	}
	public void fillTo(String x) throws Exception
	{
		to.clear();
		to.sendKeys(x);
		Thread.sleep(5000);
	}
	
	public void clickOnReturnCalendar() throws Exception
	{
		openReturnCalender.click();
		Thread.sleep(2000);
	}
	
	public void selectDate(RemoteWebDriver driver, int year, String month, int day) throws Exception
	{
		DivCalendarUtilityClass obj=new DivCalendarUtilityClass();
		obj.selectDate(driver,calendar, year, month, day);
		Thread.sleep(3000);
	}
	
	public void clickSearchFlight() throws Exception
	{
		searchFlights.click();
		Thread.sleep(5000);
	}

	
}

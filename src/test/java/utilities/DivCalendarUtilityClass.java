package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DivCalendarUtilityClass
{
	public void selectDate(RemoteWebDriver driver, WebElement calendar, 
									int year, String month, int day) throws Exception
	{
		List<WebElement> monthsblocks=calendar.findElements(By.xpath("child::div/div"));
		//Matching the month & year
		int flag=0;
		for(WebElement monthblock:monthsblocks)
		{
			String temp=monthblock.getAttribute("data-testid");
			temp=temp.toLowerCase();
			month=month.toLowerCase();
			if(temp.contains(month) && temp.contains(""+year))
			{
				flag=1;
				//check that matched month block is visible or not?
				while(true)
				{
					if(monthblock.isDisplayed())
					{
						try
						{
							//dynamic XPATH for given day selection
							monthblock.findElement(By.xpath(
									"descendant::div[@data-testid='undefined-calendar-day-"+day+"']"))
																						.click();
							Thread.sleep(2000);
						}
						catch(Exception ex)
						{
							System.out.println("Wrong day in correct month and year");
						}
						break; //terminate from while loop
					}
					else
					{
						//Click on next to get month blocks into visible
						driver.findElement(By.xpath("(//div[@data-testid='undefined-calendar-picker']//*[name()='svg'])[1]")).click();
						Thread.sleep(2000);
					}
				}
				break; //terminate from for-each loop
			}
		}
		if(flag==0)
		{
			System.out.println("Given month and year not found in this calendar");
		}
	}
}

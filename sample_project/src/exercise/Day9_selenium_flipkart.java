package exercise;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day9_selenium_flipkart {
	
	public RemoteWebDriver dr = null;
	
	@Test
	public void flipkart(){		
		openflipkart_in_ff("https://www.flipkart.com");
		search();
	}

	private void search() {
		WebElement search_field = dr.findElementByXPath("(//*[@id='container']//input)[1]");
		WebElement search = dr.findElementByXPath("//*[@id='container']//button");
		search_field.sendKeys("Home Theaters");
		search.click();		
	}

	public void openflipkart_in_ff(String link) {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile fpro = new FirefoxProfile();
		options.addPreference("dom.webnotifications.enabled", false);
		dr = new FirefoxDriver(options);
		dr.get(link);
		dr.findElementByXPath("/html/body/div[2]/div/div/button").click();
	}
	
	

}

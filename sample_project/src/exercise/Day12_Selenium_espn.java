package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day12_Selenium_espn {

	static public RemoteWebDriver dr;

	@Test
	public void ESPN() throws Throwable {
		browse_no_API();
	}

	public static void browse_no_API() throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		dr = new ChromeDriver(opt);
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.get("https://www.espncricinfo.com");
		//WebDriverWait wait = new WebDriverWait(dr,10);
		//wait.until(ExpectedConditions.visibilityOf(dr.findElementByXPath("//*[@id='overlaybg']/p/a")));
		Set<String> win = dr.getWindowHandles();
		List<String> lst = new ArrayList<String>(win);
		System.out.println(dr.switchTo().window(lst.get(0)).getTitle());
		//WebElement close_button = dr.findElementByXPath("//*[@id='overlaybg']/p/a");
		//close_button.click();
		//dr.switchTo().defaultContent();
		//Thread.sleep(3000);
		//Actions act = new Actions(dr);		
		//act.moveToElement(close_button).click();
		//dr.findElementByXPath("//*[@id='overlaybg']/p/a").click();
		/*Set<String> win = dr.getWindowHandles();
		List<String> lst = new ArrayList<String>(win);
		dr.switchTo().window(lst.get(0)).close();
		Thread.sleep(30000);
		dr.switchTo().defaultContent();*/
		/*WebDriverWait wait = new WebDriverWait(dr,10);
		wait.until(ExpectedConditions.visibilityOf(dr.findElementByXPath("//*[@id='overlaybg']/p/a")));
		dr.findElementByXPath("//*[@id='overlaybg']/p/a").click();*/
	}

}

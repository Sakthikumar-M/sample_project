package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Day18_Selenium_HeadLess_Zomoto {

	RemoteWebDriver dr = null;
	Map<String,String> mp = new HashMap<String,String>();
	List<WebElement> lst = new ArrayList<WebElement>();
	@Test
	public void zomoto() throws Throwable{
		xpaths();
		browse_headless(mp.get("url"));
		search();
	}

	public Map<String,String> xpaths() {
		mp.put("url","https://www.zomato.com/chennai");
		mp.put("search_fld","(//*[@id='root']//input)[2]");
		mp.put("search_lens","(//div[@Class='searchContainer']//i)[4]");
		////div[@Class='searchContainer']//div[3]//div[2]/div/div[2]/div/p[1]/..
		mp.put("result", "//div[@Class='searchContainer']//div[3]//div[2]//img");
		mp.put("order_online", "//*[@id='root']/div/main/div/article/div/section/section/div[2]");		
		mp.put("status", "//*[@id='root']//main//section[3]//section[2]/section/span[1]");
		mp.put("musttry", "//div[@type='tag']/preceding::div[5]/../div[2]//h4/../div/div/div");
		mp.put("items", "//div[@type='tag']/preceding::div[5]/../div[2]//h4");
		return mp;
	}

	public void browse_headless(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		//opt.addArguments("--headless");
		//opt.addArguments("--disable-gpu");
		//opt.addArguments("--disable-extensions");
		opt.addArguments("--disable-notifications");
		opt.addArguments("--start-maximized");
		dr=new ChromeDriver(opt);
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.get(url);
	}
	
	public void search() throws Throwable {
		String item = null;
		dr.findElementByXPath(mp.get("search_fld")).sendKeys("A2B");		
		dr.findElementByXPath(mp.get("search_fld")).click();
		lst = dr.findElementsByXPath(mp.get("result"));
		System.out.println(lst.size());
		/*for (WebElement branches : lst) {
			System.out.println(branches);
		}*/
		//@SuppressWarnings("deprecation")
		//Wait<WebDriver> wait = new WebDriverWait(dr, 10);
		//wait.until(ExpectedConditions.visibilityOfAllElements(lst));
		//Thread.sleep(5000);
		//System.out.println("Selected shop is : "+lst.get(lst.size()-1).getText());
		//lst.get(lst.size()-1).click();
		lst.get(0).click();
		String status = dr.findElementByXPath(mp.get("status")).getText();
		System.out.println("Shop Current Status : "+status);
		Thread.sleep(3000);
		dr.findElementByXPath(mp.get("order_online")).sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		List<WebElement> must = dr.findElementsByXPath(mp.get("musttry"));
		System.out.println("Must Try Size: "+must.size());
		List<WebElement> items = dr.findElementsByXPath(mp.get("items"));
		System.out.println("Items Size: "+items.size());
		int n=0;
		for (WebElement test : must) {
			//if(test.getText().contains("TRY")){
				test.getText();
				item = items.get(n).getText();
				System.out.println(item);
			//}
			n++;
		}
				
	}
}

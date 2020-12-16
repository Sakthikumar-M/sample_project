package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day20_Selenium_OLA {
	static RemoteWebDriver dr = null;
	Map<String, String> mp = new HashMap<String, String>();
	List<WebElement> options = new ArrayList<WebElement>();
	List<String> ls = null;
	Set<String> windows = new TreeSet<String>();
	JavascriptExecutor js = (JavascriptExecutor) dr;

	@Test
	public void OLA() throws Throwable {
		xpaths();
		browse(mp.get("url"));
		select_outstation(mp);
		select_cab();
	}

	public Map<String, String> xpaths() {
		mp.put("url", "https://www.olacabs.com/");
		mp.put("outstation", "//div[@class='booking-tab']/div[2]/a");
		mp.put("pickup", "//div[@class='page-container']/div[2]//div[2]");
		mp.put("pickup_location", "addressInput");
		// *[@id='ow-location']/div[5]/div/div
		mp.put("first_option", "//div[@class='results-row']/div/div");
		mp.put("Drop", "//div[@class='page-container']/div[3]//div[2]");
		mp.put("Drop_location", "addressInput");
		mp.put("search", "//button[@class='ow-button ow-button--secondary']");
		return mp;
	}

	public void browse(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		opt.addArguments("--window-size=1024,768");
		// opt.addArguments("--start-maximized");
		dr = new ChromeDriver(opt);
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dr.get(url);
	}

	private void select_outstation(Map<String, String> mp) throws Throwable {
		Actions act = new Actions(dr);
		act.moveToElement(dr.findElementByXPath(mp.get("outstation"))).click().perform();
		List<WebElement> lst = dr.findElementsByTagName("iframe");
		dr.switchTo().frame(lst.get(0));
		// Pickup location
		pickup_drop(mp.get("pickup"), mp.get("pickup_location"), mp.get("first_option"), "Chennai One");
		// Drop Location
		pickup_drop(mp.get("Drop"), mp.get("Drop_location"), mp.get("first_option"), "Bangalore");
		Thread.sleep(5000);
		// Click Search
		dr.findElementByXPath(mp.get("search")).sendKeys(Keys.ENTER);
		dr.switchTo().defaultContent();
		Thread.sleep(10000);
	}

	public void pickup_drop(String city, String location, String option, String search_key) throws Throwable {
		dr.findElementByXPath(city).click();
		dr.findElementById(location).sendKeys(search_key);
		Thread.sleep(2000);
		dr.findElementById(location).sendKeys(Keys.SPACE);
		options = dr.findElementsByXPath(option);
		System.out.println(options.size());
		System.out.println(options.get(0).getText());
		options.get(0).click();
		options.clear();		
	}

	public void select_cab() throws Throwable {
		windows = dr.getWindowHandles();
		ls = new ArrayList<String>(windows);
		System.out.println(ls.size());
		String name = dr.switchTo().window(ls.get(1)).getTitle();
		System.out.println(name);
		// Shadow-Root identification
		//WebElement Root = dr.findElementByXPath("//body[@service='outstation']/ola-app");
		WebElement Root = dr.findElementByCssSelector("body > ola-app");
		// Get Root Element
		// WebElement element1 = getShadowRoot(Root);

		// Traverse through shadow root
		WebElement shadowElement1 = getShadowElement(Root, "iron-pages");
		//String st_name = shadowElement1.getAttribute("selected-attribute");
		//System.out.println(st_name);
		WebElement shadowElement2 = getShadowElement(shadowElement1, "iron-pages > ola-home");
		WebElement shadowElement3 = getShadowElement(shadowElement2, "div.page-container.bg-light > ola-home-outstation");
		WebElement shadowElement4 = getShadowElement(shadowElement3, "div.os-options > ola-cabs-outstation");
		
		// Go inside Shadow-Root to find Element
		// WebElement shadowElement = element1.findElement(By.cssSelector("div >
		// div:nth-child(5) > div.middle"));
		// shadowElement.click();
	}

	public static WebElement getShadowElement(WebElement root, String cssOfShadowElement) {
		WebElement shardowRoot = getShadowRoot(root);
		return shardowRoot.findElement(By.cssSelector(cssOfShadowElement));
	}

	public static WebElement getShadowRoot(WebElement root) {

		WebElement ele = (WebElement) ((JavascriptExecutor) dr).executeScript("return arguments[0].shadowRoot", root);
		// WebElement ele = (WebElement) js.executeScript("return
		// arguments[0].shadowRoot", root);
		return ele;
	}
}

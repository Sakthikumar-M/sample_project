package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day10_Selenium_ajio {

	RemoteWebDriver dr = null;
	public List<String> lst1 = new ArrayList<String>();
	List<WebElement> prod_nos = new ArrayList<WebElement>();
	int srch = 0;
 
	int prod_loc;

	@Test
	public void ajio() throws Throwable {
		browse("https://www.ajio.com");
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navigate_by_condition();
		total_products();
		size_fit_s();
	}
	
	
	public void browse(String Link) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions copt = new ChromeOptions();
		copt.addArguments("--start-maximized");
		copt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		copt.addArguments("--disable-notifications");
		copt.addArguments("ignore-certificate-errors");
		copt.addArguments("--silent");
		dr = new ChromeDriver(copt);
		dr.get(Link);

	}
	
	public void navigate_by_condition() throws Throwable {
		WebElement women = dr.findElementByXPath("(//*[@id='appContainer']//div[3]//ul/li[1]/following::li[2])[1]");
		WebElement brands = dr.findElementByXPath("(//*[@id='appContainer']//div[3]//ul/li[1]/following::li[2])[1]/div/ul/li[2]/a");
		// women.click();
		Actions act = new Actions(dr);
		act.moveToElement(women).build().perform();
		Thread.sleep(5000);
		act.moveToElement(brands).build().perform();
		Thread.sleep(3000);
		List<WebElement> items = dr.findElementsByXPath(
				"(//*[@id='appContainer']//div[3]//ul/li[1]/following::li[2])[1]/div/ul/li[2]//span");
		System.out.println();
		for (WebElement it : items) {
			//System.out.println(it.getText().toString());
			lst1.add(it.getText().toString());
		}
		int prod = identify_max_smallletter(lst1);
		Thread.sleep(3000);
		items.get(prod).click();
	}
	
	public void total_products() throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) dr;
		//--//*[@id='products']/div[3]/div[2]
		//WebElement page_last = dr.findElementByXPath("//*[@class='main-footer ']/footer/div");
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(15000);
		prod_nos = dr.findElementsByXPath("//*[@id='products']/div[3]/div/div/div");		
		srch = prod_nos.size();
		js.executeScript("arguments[0].scrollIntoView(true);",prod_nos.get(srch));
		
		System.out.println("Total Products on the Page is :"+srch);
		prod_nos.clear();
		js.executeScript("scroll(0, -250)");
	}

	public void size_fit_s() throws Throwable {
		System.out.println("List Size before " +prod_nos.size());
		List<WebElement> filter = dr.findElementsByXPath("//*[@class='rilrtl-list ']/li/div//span[2]");
		String name;
		for (int i=0;i<filter.size();i++) {
			System.out.println(filter.get(i).getText());
			name = filter.get(i).getText();
			Thread.sleep(3000);
			if(name.contains("Size")){
				filter.get(i).click();
				//Thread.sleep(3000);
				dr.findElementByXPath("//*[@class='rilrtl-list ']/li[8]/div/div[2]//ul/li[1]//label").click();
			}
		}
		total_products();
	}

	public int identify_max_smallletter(List<String> lst1) {
		int  n = 0;
		int count = 0;
		int arr_int[] = new int[lst1.size()];
		char[] conv = null;
		
		for (int i = 0; i < lst1.size(); i++) {
			conv = lst1.get(i).toCharArray();
			for (int j = 0; j < conv.length; j++) {
				boolean flag = Character.isLowerCase(conv[j]);
				if (flag == true) {
					count++;
				}
			}
			arr_int[n] = count;
			n++;
			count = 0;
		}
		int temp = 0;
		int arr_unsorted[] = new int[arr_int.length];
		for (int i : arr_unsorted) {
			arr_unsorted[temp] = arr_int[temp];
			temp++;
		}
		temp = 0;
		for (int i = 0; i < arr_int.length; i++) {
			for (int j = i; j < arr_int.length; j++) {
				if (arr_int[i] > arr_int[j]) {
					temp = arr_int[i];
					arr_int[i] = arr_int[j];
					arr_int[j] = temp;
				}
			}
		}
		int max = arr_int[arr_int.length - 1];

		int x = 0;
		
		for (int i = 0; i < arr_unsorted.length; i++) {
			if (arr_unsorted[i] == max) {
				prod_loc = i;
				System.out.println(lst1.get(prod_loc));
			}
		}
		return prod_loc;
	}
}

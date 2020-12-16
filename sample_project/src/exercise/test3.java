package exercise;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Week2_Assignments.dynamic_browsers;

public class test3 extends dynamic_browsers {
	List<WebElement> prod_nos = new ArrayList<WebElement>();
	int srch = 0;
	@Test
	public void scrolling() throws Throwable{
		int n=0;
		//JavascriptExecutor js = (JavascriptExecutor) dr;
		browse("chrome","https://www.ajio.com/s/rangmanch-by-pantaloons-4042-53541?query=%3Arelevance&curated=true&curatedid=rangmanch-by-pantaloons-4042-53541&gridColumns=3");
		//WebElement page_footer = dr.findElementByXPath("//*[@class='main-footer ']");
		//js.executeScript("arguments[0].scrollIntoView(true);",page_footer);
		//Thread.sleep(10000);
		Robot rbt = new Robot();
		
		while(true){
		/*rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_END);
		Thread.sleep(10000);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_END);*/	
	
		prod_nos=dr.findElementsByXPath("//*[@id='products']//img");		
		srch = prod_nos.size();
		System.out.println(srch);
		Actions act = new Actions(dr);
		act.moveToElement(prod_nos.get(prod_nos.size()-1)).build().perform();
		prod_nos.clear();
		
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_HOME);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_HOME);
		}
	
		
	}

}

package cathayPacific.myMaven;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

/**
 * Testing Cathay Pacific
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException,
			IOException {
		System.setProperty("webdriver.gecko.driver",
				"/Users/umerabbs/Documents/workspace/myMaven/geckodriver");
		WebDriver driver = new FirefoxDriver();

		// System.setProperty("webdriver.chrome.driver","/Users/umerabbs/Documents/workspace/testJava/chromedriver");
		// WebDriver driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.cathaypacific.com");

		// driver.findElement(By.xpath("//*[@id='depart-label']")).click();
		// driver.findElement(By.xpath("//*[@id='depart-label']")).sendKeys("SYD");
		Thread.sleep(1000L);

		// double click
		// Actions action = new Actions(driver);
		// WebElement element = driver.findElement(By.id("depart-label"));

		// driver.findElement(By.xpath("//*[contains(@class, 'ui-menu-item-wrapper')]")).click();
		// //Charles De Gaulle (CDG) France
		driver.findElement(By.id("depart-label")).click();
		Thread.sleep(1000L);
		driver.findElement(By.id("depart-label")).sendKeys("sydney");
		Thread.sleep(1000L);

		driver.findElement(
				By.xpath("//*[contains(@class, 'ui-menu-item-wrapper')]"))
				.click(); // Charles De Gaulle (CDG) France
		// driver.findElement(By.id("destination-label")).click();

		// driver.findElement(By.id("destination-label")).click();
		driver.findElement(By.id("destination-label")).sendKeys("paris");
		Thread.sleep(1000L);

		// driver.findElement(By.xpath("//*[contains(@class, 'ui-menu-item-wrapper')]")).click();
		// //Charles De Gaulle (CDG) France
		driver.findElement(By.xpath("//*[@id='ui-id-2']")).click();

		// Selecting Dates
		Thread.sleep(1000L);

		int count = driver.findElements(By.className("date-short")).size();
		System.out.println(count);
		/*
		 * for (int i=0; i<count; i++){
		 * 
		 * String val =
		 * driver.findElements(By.className("date-short")).get(i).getText();
		 * System.out.println(val); if (val.contains("2018")){
		 * 
		 * driver.findElements(By.className("date-short")).get(i).click(); } }
		 */
		// driver.findElement(By.className("field-label input-filled")).click();
		// driver.findElement(By.linkText("Departing")).click();

		driver.findElements(By.className("date-short")).get(4).click();
		Thread.sleep(1000L);

		// driver.findElement(By.xpath("//*[@id='dp1539747954758']/div/table/tbody/tr[4]/td[5]/a")).click();
		// int count1 =
		// driver.findElements(By.xpath("//*[@class = 'ui-state-default']//span[contains(text(), '25')]")).size();
		/*
		 * int count1 = driver.findElements(By.tagName("td")).size();
		 * System.out.println(count1); for (int i=0; i<count; i++){
		 * 
		 * String val = driver.findElements(By.tagName("td")).get(i).getText();
		 * System.out.println(val); if (val.contains("21")){
		 * 
		 * driver.findElements(By.tagName("td")).get(i).click(); } }
		 */

		driver.findElement(By.linkText("21")).click(); // click day

		driver.findElements(By.className("date-short")).get(5).click();
		driver.findElement(By.linkText("28")).click(); // click day

		// driver.findElement(By.xpath("//span[text()='25']")).click();
		// driver.findElement(By.xpath("//*[@class='instruction']//span[contains(text(),'Departing On')]")).click();
		// driver.findElement(By.className("date-short")).click();
		// driver.findElement(By.xpath("//*[@id='dpd4znin']/span[1]")).click();;
		// driver.findElement(By.className("button-placeholder")).click();
		// driver.findElement(By.xpath("//E[contains(text(), 'Departing on')]")).click();
		// driver.findElement(By.xpath("//*[@class='button-placeholder']//span[contains(text(),'Departing On')]")).click();
		// driver.findElement(By.xpath("//div[.='Departing on']")).click();

		// driver.findElement(By.xpath("//*[@id='dp1539675440965']/div/table/tbody/tr[4]/td[5]/a")).click();
		// DONE

		driver.findElement(By.id("trip-passengers-button")).click();
		Thread.sleep(1000L);

		driver.findElement(By.id("passenger-adults")).click();
		Select s = new Select(driver.findElement(By.id("passenger-adults")));
		s.selectByIndex(1);
		Thread.sleep(1000L);

		driver.findElement(By.id("passenger-infants")).click();
		Select s1 = new Select(driver.findElement(By.id("passenger-infants")));
		s1.selectByIndex(1);

		Thread.sleep(2000L);
		// int count = 0;
		// driver.findElement(By.cssSelector("#business")).click();

		driver.findElement(
				By.xpath("//*[@id='book-trip-flight']/div[1]/form/div[6]/div/div[1]/ul/li[2]/label"))
				.click();

		// driver.findElement(By.xpath("//*[@id='book-trip-flight']/div[1]/form/button/span[2]")).click();
		driver.findElement(
				By.xpath("//*[@id='book-trip-flight']/div[1]/form/button"))
				.click();

		// DONE
		Thread.sleep(3000L);

		File srcFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(
				"/Users/umerabbs/Documents/workspace/myMaven/screenshot.png"));

		/*
		 * System.out.println(count =
		 * driver.findElements(By.xpath("//*[@id='business']")).size()); String
		 * val; for (int i=0; i<count; i++){
		 * 
		 * val =
		 * driver.findElements(By.xpath("//*[@id='business']")).get(i).getAttribute
		 * ("value"); System.out.println(val); if (val.equals("C")){
		 * 
		 * driver.findElements(By.xpath("//*[@id='business']")).get(i).click();
		 * } }
		 */
		Thread.sleep(5000L);

		// int count1 =
		// driver.findElements(By.xpath("//*[@id='round-fc']/div/table/tbody/tr[2]/td[1]/div[4]/label/span[2]/span[3]")).size();
		int count1 = driver.findElements(By.cssSelector(".sr-only.ng-binding"))
				.size();

		int min = 0;
		int max = 0;
		for (int i = 0; i < count1; i++) {
			// String val2 =
			// driver.findElements(By.xpath("//*[@id='round-fc']/div/table/tbody/tr[2]/td[1]/div[4]/label/span[2]/span[3])")).get(i).getText();
			String val2 = driver
					.findElements(By.cssSelector(".sr-only.ng-binding")).get(i)
					.getText();
			int temp = Integer.parseInt(val2);
			if (i == 1) {
				min = temp;
			} else if (temp < min) {

				min = temp;
			} else {

				max = temp;
			}
		}

		System.out.println("Smallest Value is " + min);
		if (min < 2000 && min != 0) {
			System.out.println("Test Successful!");
		} else {
			System.out.println("Test FAILED!");

		}
		Thread.sleep(3000L);
		driver.close();

	}
}

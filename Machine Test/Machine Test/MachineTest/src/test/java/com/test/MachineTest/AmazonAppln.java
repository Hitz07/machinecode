package com.test.MachineTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonAppln {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\A714899\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@Test
	public void AmazonCategoriesTest() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.get("https://www.amazon.in/");

			wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-hamburger-menu")));
			WebElement search = driver.findElement(By.id("nav-hamburger-menu"));
			search.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*/div[text()='Fire TV']")));
			WebElement categories = driver.findElement(By.xpath("//*/div[text()='Fire TV']"));
			categories.click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/ul/li/a[text()=\"Fire TV Stick 4K\"]")));
			WebElement fireTVSelect = driver.findElement(By.xpath("//div/ul/li/a[text()=\"Fire TV Stick 4K\"]"));
			fireTVSelect.click();

			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("productTitle")));
			WebElement productName = driver.findElement(By.id("productTitle"));
			String actual = productName.getText();

			Assert.assertEquals(actual, "Fire TV Stick 4K with Alexa Voice Remote | Stream in 4K resolution");
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}

}

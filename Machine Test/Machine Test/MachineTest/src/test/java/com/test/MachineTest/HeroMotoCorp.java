package com.test.MachineTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HeroMotoCorp {
	String CompanyName;

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
	public void SelectHeroMotoCorp() {
		try {
			
			driver.get("http://demo.guru99.com/test/web-table-element.php#");

			for (int i = 1; i <= 26; i++) {
				CompanyName = null;
				WebElement company = driver.findElement(By.xpath("//tr[" + i + "]//td[1]"));
				waitElement(company);
				CompanyName = company.getText();
				System.out.println(CompanyName);
				if (CompanyName.equalsIgnoreCase("Hero MotoCorp")) {
					System.out.println(i);
					System.out.println("Company name found");
					WebElement CurrentPrice = driver.findElement(By.xpath("//tr[" + i + "]//td[4]"));
					waitElement(CurrentPrice);
					System.out.println("Current Price of" + CompanyName + "=" + CurrentPrice.getText());
					company.click();
					break;
				}

				if (i > 25 && CompanyName.equalsIgnoreCase("Hero MotoCorp") == false) {
					driver.navigate().refresh();
					System.out.println("Refresh");
					for (int h = 1; h <= 26; h++) {
						CompanyName = null;
						company = driver.findElement(By.xpath("//tr[" + h + "]//td[1]"));
						CompanyName = company.getText();
						System.out.println(CompanyName);
						if (CompanyName.equalsIgnoreCase("Hero MotoCorp")) {
							System.out.println(i);
							System.out.println("Company name found");
							WebElement CurrentPrice = driver.findElement(By.xpath("//tr[" + i + "]//td[4]"));
							System.out.println("Current Price of" + CompanyName + "=" + CurrentPrice.getText());
							break;
						}

					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}

	public static void waitElement(WebElement element) throws InterruptedException {
		try {
			boolean a = false;
			int counter = 0;
			do {
				a = element.isDisplayed();
				if (a == false) {
					Thread.sleep(1000);
				}
				counter++;
			} while (a == false && counter < 80);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}

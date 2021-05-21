package com.everis.automacao.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RealizarLoginTest {

	private ChromeDriver driver;

	@BeforeEach
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
		driver = new ChromeDriver();
	}

	@Test
	public void logar() {
		
		WebDriverWait wait = new
		WebDriverWait(driver, 10);

		driver.get("http://automationpractice.com/index.php");

		driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).click();
		driver.findElement(By.id("email")).sendKeys("everisbootcamp@qabeginner.com");
		driver.findElement(By.id("passwd")).sendKeys("QA@everis213");
		driver.findElement(By.name("SubmitLogin")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Orders'] span"))); 

	}

	@AfterEach
	public void afterCenario() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}

}

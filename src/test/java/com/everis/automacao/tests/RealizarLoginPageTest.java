package com.everis.automacao.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.everis.automacao.pages.RealizarLoginPage;

public class RealizarLoginPageTest {
	
	private WebDriver driver;
	private RealizarLoginPage realizarLoginPage;
	
	@BeforeEach
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
		driver = new ChromeDriver();
		realizarLoginPage = new RealizarLoginPage(driver);		
	}
	
	@Test
	public void realizarlogin() {
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		realizarLoginPage.RealizarLogin();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Orders'] span"))); 
		WebElement validaTexto = driver.findElement(By.cssSelector("a[title='Orders'] span"));
		Assertions.assertEquals("ORDER HISTORY AND DETAILS", validaTexto.getText());
	}
	
	@AfterEach
	public void quit() {
		driver.quit();
	}

}

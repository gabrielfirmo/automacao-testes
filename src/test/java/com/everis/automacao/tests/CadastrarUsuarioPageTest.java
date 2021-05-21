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

import com.everis.automacao.pages.CadastrarUsuarioPage;

public class CadastrarUsuarioPageTest {

	private WebDriver driver;
	private CadastrarUsuarioPage cadastrarUsuarioPage;

	@BeforeEach
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "src/test/java/resources/chromedriver");
		driver = new ChromeDriver();
		cadastrarUsuarioPage = new CadastrarUsuarioPage(driver);
		
	}

	@Test
	public void cadastrarUsuarioPage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		cadastrarUsuarioPage.cadastrarusuario();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Orders'] span"))); 
		WebElement validaTexto = driver.findElement(By.cssSelector("a[title='Orders'] span"));
		Assertions.assertEquals("ORDER HISTORY AND DETAILS", validaTexto.getText());

	}

	@AfterEach
	public void afterCenario() {
			driver.quit();
	}
}

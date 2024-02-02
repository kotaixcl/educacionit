package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5_E2 {
	WebDriver driver;
	String driverPath = "..\\EducacionIt\\Drivers\\chromedriver.exe";
	String urlTest ="http://demo.guru99.com/test/upload/";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(urlTest);
	}
	
	@Test
	public void cargarArchivo() {
		WebElement rutaACargar = driver.findElement(By.name("uploadfile_0"));
		rutaACargar.sendKeys("C:\\addIntegerData.txt");
	}
	
	@AfterSuite
	public void cerrar() {
		driver.close();
	}
}

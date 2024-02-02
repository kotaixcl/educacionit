package pruebas;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5_E3 {
	WebDriver driver;
	String driverPath = "..\\EducacionIt\\Drivers\\chromedriver.exe";
	String urlTest ="https://demoqa.com/alerts";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(urlTest);
	}
	
	@Test
	public void cargarArchivo() {
		driver.findElement(By.cssSelector("#promtButton")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Orlando");
		alert.accept();
	}
	
	@AfterSuite
	public void cerrar() {
		//driver.close();
	}
}

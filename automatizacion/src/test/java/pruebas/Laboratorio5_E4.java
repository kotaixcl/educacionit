package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5_E4 {
	WebDriver driver;
	String driverPath = "..\\EducacionIt\\Drivers\\chromedriver.exe";
	String urlTest ="http://demo.guru99.com/test/table.html";

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(urlTest);
	}
	
	@Test
	public void cargarArchivo() {
		WebElement celda = driver.findElement(By.xpath("//table/tbody/tr[4]/td[3]"));
		System.out.println(celda.getText());
	}
	
	@AfterSuite
	public void cerrar() {
		//driver.close();
	}
}
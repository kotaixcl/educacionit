package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilidades.DatosExcel;
import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Laboratorio5_E1 {
	WebDriver driver;
	String driverPath = "..\\EducacionIt\\Drivers\\chromedriver.exe";
	String urlTest ="http://automationpractice.com/index.php";
	
	PaginaInicio inicio;
	PaginaLogin login;

	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(urlTest);
	}

	@BeforeMethod
	public void irASignIn() {
		inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
	}
	
	@Test(dataProvider="Datos para Login")
	public void irRegistroLogin(String email, String password) {
		login = new PaginaLogin(driver);
		login.enterEmail(email);
		login.enterPassword(password);
		login.clicOnButton();
	
		Assert.assertEquals(login.getTextTitleForm(), "AUTHENTICATION");
	}
	
	@AfterMethod
	public void goInicio() {
		login.gotoInicio();
	}
	
	@AfterSuite
	public void cerrar() {
		driver.close();
	}
	
	@DataProvider(name="Datos para Login")
	public Object[][] obtenerDatos() throws Exception {
		return DatosExcel.leerExcel("..\\EducacionIt\\Datos\\datosLab5_E1.xlsx", "Hoja1");
	}
}

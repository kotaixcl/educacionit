package paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaInicio {
	// Elementos
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement lnkSignIn;
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	// Constructor
	public PaginaInicio(WebDriver driver) {
		PageFactory.initElements(new AjaxElementLocatorFactory (driver,20), this); // Inicializar los elementos de la clase
	}
	
	// Acciones
	public void hacerClicEnSignIn() {
		lnkSignIn.click();
	}
	
	public void ingresarPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerEnterEnBuscador() {
		txtBuscador.sendKeys(Keys.ENTER);
	}
}

package ar.org.icaro.automatizacion.steps;

import ar.org.icaro.automatizacion.pages.AccountPage;
import ar.org.icaro.automatizacion.pages.CameraDetailsPage;
import ar.org.icaro.automatizacion.pages.CamerasPage;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AgregarACarritoSteps {

    private WebDriver driver;

    private CamerasPage camerasPage;

    private CameraDetailsPage cameraDetailsPage;

    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }

    @Y("agrega una camara al carrito")
    public void agregaUnaCamaraAlCarrito() {
        camerasPage = new CamerasPage(driver);
        camerasPage.scrollHastaCameraDetails();
        cameraDetailsPage = camerasPage.clickTextoCanonEos();
        cameraDetailsPage.agregarACarrito("Blue","2");
    }

    @Entonces("la camara es visible en el carrito")
    public void laCamaraEsVisibleEnElCarrito() {
        cameraDetailsPage.clickbotonCarrito();
        Assert.assertTrue(cameraDetailsPage.botonRemoveCart().isDisplayed());
    }
}

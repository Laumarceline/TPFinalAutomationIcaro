package ar.org.icaro.automatizacion.steps;


import ar.org.icaro.automatizacion.pages.HomePage;
import ar.org.icaro.automatizacion.pages.RegisterPage;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.introspect.BasicBeanDescription;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;


public class CrearCuentaSteps {

    private WebDriver driver;
    private RegisterPage registerPage;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }

    @Cuando("el usuario navega a la pagina de registro")
    public void elUsuarioNavegaALaPaginaDeRegistro() {
        //Completar lo necesario para llegar a la pagina de registro
        homePage = new HomePage(driver);
        homePage.clickBotonMyAccount();
        registerPage = homePage.clickBotonRegisterMyAccount();

    }

    @Y("completa la registracion:")
    public void completaLaRegistracion(Map<String, String> datos) {

        registerPage.scrollHastaElFormulario();
        //Completar lo necesario para completar la registracion
        for (Map.Entry<String, String> filaDatos: datos.entrySet()) {
            WebElement campo = registerPage.getCampoFormularioxInput(filaDatos.getKey().toString());
            campo.sendKeys(filaDatos.getValue().toString());
        }
        registerPage.scrollHastaBotonContinue();
        registerPage.clickBotonContinue();
    }


    @Entonces("el registro fue exitoso")
    public void elRegistroFueExitoso() {
        String congratsText = registerPage.getCongratsText();
        String expectedText = "Congratulations! Your new account has been successfully created!";
        Assert.assertEquals(congratsText, expectedText, "Los textos no coinciden");
    }
}

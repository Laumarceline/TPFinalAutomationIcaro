package ar.org.icaro.automatizacion.steps;

import ar.org.icaro.automatizacion.pages.AccountPage;
import ar.org.icaro.automatizacion.pages.CamerasPage;
import ar.org.icaro.automatizacion.pages.WishListPage;
import ar.org.icaro.automatizacion.steps.driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AgregarAFavoritosSteps {

    private WebDriver driver;

    private AccountPage accountPage;
    private CamerasPage camerasPage;

    private WishListPage wishListPage;

    @Before
    public void setUp() {
        driver = DriverManager.driver;
    }

    @Cuando("navega a la seccion de camaras")
    public void navegaALaSeccionDeCamaras() {
        accountPage = new AccountPage(driver);
        camerasPage=accountPage.clickBotonCameras();
    }


    @Y("agrega una camara a favoritos")
    public void agregaUnaCamaraAFavoritos() {
        camerasPage.scrollHastaCameraDetails();
        camerasPage.clickBotonHearth();
        wishListPage = camerasPage.clickBotonWishListTotal();
    }

    @Entonces("la camara aparece en la wish list")
    public void laCamaraApareceEnLaWishList() {
        //Assert.assertTrue(wishListPage.table().isDisplayed());
        String productNameText = wishListPage.productNameTexto();
        String expectedText = "Canon EOS 5D";
        Assert.assertEquals(productNameText, expectedText, "Los textos no coinciden");
    }
}

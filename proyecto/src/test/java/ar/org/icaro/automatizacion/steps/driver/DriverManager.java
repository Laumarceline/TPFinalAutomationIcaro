package ar.org.icaro.automatizacion.steps.driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverManager {
    public static WebDriver driver;

    /**
     * El argumento 'order' indica el nivel de prioridad ante otros métodos con la
     * notación @Before (un valor de 'order' más bajo tiene mayor prioridad que uno con
     * valor más alto. El valor por defecto (si no se pone explicitamente) es order = 10000)
     */
    @Before(order = 1)
    public void setUp() {
        /*
        Realizamos algunas configuraciones para evitar problemas con los certificados del
        sitio y abrimos el navegador en incógnito para evitar problemas con las cookies
        */
        FirefoxProfile fp = new FirefoxProfile();
        fp.setAcceptUntrustedCertificates(true);

        FirefoxOptions fo = new FirefoxOptions();
        fo.setProfile(fp);
        fo.addArguments("-private");
        driver = new FirefoxDriver(fo);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

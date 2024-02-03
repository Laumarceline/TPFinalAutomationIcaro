package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {

    private By formularioBy = By.id("content");
    private By checkBoxPolicyBy = By.cssSelector("div.container:nth-child(4) div.row div.col-sm-9 form.form-horizontal:nth-child(3) div.buttons:nth-child(4) div.pull-right > input:nth-child(2)");
    private By botonContinueBy = By.cssSelector("div.container:nth-child(4) div.row div.col-sm-9 form.form-horizontal:nth-child(3) div.buttons:nth-child(4) div.pull-right > input.btn.btn-primary:nth-child(3)");

    private By congratsTextBy=By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]");
    private WebElement ingresoFormulario;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void scrollHastaElFormulario() {
        //Scrolleamos hasta el formulario para que los elementos esten a la vista
        WebElement formulario = getFormulario();
        scrollHasta(formulario);
    }

    private WebElement getFormulario() {
        wait.until(
                ExpectedConditions.presenceOfElementLocated(formularioBy));
        return driver.findElement(formularioBy);
    }

    public WebElement getCampoFormularioxInput(String texto) {
        String nombrexCSS = "#input-".concat(texto);
        By inputBy = By.cssSelector(nombrexCSS);
        return driver.findElement(inputBy);
    }

    public void clickBotonContinue() {
        scrollHasta(checkBoxPolicy());
        checkBoxPolicy().click();
        botonContinue().click();
    }

    private WebElement checkBoxPolicy() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxPolicyBy));
        return driver.findElement(checkBoxPolicyBy);
    }

    private WebElement botonContinue() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(botonContinueBy));
        return driver.findElement(botonContinueBy);
    }

    public void scrollHastaBotonContinue() {
        //Scrolleamos hasta el formulario para que los elementos esten a la vista
        scrollHasta(botonContinue());
    }

    private WebElement congratsText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(congratsTextBy));
        return driver.findElement(congratsTextBy);
    }

    public String getCongratsText() {
        return congratsText().getText();
    }
}

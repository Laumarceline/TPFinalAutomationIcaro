package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CameraDetailsPage extends BasePage {

    private By opcionesBy = By.cssSelector("#product");
    private By colorListOpcBy = By.cssSelector("#input-option226");
    private By cantidadOpcBy = By.cssSelector("#input-quantity");

    private By botonAddToCartBy = By.cssSelector("#button-cart");
    private By botonCartTotalBy = By.cssSelector("#cart-total");
    private By botonRemoveCartBy = By.xpath("//tbody/tr[1]/td[5]/button[1]/i[1]");
    public CameraDetailsPage(WebDriver driver) {
        super(driver);
    }

    private WebElement opciones() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(opcionesBy));
        return driver.findElement(opcionesBy);
    }
    private WebElement cantidadOpc() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cantidadOpcBy));
        return driver.findElement(cantidadOpcBy);
    }
    public void agregarACarrito(String color, String cantidad){
        Select selectList = new Select(driver.findElement(colorListOpcBy));
        selectList.selectByVisibleText(color);
        cantidadOpc().clear();
        cantidadOpc().sendKeys(cantidad);
        driver.findElement(botonAddToCartBy).click();
    }


    public void clickbotonCarrito() {
        driver.findElement(botonCartTotalBy).click();
    }

    public WebElement botonRemoveCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(botonRemoveCartBy));
        return driver.findElement(botonRemoveCartBy);
    }






}

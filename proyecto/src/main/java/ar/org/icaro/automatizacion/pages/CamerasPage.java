package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CamerasPage extends BasePage{

    private By botonHearthBy = By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/button[2]/i[1]");
    private By botonWishListTotalBy = By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[3]/a[1]/i[1]");

    private By cameraDetailsBy = By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]");

    private By textoCanonEosBy = By.cssSelector("div.container:nth-child(4) div.row div.col-sm-9 div.row:nth-child(3) div.product-layout.product-grid.col-lg-4.col-md-4.col-sm-6.col-xs-12:nth-child(1) div.product-thumb div:nth-child(2) div.caption h4:nth-child(1) > a:nth-child(1)");


    public CamerasPage(WebDriver driver) {
        super(driver);
    }

    public WishListPage clickBotonWishListTotal() {
        scrollHasta(botonWishListTotal());
        botonWishListTotal().click();
        return new WishListPage(driver);
    }

    private WebElement botonWishListTotal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(botonWishListTotalBy));
        return driver.findElement(botonWishListTotalBy);
    }

    private WebElement cameraDetails() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cameraDetailsBy));
        return driver.findElement(cameraDetailsBy);
    }
    public void scrollHastaCameraDetails() {
        //Scrolleamos hasta el formulario para que los elementos esten a la vista
        scrollHasta(cameraDetails());
    }

    private WebElement botonHearth() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(botonHearthBy));
        return driver.findElement(botonHearthBy);
    }

    public void clickBotonHearth() {
        botonHearth().click();
    }

    private WebElement textoCanonEos() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textoCanonEosBy));
        return driver.findElement(textoCanonEosBy);
    }

    public CameraDetailsPage clickTextoCanonEos() {
        textoCanonEos().click();
        return new CameraDetailsPage(driver);
    }






}

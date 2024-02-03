package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountPage extends BasePage {
    By myAccountTextBy = By.xpath("//h2[text()='My Account']");
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    private By botonCamerasBy = By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[7]/a[1]");


    public String getMyAccountSubtitulo() {
        return myAccountSubtitulo().getText();
    }

    private WebElement myAccountSubtitulo() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(myAccountTextBy));
        return driver.findElement(myAccountTextBy);
    }

    private WebElement botonCameras() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(botonCamerasBy));
        return driver.findElement(botonCamerasBy);
    }

    public CamerasPage clickBotonCameras() {
        botonCameras().click();
        return new CamerasPage(driver);
    }
}

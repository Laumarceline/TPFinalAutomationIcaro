package ar.org.icaro.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WishListPage extends BasePage{

    private By productNameBy = By.cssSelector("div.container:nth-child(4) div.row div.col-sm-9 div.table-responsive:nth-child(2) table.table.table-bordered.table-hover tbody:nth-child(2) tr:nth-child(1) td.text-left:nth-child(2) > a:nth-child(1)");
    private By tableBy = By.tagName("table");
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public WebElement productName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productNameBy));
        return driver.findElement(productNameBy);
    }

    public String productNameTexto() {
        return productName().getText().toString();
    }

    public WebElement table() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tableBy));
        return driver.findElement(tableBy);
    }

}

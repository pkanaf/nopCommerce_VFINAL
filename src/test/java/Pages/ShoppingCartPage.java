package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {

    public void clickShoppingCartLink() {
        WebElement shoppingCartLink = baseDP.driver.findElement(By.xpath(".//a[normalize-space()='shopping cart']"));
        shoppingCartLink.click();

    }
}

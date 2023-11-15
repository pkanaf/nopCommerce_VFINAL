package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductPage extends baseDP {

    public void clickHTConeImage() {
        WebElement HTConeImage = baseDP.driver.findElement(By.xpath("//div[@class='picture']//img[@title='Show details for HTC One M8 Android L 5.0 Lollipop']"));
        HTConeImage.click();
    }


    public void clickAddToCartButton() {
        WebElement addToCartButton = baseDP.driver.findElement(By.xpath("//button[@id='add-to-cart-button-18']"));
        addToCartButton.click();
    }
}

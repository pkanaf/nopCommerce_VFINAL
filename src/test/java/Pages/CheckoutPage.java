package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    public void selectTermsAndConditionsCheckbox() {
        WebElement termsCheckbox = baseDP.driver.findElement(By.xpath(".//input[@id='termsofservice']"));
        termsCheckbox.click();
    }

    public void clickCheckoutButton() {
        WebElement checkoutButton = baseDP.driver.findElement(By.xpath(".//button[@id='checkout']"));
        checkoutButton.click();

    }
}

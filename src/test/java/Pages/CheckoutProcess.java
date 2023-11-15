package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckoutProcess extends baseDP {
    
    public void clickBillingSaveButton() {
        WebElement billingSaveButton = driver.findElement(By.xpath("//button[@onclick='Billing.save()']"));
        billingSaveButton.click();
    }

    public void clickShippingMethodNextStepButton() {
        WebElement shippingMethodNextStepButton = driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        shippingMethodNextStepButton.click();
    }

    public void clickPaymentMethodNextStepButton() {
        WebElement paymentMethodNextStepButton = driver.findElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        paymentMethodNextStepButton.click();
    }

    public void clickPaymentInfoNextStepButton() {
        WebElement paymentInfoNextStepButton = driver.findElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        paymentInfoNextStepButton.click();
    }

    public void clickConfirmButton() {
        WebElement confirmButton = driver.findElement(By.xpath("//button[normalize-space()='Confirm']"));
        confirmButton.click();
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        continueButton.click();
    }
}


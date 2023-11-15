package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BillingInf extends baseDP {

	
	public void clickCheckoutAsGuest() {
	    WebElement checkoutAsGuestButton = driver.findElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
	    checkoutAsGuestButton.click();
	}

    public void enterFirstNameTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
        textBox.clear();
        textBox.sendKeys("AA");
    }
    
    public void enterLastNameTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']"));
        textBox.clear();
        textBox.sendKeys("MCIT");
    }
    
    public void enterEmailTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']"));
        textBox.clear();
        textBox.sendKeys("AA@mcit.com");
    }
    
    public void selectCountryDropdown() {
        WebElement dropdownElement = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Canada");
    }
    
    public void selectProvinceDropdown() {
        WebElement dropdownElement = driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Quebec");
    }

    
    public void enterCityTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        textBox.clear();
        textBox.sendKeys("Montreal");
        
    }
    
    public void enterZIPTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
        textBox.clear();
        textBox.sendKeys("0J0 0M0");
        
    }
    
    public void enterPhoneTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
        textBox.clear();
        textBox.sendKeys("123 456-7890");
        
    }
    
    public void enterAdressTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']"));
        textBox.clear();
        textBox.sendKeys("rue MTL");
        
    }


    public void clickContinueButton() {
        WebElement ContinueButton = baseDP.driver.findElement(By.xpath("//button[@onclick='Billing.save()']"));
        ContinueButton.click();
    
    }
}

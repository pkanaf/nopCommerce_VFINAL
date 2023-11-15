package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class RegisterPage extends baseDP {

	
    public void enterFirstNameTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='FirstName']"));
        textBox.clear();
        textBox.sendKeys("Ana");
    }
    
    public void enterLastNameTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='LastName']"));
        textBox.clear();
        textBox.sendKeys("MCIT");
    }
    
    public void enterEmailTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='Email']"));
        textBox.clear();
        textBox.sendKeys("anamcit@gmail.com");
    }
    
    public void enterPasswordTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='Password']"));
        textBox.clear();
        textBox.sendKeys("IOPjklBNM");
    }
    
    public void enterConfirmPasswordTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        textBox.clear();
        textBox.sendKeys("IOPjklBNM");
        
    }

    public void clickRegisterButton() {
        WebElement RegisterButton = baseDP.driver.findElement(By.xpath("//button[normalize-space()='Register']"));
        RegisterButton.click();
    
    }
}


//input[@id='FirstName']
//input[@id='LastName']
//input[@id='Email']

//input[@id='Password']
//input[@id='ConfirmPassword']
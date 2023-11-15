package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;

public class HomePage extends baseDP {
	
    public void clickRegisterButton() {
    	WebElement RegisterButton= baseDP.driver.findElement(By.xpath("//a[@class='ico-register']"));
    	RegisterButton.click();
    }
	
    public void hoverOverEletronicsMenu() {
        WebElement eletronicsMenu = baseDP.driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        Actions actions = new Actions(baseDP.driver);
        actions.moveToElement(eletronicsMenu).perform();    	
    }
    

    public void clickCellphonesgSubMenu() {
    	WebElement CellphonesgSubMenu = baseDP.driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
    	CellphonesgSubMenu.click();
    }
    
    public void clickLoginPage() {
        WebElement loginPage = baseDP.driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginPage.click();
    }
    
    public void enterRegistredEmailTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='Email']"));
        textBox.clear();
        textBox.sendKeys("AA@mcit.com");
    }
    
    public void enterPasswordTextBox() {
        WebElement textBox = baseDP.driver.findElement(By.xpath("//input[@id='Password']"));
        textBox.clear();
        textBox.sendKeys("123123");
    }
    
    public void clickEnterPage() {
        WebElement enterPage = baseDP.driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
        enterPage.click();
    }
    
}



package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import java.util.Properties;
import org.apache.log4j.Logger;
import java.io.IOException;


public class TestNopCommerce extends baseDP {
	
	public static Logger log;
	public ExtentTest test;
	private Properties prop;
	//private Properties props=new Properties();
    WebDriver driver;
    int waitingTime = 2000;
    
    @BeforeTest
    public void setup() throws InterruptedException {        
        String browserName = "chrome";
        
        baseDP.setupBrowser(browserName);
        Thread.sleep(waitingTime);
        log = Logger.getLogger(TestNopCommerce.class.getName());
        log.info("setting up the browser for the test");
        
 /*       public static Properties propFileReader() throws IOException {
    		String propfile = "./src/test/resources/config.properties";
    		FileReader reader=new FileReader(propfile);
    		props.load(reader);
    		return props;
    	}
    	*/ 
        
        //to read the property files
        
        try {
            prop = propFileReader();
            browserName = prop.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        baseDP.setupBrowser(browserName);
        Thread.sleep(waitingTime);
        log = Logger.getLogger(TestNopCommerce.class.getName());
        log.info("Setting up the browser for the test");
    }
    
    

    @Test(priority = 1)
    public void clickEletronicsMenu() throws InterruptedException {
        HomePage homePage = new HomePage();
        try {
            homePage.hoverOverEletronicsMenu();
            Thread.sleep(waitingTime);
            log.info("Step 1: Hover over Electronics menu");

            WebElement cellPhonesSubMenu = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
            Assert.assertTrue(cellPhonesSubMenu.isDisplayed(), "Cell phones submenu not visible after hovering over Electronics");

            log.info("Step 1: Electronics menu hover successful");
        } catch (Exception e) {
            log.error("Step 1: Hover over Electronics menu failed");
        }
    }
   
    @Test(priority = 2)
    public void testCellphonesgSubMenu() throws InterruptedException {
        HomePage homePage = new HomePage();
        try {
            homePage.clickCellphonesgSubMenu();
            Thread.sleep(waitingTime);
            log.info("Step 2: Cell phones submenu click successful");
            
            WebElement cellPhonesHeading = driver.findElement(By.xpath("//h1[normalize-space()='Cell phones']"));
            Assert.assertTrue(cellPhonesHeading.isDisplayed(), "Cell phones heading not visible after clicking submenu");
        
            log.info("Step 2: Cell phones submenu click successful");
        } catch (Exception e) {
            log.error("Step 2: Click on Cell phones submenu failed");
        }
    }

    @Test(priority = 3)
    public void testHTConeImage() throws InterruptedException {
        ProductPage productPage = new ProductPage();
        try {
            productPage.clickHTConeImage();
            Thread.sleep(waitingTime);
            log.info("Step 3: Click on the desired cellphone successful");

            WebElement productDetails = driver.findElement(By.xpath("//h1[contains(text(), 'HTC One M8 Android')]"));
            Assert.assertTrue(productDetails.isDisplayed(), "Product details page not loaded");

            log.info("Step 3: Click on the desired cellphone successful");
        } catch (Exception e) {
            log.error("Step 3: Clicking on the desired cellphone failed");
        }
    }

    @Test(priority = 4)
    public void testAddToCart() throws InterruptedException {
        ProductPage productPage = new ProductPage();
        try {
            productPage.clickAddToCartButton();
            Thread.sleep(waitingTime);
            log.info("Step 4: Click on Add to Cart button successful");

            WebElement cartConfirmation = driver.findElement(By.xpath("//div[contains(text(), 'Product has been added to cart')]"));
            Assert.assertTrue(cartConfirmation.isDisplayed(), "Product not added to cart");

            log.info("Step 4: Click on Add to Cart button successful");
        } catch (Exception e) {
            log.error("Step 4: Clicking on Add to Cart button failed");
        }
    }

    @Test(priority = 5)
    public void testShoppingCart() throws InterruptedException {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        try {
            shoppingCartPage.clickShoppingCartLink();
            Thread.sleep(waitingTime);
            log.info("Step 5: Click on the Shopping Cart link successful");

            String cartPageTitle = driver.getTitle();
            Assert.assertTrue(cartPageTitle.contains("Shopping Cart"), "Shopping Cart page not loaded");

            log.info("Step 5: Click on the Shopping Cart link successful");
        } catch (Exception e) {
            log.error("Step 5: Clicking on the Shopping Cart link failed");
        }
    }

    @Test(priority = 6)
    public void testTermsAndConditions() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage();
        try {
            checkoutPage.selectTermsAndConditionsCheckbox();
            Thread.sleep(waitingTime);
            log.info("Step 6: Select Terms and Conditions checkbox");
        } catch (Exception e) {
            log.error("Step 6: Selecting Terms and Conditions checkbox failed");
        }
    }
    
    
    @Test(priority = 7)
    public void testCheckout() throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage();
        try {
            checkoutPage.clickCheckoutButton();
            Thread.sleep(waitingTime);
            log.info("Step 7: Click on Checkout button successful");

            WebElement billingInfoForm = driver.findElement(By.id("BillingNewAddress_FirstName"));
            Assert.assertTrue(billingInfoForm.isDisplayed(), "Did not navigate to Billing Information page");

            log.info("Step 7: Click on Checkout button successful");
        } catch (Exception e) {
            log.error("Step 7: Clicking on Checkout button failed");
        }
    }

    @Test(priority = 8)
    public void testCheckoutAsGuest() throws InterruptedException {
        BillingInf billinginf = new BillingInf();
        try {
            billinginf.clickCheckoutAsGuest();
            Thread.sleep(waitingTime);
            log.info("Step 8: Click on Checkout as Guest successful");

            WebElement firstNameInput = driver.findElement(By.id("BillingNewAddress_FirstName"));
            Assert.assertTrue(firstNameInput.isDisplayed(), "Did not proceed to Billing Information page");

            log.info("Step 8: Click on Checkout as Guest successful");
        } catch (Exception e) {
            log.error("Step 8: Clicking on Checkout as Guest failed");
        }
    }
    
    @Test(priority = 9)
    public void testBillingInformation() throws InterruptedException {
        BillingInf billinginf = new BillingInf();
        try {

        billinginf.enterFirstNameTextBox();
        billinginf.enterLastNameTextBox();
        billinginf.enterEmailTextBox();
        billinginf.selectCountryDropdown();
        billinginf.enterCityTextBox();
        billinginf.enterAdressTextBox();
        billinginf.enterZIPTextBox();
        billinginf.enterPhoneTextBox();
        billinginf.selectProvinceDropdown();
      
        Thread.sleep(waitingTime);
        log.info("Step 9: Fill in Billing Information");

        WebElement billinginformation = driver.findElement(By.id("BillingInfo"));
        Assert.assertTrue(billinginformation.getAttribute("value").isEmpty(), "Billing Information fields not filled");


        log.info("Step 9: Fill in Billing Information");
    } catch (Exception e) {
        log.error("Step 9: Filling in Billing Information failed");
    }
}
    
    @Test(priority = 10)
    public void testBillingSaveButton() throws InterruptedException {
        CheckoutProcess checkoutProcess = new CheckoutProcess();
        try {
            checkoutProcess.clickBillingSaveButton();
            Thread.sleep(waitingTime);
            log.info("Step 10: Click on Billing Save Button successful");

            WebElement shippingMethod = driver.findElement(By.className("shipping-method-list"));
            Assert.assertTrue(shippingMethod.isDisplayed(), "Did not proceed to the Shipping Method");

            log.info("Step 10: Click on Billing Save Button successful");
        } catch (Exception e) {
            log.error("Step 10: Clicking on Billing Save Button failed");
        }
    }

    @Test(priority = 11)
    public void testShippingMethodNextStepButton() throws InterruptedException {
        CheckoutProcess checkoutProcess = new CheckoutProcess();
        try {
            checkoutProcess.clickShippingMethodNextStepButton();
            Thread.sleep(waitingTime);
            log.info("Step 11: Click on Shipping Method Next Step Button successful");

            WebElement paymentMethod = driver.findElement(By.className("payment-method-list"));
            Assert.assertTrue(paymentMethod.isDisplayed(), "Did not proceed to Payment Method");

            log.info("Step 11: Click on Shipping Method Next Step Button successful");
        } catch (Exception e) {
            log.error("Step 11: Clicking on Shipping Method Next Step Button failed");
        }
    }

    @Test(priority = 12)
    public void testPaymentMethodNextStepButton() throws InterruptedException {
        CheckoutProcess checkoutProcess = new CheckoutProcess();
        try {
            checkoutProcess.clickPaymentMethodNextStepButton();
            Thread.sleep(waitingTime);
            log.info("Step 12: Click on Payment Method Next Step Button successful");

            WebElement paymentInfo = driver.findElement(By.id("payment-info"));
            Assert.assertTrue(paymentInfo.isDisplayed(), "Did not proceed to Payment Information");

            log.info("Step 12: Click on Payment Method Next Step Button successful");
        } catch (Exception e) {
            log.error("Step 12: Clicking on Payment Method Next Step Button failed");
        }
    }

    @Test(priority = 13)
    public void testPaymentInfoNextStepButton() throws InterruptedException {
        CheckoutProcess checkoutProcess = new CheckoutProcess();
        try {
            checkoutProcess.clickPaymentInfoNextStepButton();
            Thread.sleep(waitingTime);
            log.info("Step 13: Click on Payment Info Next Step Button successful");

            WebElement confirmation = driver.findElement(By.id("confirmation"));
            Assert.assertTrue(confirmation.isDisplayed(), "Did not proceed to Order Confirmation");

            log.info("Step 13: Click on Payment Info Next Step Button successful");
        } catch (Exception e) {
            log.error("Step 13: Clicking on Payment Info Next Step Button failed");
        }
    }

    @Test(priority = 14)
    public void testConfirmButton() throws InterruptedException {
        CheckoutProcess checkoutProcess = new CheckoutProcess();
        try {
            checkoutProcess.clickConfirmButton();
            Thread.sleep(waitingTime);
            log.info("Step 14: Click on Confirm Button successful");

            WebElement orderConfirmation = driver.findElement(By.className("order-confirmation"));
            Assert.assertTrue(orderConfirmation.isDisplayed(), "Order confirmation not displayed");

            log.info("Step 14: Click on Confirm Button successful");
        } catch (Exception e) {
            log.error("Step 14: Clicking on Confirm Button failed");
        }
    }

    @Test(priority = 15)
    public void testContinueButton() throws InterruptedException {
        CheckoutProcess checkoutProcess = new CheckoutProcess();
        try {
            checkoutProcess.clickContinueButton();
            Thread.sleep(waitingTime);
            log.info("Step 15: Click on Continue Button successful");

            WebElement thankYouMessage = driver.findElement(By.className("thank-you-message"));
            Assert.assertTrue(thankYouMessage.isDisplayed(), "Did not reach Thank You page");

            log.info("Step 15: Click on Continue Button successful");
        } catch (Exception e) {
            log.error("Step 15: Clicking on Continue Button failed");
        }
    }

    
    @AfterTest
    public void tearDown() {
        baseDP.tearDownBrowser();
         
    }
  
}


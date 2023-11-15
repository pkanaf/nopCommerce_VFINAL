package testPages;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.baseDP;
import Utilities.ExcelDataRead;

public class DataProviderExcelTest extends baseDP {
    private HomePage hp;
    WebDriver driver;
    int waitingTime = 2000;

   /* @BeforeClass
    public void setUpTest() throws InterruptedException {
        setupBrowser("chrome");
        driver = getDriver();
        getDriver().get("https://demo.nopcommerce.com/");
        hp = new HomePage();
    }
    */

    
    @DataProvider
    public static Object[][] readExcelData() throws InvalidFormatException {
        ExcelDataRead excelDataRead = new ExcelDataRead();
        Object[][] loginData = excelDataRead.getTestData("Sheet1");
        
        return loginData;
    }

    
    @Test(dataProvider = "readExcelData")
    public void setupTest(String browser, String url) throws InterruptedException {
        setupBrowser(browser);
        driver = getDriver();
        getDriver().get(url);
        hp = new HomePage();
        Assert.assertNotNull(hp, "ERROR!! nopCommerce home page not launched");
        Thread.sleep(waitingTime);
        getDriver().quit();

    }

    
   /* @AfterClass
    public void tearDown() {
        baseDP.tearDownBrowser();
      
    }
   */   
}

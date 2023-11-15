package testPages;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.baseDP;
import Pages.HomePage;
import Utilities.mySqlConnect;

public class dataProviderMySqlTest extends baseDP{
	
	private WebDriver driver;
	private HomePage hp;
	
		
    @DataProvider
    public Object[][] mySqlReadData() throws ClassNotFoundException, SQLException {
        Object[][] dataFromDataBase = mySqlConnect.getMySqlData();
        Object[][] testData = new Object[dataFromDataBase.length][4];

        for (int i = 0; i < dataFromDataBase.length; i++) {
            testData[i][0] = dataFromDataBase[i][0].toString();
            testData[i][1] = dataFromDataBase[i][1].toString();
            testData[i][2] = dataFromDataBase[i][2].toString();
            testData[i][3] = dataFromDataBase[i][3].toString();
        }
        return testData;
    }
	
	@Test(dataProvider = "mySqlReadData")
	public void setUpTest ( String baseURL, String browser, String un, String pwd) {
		setupBrowser(browser);
		driver = getDriver();
		getDriver().get(baseURL);
		hp = new HomePage();
		Assert.assertNotNull(hp,"ERROR: nopCommerce homepage is not launched!");
		driver.quit();

	}

}

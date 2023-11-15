package Pages;

import java.io.IOException;
import java.util.Properties;
import java.io.FileReader;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

public class baseDP extends TestClass{
	
    public static WebDriver driver;

    public static void setupBrowser(String browserName) {
    	
        if (browserName.equalsIgnoreCase("chrome")) {
            //System.setProperty("webdriver.chrome.driver", "C://AnaPanek//nopcommerce//Browsers/chromedriver.exe");
        	WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();
            
            driver.manage().window().maximize();

            driver.get("https://demo.nopcommerce.com/");
            
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
          
            driver.manage().window().maximize();

            driver.get("https://demo.nopcommerce.com/");
        }
    }

	public static void navigateToURL(String string) {
		// TODO Auto-generated method stub	
	}

	public static void tearDownBrowser() {
		driver.close();
		driver.quit();
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

	public static String takeSnapShot(String methodName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Properties propFileReader() throws IOException {
		Properties props = new Properties();
		String propfile = "./src/test/resources/config.properties";
		FileReader reader=new FileReader(propfile);
		props.load(reader);
		return props;

		
	}
}

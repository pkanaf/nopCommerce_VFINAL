package Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class utils extends baseDP {
	
    public void takeScreenShot() throws IOException {
        File srce = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String datetime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
       
        File targetfile = new File("C:\\AnaPanek\\nopcommerce\\Screenshots" + File.separator + "ErrorStatus_" + datetime + ".png");
        
        System.out.println(targetfile);
        FileUtils.copyFile(srce, targetfile);
    }
}

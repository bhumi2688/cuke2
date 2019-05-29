import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.xml.stream.FactoryConfigurationError;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.io.FileUtils.copyFile;

public class Hooks extends BasePage {

    BrowserSelector browserSelector = new BrowserSelector();
    static String timeStamp = new SimpleDateFormat("dd.MM.yy.HH.mm.ss").format(new Date());


    @Before
    public void setUpBrowser() {
        browserSelector.setUpBrowser();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
        driver.manage().window().fullscreen();
        driver.get("http://demo.nopcommerce.com/");

    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {

            try {
               TakesScreenshot ts = (TakesScreenshot ) driver ;

                File source = ts.getScreenshotAs(OutputType.FILE );

                FileUtils.copyFile(source,new File("src\\Screenshot" + scenario.getName() + ".png" ));

                System.out.println("Screenshot taken");

            }
            catch(Exception e )
            {
                System.out.println("Exception while takin screenshot" + e.getMessage());
             }
        }
    }
}
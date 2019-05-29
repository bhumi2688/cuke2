import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserSelector extends Utils {

    LoadProp loadProp = new LoadProp();

    public void setUpBrowser(){
        String browser = loadProp.getProperty("browser");

        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","src\\Resources\\BrowserDriver\\geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver();
            driver.manage().window().fullscreen();

        }
        else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src\\Resources\\BrowserDriver\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extention");
            options.addArguments("--disable-setUpBrowser-side-navigation");
            options.addArguments("--incognito");
            options.addArguments("--disable-blink-features-BlockCredentialSubresources");
            driver = new ChromeDriver(options);
            driver.manage().window().fullscreen();
        }
        else if(browser.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.IE.driver","src\\Resources\\BrowserDriver\\IEDriverServer.exe ");
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setCapability(InternetExplorerDriver.IE_SWITCHES, "private");
            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            driver = new InternetExplorerDriver(options );
            driver.manage().window().maximize();
        }
        else
        {
            System.out.println("|Browser name is empty or typed wrong" + browser);

        }



    }


}

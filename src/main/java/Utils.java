import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {
    //Clicking Element
    public static void clickElementBy(By by)
    {
        driver.findElement(by).click();
    }
    //clickin elements
    public static void clickElements(By by)
    {
        driver.findElement(by ).click() ;
    }
    //entering elements
    public static void enterElements(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    //clear text from inputbox area
    public static void cleartext(By by)
    {
        driver.findElement(by).clear();
    }
    //Enter text in input field
    public static void inputfield(By by,String text)
    {
        driver.findElement(by).sendKeys(text) ;
    }

    //clear and Enter Text in input field
    public static void clearandenterText(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);

    }
    //checking webelement present in DOM
    public static boolean  WebElemntpresent(By by){
        try
        {
            driver.findElement(by).click() ;
            return true;
        }
        catch(NoSuchElementException e )
        {
            return false;

        }
    }
    //checking web element Displayed or not
    public static boolean Elementdisplayedornot(By by){
        try
        {
            driver.findElement(by).isDisplayed();
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }
    //Select Text by value
    public static void selectTextByValue(By by,String text){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);

    }
    //wait to be Displayed time
    public static void waitForElementDisplay(By by,int time){
        WebDriverWait wait = new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by) );

    }
    //wait for fixed time given in seconds
    public static void waitForElementtobeclickable(By by,int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by) );
    }
    //try to click element three times if not available in first go
    public boolean retryforElement(By by){
        boolean result = false;
        int attempt = 0;
        while(attempt <3){
            try {

                Thread.sleep(20);
                driver.findElement(by).click();
                result = true;
            }
            catch(Exception e){

            }

            attempt++;
        }
        return result;


    }
    //wait for locators to be clickablefor given time in seconds
    public static void Wiatforlocatortobeclickable(By by,int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(by) );
    }
    //wait for visibility of element with given time
    public static void explicitwaitforvisibilty(By by,int seconds){
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by) );
    }
    //capture ScreenShot
    public static void captureScreenshot(String screenShotName){

        TakesScreenshot ts = (TakesScreenshot)driver;

        File source = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(source, new File("./Screenshots/" +screenShotName +".png"));
            System.out.println("Screenshot Taken");
        }
        catch(IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }

    }
    //create timestamp with current day-month-hour-minute
    public static String randomNumber()
    {
        DateFormat format = new SimpleDateFormat("ddMMHHmm");
        return format.format(new Date());
    }
    //Create timestamp with current day-month-year-hour-minute-second
    public static String randomDate()
    {
        DateFormat format = new SimpleDateFormat();
        return format.format(new Date());
    }
    //creating email and
    public static String GetCurrentTimeStamp() {
        SimpleDateFormat  sdfDate = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;

    }
    //get Attribute by value
    public static String getvalue(By by)
    {
        return driver.findElement(by).getAttribute("Value");
    }
    //scroll to element and click
    public  void ScrollAndClick(By by) {

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        try {

            Thread.sleep(10);
        } catch (InterruptedException e) {
            WebElement element = driver.findElement(by);
            js.executeScript("argument[0].scrollIntoview(true);", element);
            //Thread.sleep(10);
            element.click();
        }
    }
    //scroll to view element
    public void ScrolltoViewElement(By by){
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor)driver).executeScript("argument[0].scrollIntoview(true);",element);
        try
        {
            Thread.sleep(20);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        element.getText();
    }

    // get selected value from dropdown
    public static void selectByValue(By by ,String data){
        Select dob = new Select(driver.findElement(by));
        dob.selectByValue(data);
    }
    //select text from value
    public static void getActualText(By by,String text) {
        driver.findElement(by).getText();

    }
    //wait for alert to display
    public boolean isAlertPresent(){
        boolean present = false;
        try{
            Alert alert= driver.switchTo().alert();
            present = true;
            alert.accept();
        }
        catch(NoAlertPresentException ex){
            ex.printStackTrace();
        }
        return present;
    }
    // get css property of element
    public static String getAtrributeofElement(WebElement element,String css ){
        String value= element.getCssValue(css);
        return value ;
    }

// enter text
    public static void enterText(By by , String text){
        driver.findElement(by).sendKeys(text);
    }

    //assert actual expected
    public void assertEquals(By actual,String expected)
    {
        Assert.assertEquals(driver.findElement(actual).getText(),expected );
    }
    //assert by url
    public void assertUrl(String text )
    {
        Assert.assertTrue(driver.getCurrentUrl().contains(text ));
    }
    //Assert by get text element
    public String getTextFromElement(By by)
    {
return driver.findElement(by).getText();
    }
    //return text from Webemelemt
    public String getTextFromElement(WebElement element){
        return element.getText();

    }
    //Current Url
    public static void assertCurrentUrl(String url) {
       Assert.assertTrue(driver.getCurrentUrl().equals(url));
    }


}












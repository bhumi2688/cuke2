import org.openqa.selenium.By;

public class Homepage extends Utils {

    LoadProp loadprop = new LoadProp();

    //Welcome to Store
    By _welcomeMessage = By.xpath("//h2[contains(text(),'Welcome to our store')]");


    //Click on Login
    By loginLink = By.linkText("Log in");



    public void clickonLogInLink()
    {
        clickElementBy(loginLink );

    }


}

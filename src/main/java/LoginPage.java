import org.openqa.selenium.By;

public class LoginPage extends Utils {

    LoadProp loadProp = new LoadProp() ;

    By _Email = By .id("Email");
    By _password = By.id("Password");
    By _loginBtn = By.xpath("//input[@class='button-1 login-button']");
    By _ErrorMessage = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/ul[1]/li[1]");
    By _Emailerrormessage= By.xpath("//span[@id='Email-error']");



    public void verifyUserIsOnLoginPage()

    {
        assertUrl("login");
    }



    public void userentersLoginDetails(String Email,String password ) {
        enterElements(_Email,Email); ;

        enterElements(_password, password  );

        clickElementBy(_loginBtn);

    }

    public String actualErrorMesaage()
    {
        String s = getTextFromElement(_ErrorMessage);
        System.out.println(s);
        return s;
    }
    public String actualEmailErrorMessage()
    {
        String s = getTextFromElement(_Emailerrormessage);
        //System.out.println(s);
        return s;
    }



}

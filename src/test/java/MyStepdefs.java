import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class MyStepdefs extends Homepage {


    Homepage homepage = new Homepage();
    LoginPage loginPage = new LoginPage();


    @Given("^user is on Login page$")
    public void userIsOnLoginPage() {
     homepage.clickonLogInLink();
    }

    @When("^user enters invalid \"([^\"]*)\" or \"([^\"]*)\"$")
    public void userEntersInvalidOr(String Email, String password) throws Throwable {
        loginPage.userentersLoginDetails(Email, password);

    }

    @Then("^user should able to see the \"([^\"]*)\"$")
    public void userShouldAbleToSeeThe(String errormessage) throws Throwable {
        boolean b;
        if(loginPage.actualErrorMesaage().contains(errormessage)||(loginPage.actualEmailErrorMessage().contains(errormessage ) ) )
        {
            b=true;
        }
        else
        {
            b=false;
        }
        Assert.assertTrue(b);

    }
}

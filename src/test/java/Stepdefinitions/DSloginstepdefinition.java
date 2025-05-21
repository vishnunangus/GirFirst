package Stepdefinitions;

import Pages.Baseclass;
import Pages.Loginpage;
import Pages.Projectspage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class DSloginstepdefinition extends Baseclass {

    private Loginpage lp = new Loginpage(driver);
    private Projectspage pp = new Projectspage(driver);


    @Given("User is on Login page")
    public void user_is_on_login_page() {

        System.out.println("User is on Login page");

    }

    @When("User enters {} and {}")
    public void userEntersAnd(String username, String password) {

        lp.enter_username(username);
        lp.enter_passowrd(password);
        lp.click_on_login();
//        lp.click_on_launchapp();
    }


    @Then("Validate user is on login page using text from {string}")
    public void validateUserIsOnLoginPageUsingTextFrom(String filepath) throws IOException {

        pp.Validate_Login();
    }
}


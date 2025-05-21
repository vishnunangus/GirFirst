package Pages;

import Utilities.Utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Loginpage extends Baseclass {

    Utility utility = new Utility();

    @FindBy(xpath = "//input[@name='username']")
    WebElement Email;

    @FindBy(xpath = "//input[@name='password']" )
    WebElement Password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement Login;

    @FindBy(xpath = "//a[@href=\"https://testing.agency.e-dot.com\"]")
    WebElement Launchapp;

    public void enter_username(String username) {


        Email.sendKeys(username);
    }


    public void enter_passowrd(String password) {
        Password.sendKeys(password);
    }

    public void click_on_login() {
        Login.click();
    }

    public void click_on_launchapp() {

        utility.pageLoadTimeImplicity();
        utility.elementVisibilityOf(Launchapp);
        Launchapp.click();

    }

    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

}

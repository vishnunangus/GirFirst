package Pages;

import Utilities.Utility;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;


public class Projectspage extends Baseclass {

    Utility utility;


    @FindBy(xpath = "//h1[text()='Projects']")
    WebElement ValidateDsLogin;

    @FindBy(xpath = "//button[@data-testid=\"createProjectButtonId\"]")
    WebElement btn_createproject;

    @FindBy(xpath = "//input[@name=\"projectTitle\"]")
    WebElement txt_projectitile;

    @FindBy(xpath = "//input[@name=\"stateProjectNumber\"]")
    WebElement txt_stateprojectnumber;

    @FindBy(xpath = "//input[@name=\"federalProjectNumber\"]")
    WebElement txt_federalnumber;

    @FindBy(xpath = "//textarea[@name=\"productDescription\"]")
    WebElement txt_projectdescription;

    @FindBy(xpath = "//textarea[@name=\"publicDescription\"]")
    WebElement txt_motorist;

    @FindBy(xpath = "//button[text()='Create Project']")
    WebElement btn_createprojectinside;

    @FindBy(xpath = "//div[text()='Project Successfully Created']")
    WebElement success_msg;



    public void Validate_Login() throws IOException {

        FileReader reader = new FileReader("C://Users/KSPL/IdeaProjects/Dotslip/src/test/resources/PropertiesFile/PropertyFile.txt");
        Properties prop = new Properties();
        prop.load(reader);
        String expected_txt = prop.getProperty("ValidateLogin");
        utility.pageLoadTimeImplicity();
        String actual_txt = ValidateDsLogin.getText();
        Assert.assertEquals(expected_txt, actual_txt);

    }

    public void click_on_createproject() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to the right by a specific number of pixels
        js.executeScript("window.scrollBy(500, 0);");
        btn_createproject.click();
    }

    public void enter_project_title() {
        Map<String, String> entervalue = utility.getUniqueData();
        String title = entervalue.get("projectTitle");
        txt_projectitile.sendKeys(title);
    }

    public void enter_state_project_number() {
        Map<String, String> entervalue = utility.getUniqueData();
        String spn = entervalue.get("stateProjectNumber");
        txt_stateprojectnumber.sendKeys(spn);
    }

    public void enterProjectDescription(String message) {
        txt_projectdescription.sendKeys(message);
    }

    public void entermotoristnotification(String message) {
        txt_motorist.sendKeys(message);
    }

    public void enterfederalprojectnumber(String message) {
        txt_federalnumber.sendKeys(message);
    }

    public void createprojectbuttoninside() {
        btn_createprojectinside.click();
    }

    public void validate_success_msg()
    {
        String actual = "Project Successfully Created";
        String expected = success_msg.getText();
        Assert.assertEquals(actual,expected);
    }


    public Projectspage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new Utility();
    }


}

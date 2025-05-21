package Utilities;

import Pages.Baseclass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class Utility extends Baseclass {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public void pageLoadTimeImplicity() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    }

    public void elementVisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementVisibility(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(visibilityOfElementLocated(locator));
    }

//    public void propertyFile() throws IOException {
//        FileReader reader = new FileReader("C://Users/KSPL/IdeaProjects/Dotslip/src/test/resources/PropertiesFile/PropertyFile.txt");
//        Properties prop = new Properties();
//        prop.load(reader);
//
//    }

    public Map<String, String> getUniqueData() {

        String uniqueProjectTitle = "Project_" + System.currentTimeMillis();
        String uniqueStateProjectNumber = "SPN_" + System.currentTimeMillis();

        Map<String, String> uniqueData = new HashMap<>();
        uniqueData.put("projectTitle", uniqueProjectTitle);
        uniqueData.put("stateProjectNumber", uniqueStateProjectNumber);

        return uniqueData;


    }

    public Map<String, String> getUniqueGroupData() {

        String uniqueGroupTitle = "Grp_" + System.currentTimeMillis();
        String uniqueGroupdescription = "Grp_desc" + System.currentTimeMillis();

        Map<String, String> grpuniqueData = new HashMap<>();
        grpuniqueData.put("GroupTitle", uniqueGroupTitle);
        grpuniqueData.put("GroupDescription", uniqueGroupdescription);

        return grpuniqueData;


    }

    public void scrollTotop(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollTobottom(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void scrollToTopAndClickWithWait(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        // Wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        // Click the element
        element.click();

    }

    public void Visibility_of_Element(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }



}



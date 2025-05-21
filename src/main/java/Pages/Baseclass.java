package Pages;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Baseclass {

    public static WebDriver driver;


    public void initializeDriver()
    {

        driver = new ChromeDriver();
        driver.get("https://testing.app.e-dot.com/");
        driver.manage().window().maximize();
//        JavascriptExecutor jse = (JavascriptExecutor) driver ;
//        jse.executeScript("document.body.style.zoom='50%'");


//
//        Dimension size = driver.manage().window().getSize();
//        int currentWidth = size.getWidth();
//        int currentHeight = size.getHeight();
//        int newWidth = (int) (currentWidth * 0.8);
//        int newHeight = (int) (currentHeight * 0.8);
//        System.out.println("New Width: " + newWidth + ", New Height: " + newHeight);
//        driver.manage().window().setSize(new Dimension(newWidth, newHeight));


    }

    public static void tearDown() {

        driver.quit();
    }

}

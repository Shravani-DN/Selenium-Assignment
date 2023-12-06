import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.Arrays;

public class OptionsMethodsExamples {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=800,500");  //addArguments for window re-sizing
        options.addArguments("--incognito");   //to open browser in incognito mode
        // options.addArguments("--headless"); //this will run the test in headless mode, like browser GUI will not visible

        WebDriver driver = new ChromeDriver(options);
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));  //to disable window popups
        driver.get("https://artoftesting.com");
        driver.navigate().to("https://artoftesting.com");
        driver.findElement(By.id("button1")).click();           //Clicking an element directly
        WebElement element = driver.findElement(By.name("q"));      //Creating a textbox webElement
        element.sendKeys("ArtOfTesting!");                //Using sendKeys to write in the textbox
        driver.findElement(By.name("q")).clear();               //Clearing the text written in text fields
        driver.findElement(By.id("element123")).getText();      //Fetching the text written over web elements
        driver.navigate().back();                               //Navigating backwards in browser
        driver.navigate().forward();                            //Navigating forward in browser
        driver.navigate().refresh();                            //Refreshing browser using navigate().refresh()
        driver.findElement(By.id("shravani")).sendKeys(Keys.F5);   //refreshing the oage by pressing F5 key on any textbox element
        driver.close();                                         //To close the current browser instance
        driver.quit();                                          //To close all the open browser instances

    }
}

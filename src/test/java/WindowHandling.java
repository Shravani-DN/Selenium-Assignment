import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandling {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();   //depcrecated
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
       // wait.until(ExpectedConditions.visibilityOf())
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("Ind");
        Thread.sleep(2000);
        List<WebElement> suggestedNames =  driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/div"));

        for (WebElement name : suggestedNames) {
            Thread.sleep(1000);
            if (name.getText().equalsIgnoreCase("India")){
                name.click();
            }

        }
        driver.findElement(By.id("openwindow")).click();
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);
        Iterator<String> iterator = windows.iterator();
        //iterator.next();
        String parentWindow = iterator.next();
        System.out.println(parentWindow);
        System.out.println(driver.getCurrentUrl());
       // String childWindow = iterator.next();
        Wait<WebDriver> wait1 = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))          // Maximum time to wait
                .pollingEvery(Duration.ofSeconds(5))          // Polling interval
                .ignoring(org.openqa.selenium.NoSuchElementException.class);


    }
}

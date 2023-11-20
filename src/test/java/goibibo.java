import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class goibibo {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();   //depcrecated
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        // wait.until(ExpectedConditions.visibilityOf())
        driver.get("https://extendsclass.com/text-compare.html");
//        driver.findElement(By.xpath("//p[@class='sc-12foipm-20 bhnHeQ']")).sendKeys("Bang");
//        Wait<WebDriver> wait1 = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(30))          // Maximum time to wait
//                .pollingEvery(Duration.ofSeconds(5))          // Polling interval
//                .ignoring(org.openqa.selenium.NoSuchElementException.class);
//
        Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class);

       // WebElement foo = wait1.until(new Function<WebDriver, WebElement>() {
        //    public WebElement apply(WebDriver driver) {
         //       return driver.findElement(By.xpath("//*[text()='Download Builder']"));
         //   }
       // });
    }
        }

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoverOver {
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
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement framee = driver.findElement(By.id("courses-iframe"));

        driver.switchTo().frame(framee);
      //  driver.findElement(By.xpath("//div[@class='login-btn']")).click();
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1700)");
        //actions.moveToElement(frame).perform();
        driver.switchTo().parentFrame();
       // driver.switchTo().defaultContent();

    }
}
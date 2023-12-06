import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class RelativeLocatorsExample {
    public static void main(String[] args) throws InterruptedException, IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();   //depcrecated
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        // wait.until(ExpectedConditions.visibilityOf())
        driver.get("https://www.browserstack.com/");

        //above
        WebElement percy = driver.findElement(By.xpath("(//a[@title='Percy'])[3]"));
        WebElement getADemo = driver.findElement(RelativeLocator.with(By.tagName("button")).above(percy));
        getADemo.click();

        //below
//        WebElement textSection = driver.findElement(By.xpath("//p[@class='vwo_loaded vwo_loaded_777']"));
//        WebElement getAdemo = driver.findElement(RelativeLocator.with(By.tagName("button")).below(textSection));
//        getAdemo.click();

        //to right to
//        WebElement getStartedFree = driver.findElement(By.cssSelector("a#signupModalProductButton"));
//        WebElement getDemo = driver.findElement(RelativeLocator.with(By.tagName("button")).toRightOf(getStartedFree));
//        getDemo.click();

        //to left of
//        WebElement getADemoo = driver.findElement(By.xpath("(//button[@class='btn btn-secondary btn-lg col-md-3'])[2]"));
//        WebElement getStartedFreee = driver.findElement(RelativeLocator.with(By.tagName("a")).toLeftOf(getADemoo));
//        getStartedFreee.click();

        //near
//        WebElement freeTrial = driver.findElement(By.xpath("//span[text()='Free Trial']"));
//        WebElement search = driver.findElement(RelativeLocator.with(By.tagName("button")).near(freeTrial));
//        search.click();

    }
}

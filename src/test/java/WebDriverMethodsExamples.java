import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WebDriverMethodsExamples {
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
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); //get
        String PageTitle = driver.getTitle();                              //getTitle
        System.out.println("Page Title is:" + PageTitle);
        String url = driver.getCurrentUrl();                                //getCurrentUrl
        System.out.println("current url is:" + url);
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='block large-row-spacer']"));  //findelements
        driver.findElement(By.xpath("//label[@for='radio1']")).click();        //findelement
        String source = driver.getPageSource();         //getPageSource
        System.out.println(source);
        driver.findElement(By.id("openwindow")).click();
        Set<String> windows = driver.getWindowHandles();        //getWindowHandles
        System.out.println(windows);
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        System.out.println(parentWindow);
        driver.navigate().to("https://www.google.com/");
        driver.navigate().back();                   //navigate
        driver.navigate().forward();


    }
}

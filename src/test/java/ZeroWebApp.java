import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ZeroWebApp {
    public static void main(String[] args) throws InterruptedException, IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();   //depcrecated
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        DevTools devTools = driver.getDevTools();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        // wait.until(ExpectedConditions.visibilityOf())
        driver.get("http://zero.webappsecurity.com/login.html");
       // driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", Map.of())
        //label[@class='control-label']
        WebElement loginText = driver.findElement(By.xpath("//label[text()='Login']"));
        WebElement textField = driver.findElement(RelativeLocator.with(By.tagName("input")).below(loginText));
        textField.click();
//        List<WebElement> webElementList = driver.findElements(RelativeLocator.RelativeBy.tagName("label"));
//        for (WebElement we : webElementList){
//            System.out.println("label text"+we.getText());
//            System.out.println("Attribute"+we.getAttribute("for"));
//        }
//        WebElement userName = driver.findElement(RelativeLocator.RelativeBy.id("user_login"));
//        userName.sendKeys("username");
//        userName.clear();
//        userName.sendKeys("endbbfv");
//        WebElement labelusername = driver.findElement(RelativeLocator.with(By.tagName("label")).toLeftOf(userName));
//        labelusername.click();
//        System.out.println(userName.getText());
//        System.out.println(labelusername.getText());

    }

}


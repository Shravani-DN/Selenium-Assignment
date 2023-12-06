import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "path");
        //instead of the above line we can use WebDriverManager
        DesiredCapabilities capabilities = new DesiredCapabilities();   //depcrecated
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);  //None>Eager>Normal //speed of browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        //driver.
        //driver.get("https://93.90.204.96/VSM3Test/ui/auth/signin");  //desired capabilities
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        options.addArguments("--start-maximized");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//input[@value='radio3']")).click();
        driver.findElement(By.xpath("//input[@value='radio3']")).click();
        // wait = WebDriverWait(driver, 10);
        //  SearchContext searchContext = new SearchContext() {  //SearchContext is interface //anonymous class

        driver.manage().window().maximize();  //maximizing the window
        //  options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //to remove the info bar
        // options.addExtensions(new File("path of extension file"));  //to add any extension file
        //  options.addArguments("--proxy-server=http://192.160.0.102:8888");
        // options.setExperimentalOption("excludeSwitches", Collections.singletonList()); //to exclude extensions - it will enable the development mode
//        options.addArguments("--incognito");
//        driver.findElement(By.xpath("//div[text()='My booking']")).click();
//        driver.findElement(By.xpath("(//input[@name='bookingRef'])[1]")).sendKeys("QW12TY");
//        driver.findElement(By.xpath("((//input[@name='lastName'])[1]")).sendKeys("QW12TY");
//        driver.findElement(By.xpath("//button[text()='My booking']")).submit();
//
//        driver.get("http://zero.webappsecurity.com/login.html");
//        String crURL = driver.getCurrentUrl();
//        System.out.println("URL= " + crURL);
//        String crTitle = driver.getTitle();
//        System.out.println("Title of URL is: " + crTitle);
//
//        List<WebElement> webElementList = driver.findElements(By.tagName("label"));
//        for (WebElement we : webElementList) {
//            System.out.println("Label Text =" + we.getText());
//            System.out.println("Attribute =" + we.getAttribute("for"));
//        }
//        WebElement userName = driver.findElement(By.id("user_login"));
//        userName.sendKeys("UserName");
//        userName.clear();
//        userName.sendKeys("2nd UserName");
//        System.out.println(userName.getText());
//        System.out.println("Size:" + userName.getSize());
//        System.out.println("Tag_name:" + userName.getTagName());
//        System.out.println("Location:" + userName.getLocation());
//        System.out.println("Element Rectangle:" + userName.getRect());
//        System.out.println("Color value:" + userName.getCssValue("color"));

    }
}

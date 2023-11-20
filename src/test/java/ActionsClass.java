import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsClass {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();   //depcrecated
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
     //   wait.until(ExpectedConditions.visibilityOf())
//        driver.get("https://jqueryui.com/droppable/");
//        Actions actions = new Actions(driver);
//        Thread.sleep(5000);
//        WebElement ele = driver.findElement(By.id("draggable"));
//        WebElement destEle = driver.findElement(By.id("droppable"));
//       // ele.click();
//        actions.dragAndDrop(ele, destEle);

        //double click and right click
        driver.get("https://demoqa.com/buttons");
        WebElement element = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
        Actions action = new Actions(driver);
        action.doubleClick(element).build().perform();
        WebElement element1 = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
        action.contextClick(element1).build().perform();

        //drag and drop
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        Thread.sleep(3000);
        Actions action1 = new Actions(driver);
        WebElement source = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        Thread.sleep(1000);
        WebElement destination = driver.findElement(By.xpath("//*[@id='bank']/li"));
        action1.dragAndDrop(source, destination).build().perform();
        Thread.sleep(3000);

        //Shift
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement element2 = driver.findElement(By.xpath("//textarea[@title='Search']"));
        Actions action2 = new Actions(driver);
        action2.keyDown(element2,Keys.SHIFT).sendKeys("google").build().perform();


    }
}

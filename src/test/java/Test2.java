import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();   //depcrecated
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://formstone.it/components/dropdown/demo/");
        Select objSelect =new Select(driver.findElement(By.id("demo_basic")));
        Thread.sleep(1000);
        objSelect.selectByIndex(1);
        Thread.sleep(5000);
        objSelect.selectByValue("1");

        Select labelDD = new Select(driver.findElement(By.id("demo_label")));
        Thread.sleep(1000);
        labelDD.selectByVisibleText("Kansas");

        Select groupdropdown = new Select(driver.findElement(By.id("demo_groups")));
        Thread.sleep(1000);
        groupdropdown.selectByVisibleText("Four");


        driver.switchTo().alert().accept();


    }
}

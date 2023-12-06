import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Assignment {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");   //point 1
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); //point 2
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.naturesbasket.co.in/");   //point 3
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("btnClosePopUpBox"))).build().perform();    //point 4
        Thread.sleep(2000);
        driver.findElement(By.id("btnPinOk")).click();
        Thread.sleep(2000);
        Select objSelect =new Select(driver.findElement(By.id("ctl00_ddlCitySearch")));
        Thread.sleep(1000);
        objSelect.selectByValue("kolkata");    //point 5
        Thread.sleep(2000);
        driver.findElement(By.id("btnPinOk")).click();      //point 6

        WebElement ele = driver.findElement(By.id("ctl00_txtMasterSearch1"));
        actions.moveToElement(ele).perform();   //point 7
        List<WebElement> listOfNames =  driver.findElements(By.xpath("//ul[@id='ctl00_NonPanIndia']/li/a"));
        for (WebElement name : listOfNames) {
            Thread.sleep(1000);
            if (name.getText().equalsIgnoreCase("Chocolates")){
                name.click();   //point 8
                break;
            }
        }
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");          //point 9
        driver.findElement(By.xpath("//div[@class='search_AddCart1 ']")).click();
        driver.findElement(By.xpath("//input[@placeholder='Delivery pincode']")).sendKeys("560001");
        driver.findElement(By.id("btnAddPin")).click();
        driver.findElement(By.id("btnAddPin")).click();
        driver.findElement(By.xpath("//div[@class='search_AddCart1 ']")).click();
        driver.findElement(By.xpath("//a[text()='Ferrero Rocher Gift Pack 200G (16 P..']")).click();  //point 10
        Thread.sleep(2000);
        String chocolateTitle = driver.findElement(By.xpath("(//h1[@class='pd_Title'])[1]")).getText();
       System.out.println(chocolateTitle);   //point 11
        driver.navigate().back();  //point 12
        js.executeScript("window.scrollBy(0,2500)", "");   //point 13
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_txtNewletter")).sendKeys(chocolateTitle);  //point 14 & point 15
        JavascriptExecutor jsExec = (JavascriptExecutor)driver;

        jsExec.executeScript("window.scrollTo(0, 0);"); //Scroll To Top

        Long innerHeight = (Long) jsExec.executeScript("return window.innerHeight;");
        Long scroll = innerHeight;

        Long scrollHeight = (Long) jsExec.executeScript("return document.body.scrollHeight;");

        scrollHeight = scrollHeight + scroll;

        do{

            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            //Unique File Name For Each Screenshot
            File destination = new File("E://screenshots//"+String.join("_",
                    LocalDateTime.now().toString().split("[^A-Za-z0-9]"))+".jpg");

            FileUtils.copyFile(screenshot, destination);

            jsExec.executeScript("window.scrollTo(0, "+innerHeight+");");

            innerHeight = innerHeight + scroll;

        }while(scrollHeight >= innerHeight);

}
}

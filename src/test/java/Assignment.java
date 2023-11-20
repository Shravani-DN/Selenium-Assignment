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
//        Alert alert = driver.switchTo().alert();
//        alert.dismiss();
//        Set<String> wnd = driver.getWindowHandles();
//        // window handles iteration
//        Iterator<String> i = wnd.iterator();
//        String prntw = i.next();
//        String popwnd = i.next();
//        // switching pop up window handle id
//        driver.switchTo().window(popwnd);
//        System.out.println("Page title of popup: "+ driver.getTitle());
//        // closes pop up window
//        driver.close();
//        // switching parent window handle id
//        driver.switchTo().window(prntw);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("btnClosePopUpBox"))).build().perform();    //point 4
        Thread.sleep(5000);
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
        driver.findElement(By.xpath("//a[text()='Ferrero Rocher Gift Pack 200G (16 P..']")).click();  //point 10
        Thread.sleep(2000);
        String chocolateTitle = driver.findElement(By.xpath("(//h1[@class='pd_Title'])[1]")).getText();
       // driver.findElement(By.xpath("(//h1[@class='pd_Title'])[1]")).sendKeys(Keys.CONTROL,"c");
       // driver.findElement (By.xpath("/html/body/main/div/div/div[2]/div/div/div[2]/div/table/tbody/tr[2]/td[2]")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
        System.out.println(chocolateTitle);   //point 11
        driver.navigate().back();  //point 12
        js.executeScript("window.scrollBy(0,2500)", "");   //point 13
        Thread.sleep(2000);
        driver.findElement(By.id("ctl00_txtNewletter")).sendKeys(chocolateTitle);  //point 14
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File filescrshot = screenshot.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        FileUtils.copyFile(filescrshot, new File("./Screenshot/"+chocolateTitle+timeStamp+".png"));



    }
}

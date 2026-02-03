
package qa.selenium.tests;

import org.testng.annotations.Listeners;
import qa.selenium.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import qa.selenium.utils.ScreenshotUtil;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Listeners(TestListener.class)
     public class BaseTest {

         protected WebDriver driver;

         @BeforeMethod
         public void setUp() {
             driver = new ChromeDriver();
             driver.manage().window().maximize();

             ScreenshotUtil.setDriver(driver);
         }

         @AfterMethod
         public void tearDown() {
             if (driver != null) {
                 driver.quit();
             }
         }
         public void takeScreenshot(String testName) {
             TakesScreenshot ts = (TakesScreenshot) driver;

             File source = ts.getScreenshotAs(OutputType.FILE);

             String timestamp = LocalDateTime.now()
                     .format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));

             File destination = new File(
                     "screenshots/" + testName + "_" + timestamp + ".png"
             );

             try {
                 FileHandler.copy(source, destination);

             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }

package qa.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void openGoogleTest() {
        driver.get("https://www.google.com");

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Google"),
                "Title does NOT contain 'Google'");
    }
    @Test
    public void googleSearchTest() {
        driver.get("https://www.google.com");

        driver.findElement(By.name("q"))
                .sendKeys("Selenium WebDriver" + Keys.ENTER);

        Assert.assertTrue(driver.getTitle().contains("Selenium"),
                "Search results page title is inccorect");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


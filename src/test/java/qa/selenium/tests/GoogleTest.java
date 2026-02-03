package qa.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.selenium.pages.GooglePage;
import qa.selenium.pages.GoogleResultPage;

public class GoogleTest {
    WebDriver driver;
    GooglePage googlePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        googlePage = new GooglePage(driver);
    }

    @Test
    public void googleSearchTest() {

        googlePage.open();

        GoogleResultPage resultPage =
                googlePage.searchFor("Selenium WebDriver");

        Assert.assertTrue(
                resultPage.areResultsDisplayed(),
                "Result are NOT displayed"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

package qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");
            String title = driver.getTitle();

            if (title.contains("Google")) {
                System.out.println("TEST PASSED: Title countains Google");
            } else {
                System.out.println("TEST FAILED: Title does NOT countain Google");
            }

            // pronadji google search polje
            driver.findElement(By.name("q"))
                    .sendKeys("Selenium WebDriver" + Keys.ENTER);
            Thread.sleep(3000);

            String currentUrl = driver.getCurrentUrl();

            if (currentUrl.contains("search") ||
                currentUrl.contains("selenium")) {
                System.out.println("TEST PASSED: Search results page opened");
            } else {
                System.out.println("TEST FAILED: Search results page is NOT opened");
            }

            // Da viidis rezultat
            Thread.sleep(5000);
        }  catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
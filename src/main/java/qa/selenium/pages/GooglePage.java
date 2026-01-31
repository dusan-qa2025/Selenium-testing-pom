package qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class GooglePage extends qa.selenium.pages.BasePage {
    private By searchBox = By.name("q");

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public void open() {
        driver.get("https://google.com");
    }
    public void search(String text) {
        driver.findElement(searchBox).sendKeys(text +  Keys.ENTER);
    }
    public String getTitle() {
        return driver.getTitle();
    }
}

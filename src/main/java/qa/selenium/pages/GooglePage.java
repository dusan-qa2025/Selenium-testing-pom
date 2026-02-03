package qa.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static java.awt.SystemColor.text;


public class GooglePage extends qa.selenium.pages.BasePage {
    private By searchBox = By.name("q");

    public GooglePage(WebDriver driver) {
        super(driver);
    }

    public void acceptCookiesIfPresent() {
        List<WebElement> buttons = driver.findElements(acceptCookiesButton);
        if (!buttons.isEmpty()) {
            buttons.get(0).click();
        }
    }


        private By acceptCookiesButton =
                By.xpath("//button//div[text()='Accept all']|//button//" +
                        "span[text()='Accept all']");


    //Actions
        public void open () {
            driver.get("https://google.com");
            acceptCookiesIfPresent();
        }

        public GoogleResultPage searchFor (String text){
            acceptCookiesIfPresent();

        WebElement searchInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchBox)
        );
        searchInput.clear();
        searchInput.sendKeys(text);
        searchInput.sendKeys(Keys.ENTER);

            return new GoogleResultPage(driver);
        }


        public String getTitle () {
            return driver.getTitle();
        }
    }

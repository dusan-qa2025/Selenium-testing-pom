package qa.selenium.pages;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleResultPage extends qa.selenium.pages.BasePage {

    private By resultTitles = By.cssSelector("h3");

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean areResultsDisplayed() {
        return wait
                .until(ExpectedConditions
                        .visibilityOfElementLocated(resultTitles))
                .isDisplayed();
    }
}

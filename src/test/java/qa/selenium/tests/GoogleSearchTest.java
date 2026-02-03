package qa.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.selenium.listeners.TestListener;
import qa.selenium.pages.GooglePage;
import qa.selenium.pages.GoogleResultPage;
import org.testng.annotations.Listeners;


public class GoogleSearchTest extends BaseTest {

@DataProvider(name = "searchData")
public Object[][] searchData() {
    return new Object[][] {
            {"Selenium TestNG"},
            {"Java automation testing"},
            {"QA engineer"}
    };
}
    @Test(dataProvider = "searchData")
    public void GoogleSearchShouldReturnResult(String text) {

        GooglePage googlePage = new GooglePage(driver);
        googlePage.open();

        GoogleResultPage googleResultPage = googlePage.searchFor(text);

        Assert.assertTrue(googleResultPage.areResultsDisplayed());
    }
}
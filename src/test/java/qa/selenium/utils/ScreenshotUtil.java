package qa.selenium.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        driver = driver;
    }

    public static String takeScreenshot(String testName) {
        File srcFile =
                ((TakesScreenshot)
                driver).getScreenshotAs(OutputType.FILE);

        String screenshotDir =
                System.getProperty("user.dir") + "/test-output/" +
                        "screenshots/";

        new File(screenshotDir).mkdirs();

        String filePath =
                screenshotDir + testName + "_" +
                        System.currentTimeMillis() + ".png";

        File destFile = new File(filePath);

        try {
            Files.copy(srcFile.toPath(), destFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}

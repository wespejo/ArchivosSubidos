package starter.util;

import net.serenitybdd.screenplay.Performable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonClass {



    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Performable waitForAlert(WebDriver driver, int timeToWait) {
        new WebDriverWait(driver,timeToWait).until(ExpectedConditions.alertIsPresent());
        return null;
    }
}

package driverActions;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps_definition.Hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class driverActions {
    public static Faker faker = new Faker();
    ;
    public static Properties prop;

    public driverActions() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\settings\\settings.properties");
        prop.load(fis);
    }

    public static JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;


    //*****************************************wait element to be clickbale *************************************************//
    public static void waitclickable(By element) {
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));
    }

    //****************************************Navigate to *************************************************//
    public void navigateTo(String URL) {
        Hooks.driver.navigate().to(prop.getProperty(URL));

    }

    //*****************************************wait element to be visible *************************************************//
    public static void waitVisible(By element) {
        new WebDriverWait(Hooks.driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    //*****************************************wait element to load *************************************************//
    public static void implicitwait() {
        Hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    //*****************************************wait for alert***********************************************************//
    public static void waitAlert(By element) {
//        new WebDriverWait(Hooks.driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
//        Hooks.driver.switchTo().alert().getText();
        Hooks.driver.switchTo().frame(0);
//        Hooks.driver.switchTo().window();

    }

    // *************************** Single Click ***********************
    public void Click(By element) {
        Hooks.driver.findElement(element).click();
    }

    //		*************************** JavaScript Click ***********************
    public void JsClick(By element) {
        js.executeScript("arguments[0].click()", Hooks.driver.findElement(element));
    }

    //		*************************** Send Keys ***********************
    public void sendKeys(By element, String string) {
        Hooks.driver.findElement(element).sendKeys(string);
    }
    //*********************Generate Random Data*********************************//

    public static String generateRandomUsername() {
        return faker.name().username();
    }
    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }
}

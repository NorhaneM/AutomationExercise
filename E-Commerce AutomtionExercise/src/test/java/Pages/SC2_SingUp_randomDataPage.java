package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import steps_definition.Hooks;

import java.io.IOException;

public class SC2_SingUp_randomDataPage extends driverActions.driverActions {

    public SC2_SingUp_randomDataPage() throws IOException {
    }

    JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

    public void register_link() {
        final By signupLoginLink = By.cssSelector("a[href='/login']");
        waitVisible(signupLoginLink);
        Hooks.driver.findElement(signupLoginLink).click();
        WebElement element2 = Hooks.driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        // Assert that the text appears
        Assert.assertTrue(element2.isDisplayed(), "Text 'New User Signup!' is not displayed");
        // Print information after the assertion
        System.out.println("Assertion passed! The text 'New User Signup!' is displayed.");
    }

    public WebElement selectContinue() throws InterruptedException {
        By continueButton = By.cssSelector("[data-qa='continue-button']");
        Thread.sleep(200);
        js.executeScript("window.scrollBy(0, 500);");
        waitclickable(continueButton);
        WebElement selectContinue = Hooks.driver.findElement(continueButton);
        return selectContinue;
    }

    public WebElement logout() {
        By logoutLink = By.cssSelector("a[href='/logout']");
        js.executeScript("window.scrollBy(0, 500);");
        waitclickable(logoutLink);
        WebElement logout = Hooks.driver.findElement(logoutLink);
        return logout ;
    }
}

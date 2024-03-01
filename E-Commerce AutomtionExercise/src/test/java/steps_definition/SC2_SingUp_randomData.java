package steps_definition;

import Pages.SC1_addToCart_SingUpPage;
import Pages.SC2_SingUp_randomDataPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.io.IOException;


public class SC2_SingUp_randomData extends SC1_addToCart_SingUpPage {
    public SC2_SingUp_randomData() throws IOException {
        super();
    }

    SC2_SingUp_randomDataPage signUpRandom = new SC2_SingUp_randomDataPage();
    SC1_addToCart_SingUpPage signUp = new SC1_addToCart_SingUpPage();
    JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

    @Given("user navigate to URL home page")
    public void navigate_home() {
        System.out.println("Navigating to the home page...");
        // Navigate to the URL
        navigateTo("URL");
        // Get the current URL
        String currentUrl = Hooks.driver.getCurrentUrl();
        // Print current URL to console
        System.out.println("Current URL: " + currentUrl);
        // Assert on the current URL
        Assert.assertEquals(currentUrl, "https://automationexercise.com/", "URL doesn't match");
        // Print information after the assertion
        System.out.println("Assertion passed! Current URL is: " + currentUrl);
    }

    @And("user signUp and register with Random test data")
    public void register_link() {
        signUpRandom.register_link();
        signUp.randomData();
        signUp.signUp().click();
        signUp.select_Gender();
        signUp.password_create();
        signUp.selectDay();
        signUp.selectMonth();
        signUp.selectYear();
        signUp.sendFirstName();
        signUp.sendLastName();
        signUp.sendAddress();
        signUp.selectCountry();
        signUp.sendState();
        signUp.sendCity();
        signUp.sendZipCode();
        signUp.sendMobileNumber();
    }

    @And("user signUp successfully with Random data {string}")
    public void Success(String text) throws InterruptedException {
        signUp.createAccount();
        signUp.verifyAccountCreated(text);
        signUpRandom.selectContinue();
        boolean adsRemoved = false;

        try {
            js.executeScript(
                    "const waitForAds = setInterval(() => {" +
                            "  const elements = document.getElementsByClassName('adsbygoogle adsbygoogle-noablate');" +
                            "  if (elements.length > 0) {" +
                            "    clearInterval(waitForAds);" +
                            "    while (elements.length > 0) elements[0].remove();" +
                            "    adsRemoved = true;" +
                            "  }" +
                            "}, 50);"
            );

            if (adsRemoved) {
                System.out.println("Google Ads have been removed successfully!");
                signUpRandom.selectContinue().click();
            } else {
                System.out.println("There is no Google Ads appear this time.");
                signUpRandom.selectContinue().click();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Perform the following actions only if the assertion has not been executed
            if (!adsRemoved) {
                signUpRandom.selectContinue().click();
            }
        }
    }


    @And("user logout successfully")
    public void logout() {
        signUpRandom.logout().click();
    }

}
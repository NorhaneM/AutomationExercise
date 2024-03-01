package steps_definition;
import Pages.SC1_addToCart_SingUpPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.IOException;


public class SC1_addToCart_SingUp extends SC1_addToCart_SingUpPage{
    public SC1_addToCart_SingUp() throws IOException {
        super();
    }
    SC1_addToCart_SingUpPage signUp = new SC1_addToCart_SingUpPage();
    JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

    @Given("user navigate to home page")
    public void navigate_home()
    {
        // Navigate to the URL
        navigateTo("URL");
        System.out.println("Navigating to the home page...");
        // Get the current URL
        String currentUrl = Hooks.driver.getCurrentUrl();
        // Print current URL to console
        System.out.println("Current URL: " + currentUrl);
        // Assert on the current URL
        Assert.assertEquals(currentUrl, "https://automationexercise.com/", "URL doesn't match");
        // Print information after the assertion
        System.out.println("Assertion passed! Current URL is: " + currentUrl);
    }

    @And("User add 2 items to the cart")
    public void addToCart() {
        System.out.println("Waiting for the presence of Google Ads to remove them if they appear");
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
                signUp.top_Link().click();
            } else {
                System.out.println("There is no Google Ads appear this time.");
                signUp.top_Link().click();
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            // Perform the following actions only if the assertion has not been executed
            if (!adsRemoved) {
                signUp.top_Link().click();
                signUp.addCart_1().click();
                signUp.continueShopping().click();
                signUp.productLink().click();
                // Get the current URL
                String currentUrl = Hooks.driver.getCurrentUrl();
                // Print current URL to console
                System.out.println("Current URL: " + currentUrl);

                // Assert on the current URL
                Assert.assertEquals(currentUrl, "https://automationexercise.com/products", "URL doesn't match");
                // Print information after the assertion
                System.out.println("Assertion passed! Current URL is: " + currentUrl);

                signUp.hoverCartBtn().click();
                signUp.addCart_1().click();
            }
        }
    }


   @And("user click on view cart to proceed checkout")
           public WebElement viewCart() {
           signUp.viewCart().click();
       js.executeScript("window.scrollBy(0, 500);");
       signUp.checkOut().click();
           final By checkOutText= By.xpath("//p[contains(.,'Register / Login account to proceed on checkout.')]");
           waitVisible(checkOutText);
           WebElement element = Hooks.driver.findElement(checkOutText);
           // Assert that the text appears
           Assert.assertTrue(element.isDisplayed(), "Text 'Register / Login account to proceed on checkout.' is not displayed");
           // Print information after the assertion
           System.out.println("Assertion passed! The text 'Register / Login account to proceed on checkout.' is displayed.");
           signUp.register().click();
       return element;
   }

    @And("user add valid name and email to register")
    public void randomData() {
        signUp.randomData();
        signUp.signUp().click();
    }
    @And("user fill all his account details with {string}")
    public void accountDetails( String text) throws InterruptedException {
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
        signUp.createAccount();
        signUp.verifyAccountCreated(text);
        signUp.selectContinue();
        signUp.verifyLoginText();
    }



   @When("user navigate to the cart page and proceed to checkout")
   public WebElement cartPage() {
       signUp.cartPage().click();
       signUp.checkOut().click();
       signUp.placeOrder().click();
       return null;
   }

    @And("user add random data for payment and download the invoice")
    public void paymentData() throws InterruptedException {
        signUp.paymentData();
        final By successAlert= By.xpath("//p[contains(.,'Congratulations! Your order has been confirmed!')]");
        WebElement element = Hooks.driver.findElement(successAlert);
        // Assert that the text appears
        Assert.assertTrue(element.isDisplayed(), "Text 'Congratulations! Your order has been confirmed!");
        // Print information after the assertion
        System.out.println("Assertion passed! The text 'Congratulations! Your order has been confirmed!' is displayed.");
   }
        @Then("user logOut")
    public void logout() {
        signUp.logOut().click();
    }
}


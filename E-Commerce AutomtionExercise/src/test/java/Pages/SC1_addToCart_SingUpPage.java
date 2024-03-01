package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import steps_definition.Hooks;
import java.io.IOException;

public class SC1_addToCart_SingUpPage extends driverActions.driverActions {

    public SC1_addToCart_SingUpPage() throws IOException {
    }
    JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
    public WebElement top_Link() {

        final By FrozenTopLink = By.cssSelector("a[href*='/product_details/13']");
        js.executeScript("window.scrollBy(0,600);");
        WebElement top_Link = Hooks.driver.findElement(FrozenTopLink);
        // Find the element containing the text
        final By FrozenText = By.xpath("//*[contains(text(), 'Frozen Tops For Kids')]");
        waitVisible(FrozenText);
        WebElement element = Hooks.driver.findElement(FrozenText);
        // Create an instance of Actions class
        Actions actions = new Actions(Hooks.driver);
        // Perform mouse hover
        actions.moveToElement(top_Link).perform();
        // Assert that the text appears
        Assert.assertTrue(element.isDisplayed(), "Text 'Frozen Tops For Kids' is not displayed");
        // Print information after the assertion
        System.out.println("Assertion passed! The text 'Frozen Tops For Kids' is displayed.");

        return top_Link;
    }
    public WebElement addCart_1() {
       final By addCartBtn = By.xpath("//button[@type='button'][contains(.,'Add to cart')]");
        waitclickable(addCartBtn);
        WebElement addCart_1 = Hooks.driver.findElement(addCartBtn);
        return addCart_1;
    }
    public WebElement continueShopping() {
        final By continueShop = By.xpath("//*[contains(text(), 'Continue Shopping')]");
        waitclickable(continueShop);
        WebElement continueShopping = Hooks.driver.findElement(continueShop);
        // Find the element containing the text
        final By cartText= By.xpath("//*[contains(text(), 'Your product has been added to cart.')]");
        waitVisible(cartText);
        WebElement element = Hooks.driver.findElement(cartText);
        // Assert that the text appears
        Assert.assertTrue(element.isDisplayed(), "Text 'Your product has been added to cart.' is not displayed");
        // Print information after the assertion
        System.out.println("Assertion passed! The text 'Your product has been added to cart.' is displayed.");
        return continueShopping;
    }
    public WebElement productLink() {
        final By ProductLink = By.xpath("//a[@href='/products']");
        js.executeScript("window.scrollBy(0,-500);");
        waitclickable(ProductLink);
        WebElement productLink = Hooks.driver.findElement(ProductLink);
        return productLink;
    }
    public WebElement hoverCartBtn() {
        js.executeScript("window.scrollBy(0,500);");
        By hoverCartBtn = By.cssSelector("a[href*='/product_details/1']");
        waitVisible(hoverCartBtn);
        // Locate the element to hover over
        WebElement hoverAddCart = Hooks.driver.findElement(hoverCartBtn);
        // Create an instance of Actions class
        Actions actions = new Actions(Hooks.driver);
        // Perform mouse hover
        actions.moveToElement(hoverAddCart).perform();
        return hoverAddCart;
    }
    public WebElement viewCart() {
        final By viewCartLink = By.xpath("//u[contains(.,'View Cart')]");
//        js.executeScript("arguments[0].scrollIntoView(true);", viewCartLink);
        waitclickable(viewCartLink);
        WebElement viewCart = Hooks.driver.findElement(viewCartLink);
        return viewCart;
    }
    public WebElement checkOut() {
        final By checkOutBtn = By.xpath("//a[contains(.,'Proceed To Checkout')]");
        waitclickable(checkOutBtn);
        WebElement checkOut = Hooks.driver.findElement(checkOutBtn);
        return checkOut;
    }
    public WebElement register() {
        final By registerLink= By.xpath("//u[contains(.,'Register / Login')]");
        WebElement register = Hooks.driver.findElement(registerLink);
        return register;

    }
    public void randomData(){
        final By randomName= By.xpath("//input[@data-qa='signup-name']");
        final By randomMail= By.xpath("//input[@data-qa='signup-email']");
        WebElement randName = Hooks.driver.findElement(randomName);
        WebElement randEmail = Hooks.driver.findElement(randomMail);
        // Generate random username and email
        String randomUsername = generateRandomUsername();
        String randomEmail = generateRandomEmail();
        // Fill in the input fields with the generated values
        randName.sendKeys(randomUsername);
        randEmail.sendKeys(randomEmail);
        // Generate random username and email
    }
    public WebElement signUp() {
        final By signUpBtn = By.xpath("//button[@data-qa='signup-button']");
        WebElement signUp = Hooks.driver.findElement(signUpBtn);
        return signUp;
    }

    By genderTitle=By.id("id_gender2");
    By password_crate=By.id("password");
    By dayDropdown=By.id("days");
    By monthDropdown=By.id("months");

    By yearDropdown=By.id("years");

    By checkbox1=By.id("newsletter");
    By checkbox2=By.id("optin");

    By firstName=By.id("first_name");
    By lasttName=By.id("last_name");
    By address1=By.id("address1");
    By country=By.id("country");
    By state=By.id("state");
    By city=By.id("city");
    By zipcode=By.id("zipcode");
    By mobile_number=By.id("mobile_number");
    By createAccountButton=By.xpath("(//button[@class='btn btn-default'])[1]");

    By accountCreatedText=By.xpath("//*[text()='Account Created!']");

    By continueButton=By.cssSelector("[data-qa='continue-button']");

    By verifyLogin=By.xpath("//*[text()=' Logged in as ']");

    public void select_Gender(){
        Hooks.driver.findElement(genderTitle).click();
    }
    public void password_create(){
        js.executeScript("window.scrollBy(0,800);");
        Hooks.driver.findElement(password_crate).sendKeys(faker.internet().password());
    }
    public void selectDay(){
        Select selectDay=new Select(Hooks.driver.findElement(dayDropdown));
        selectDay.selectByIndex(21);
    }
    public void selectMonth(){
        Select selectMonth=new Select(Hooks.driver.findElement(monthDropdown));
        selectMonth.selectByVisibleText("August");
    }
    public void selectYear(){
        Select selectYear=new Select(Hooks.driver.findElement(yearDropdown));
        selectYear.selectByValue("1991");
    }
    public void sendFirstName(){
        Hooks.driver.findElement(firstName).sendKeys(faker.name().firstName());
    }

    public void sendLastName(){
        Hooks.driver.findElement(lasttName).sendKeys(faker.name().lastName());
    }

    public void sendAddress(){
        waitclickable(address1);
        Hooks.driver.findElement(address1).sendKeys(faker.address().streetAddress());
    }
    public void sendState(){
        waitclickable(state);
        Hooks.driver.findElement(state).sendKeys(faker.address().state());
    }

    public void sendCity(){
        js.executeScript("window.scrollBy(0, 500);");
        waitclickable(city);
        Hooks.driver.findElement(city).sendKeys(faker.address().city());
    }

    public void sendZipCode(){
        Hooks.driver.findElement(zipcode).sendKeys(faker.address().zipCode());
    }

    public void sendMobileNumber(){
        Hooks.driver.findElement(mobile_number).sendKeys(faker.phoneNumber().phoneNumber());
    }
    public void selectCountry(){
        Select selectCountry=new Select(Hooks.driver.findElement(country));
        selectCountry.selectByVisibleText("United States");
    }

    public void createAccount(){
        js.executeScript("window.scrollBy(0, 300);");
        waitclickable(createAccountButton);
        Hooks.driver.findElement(createAccountButton).click();
    }
    public void verifyAccountCreated(String text){
        Assert.assertTrue(Hooks.driver.findElement(accountCreatedText).getText().equalsIgnoreCase(text));
        System.out.println("Assertion passed! The Account has been created successfully");
    }
    public void selectContinue() throws InterruptedException {
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, 500);");
        waitclickable(continueButton);
        Hooks.driver.findElement(continueButton).click();
    }
    public void verifyLoginText(){
        Assert.assertTrue(Hooks.driver.findElement(verifyLogin).isDisplayed());
        System.out.println("Assertion passed! The Account has been already logged in");
    }
    public WebElement cartPage() {
        js.executeScript("window.scroll(0, -500);");
        WebElement cartLink = Hooks.driver.findElement(By.linkText("Cart"));
        return cartLink;
    }
    public WebElement placeOrder() {
        js.executeScript("window.scrollBy(0, 800);");
        WebElement placeOrderLink = Hooks.driver.findElement(By.linkText("Place Order"));
        return placeOrderLink;
    }
    public void paymentData() throws InterruptedException {
        final By cardName = By.name("name_on_card");
        final By cardNum = By.name("card_number");
        final By CVC = By.name("cvc");
        final By expiryYear = By.name("expiry_year");
        final By expiryMonth = By.name("expiry_month");
        final By placeBtn =By.id("submit");
        final By download = By.linkText("Download Invoice");
        Hooks.driver.findElement(cardName).sendKeys(faker.name().fullName());
        Hooks.driver.findElement(cardNum).sendKeys(faker.idNumber().valid());
        Hooks.driver.findElement(CVC).sendKeys(faker.number().digits(3));
        Hooks.driver.findElement(expiryMonth).sendKeys(faker.number().digits(2));
        Hooks.driver.findElement(expiryYear).sendKeys(faker.number().digits(4));
        Hooks.driver.findElement(placeBtn).click();
        Hooks.driver.findElement(download).click();
        System.out.println("File downloaded successfully");
    }
     public WebElement logOut() {
        By logoutLink = By.cssSelector("a[href='/logout']");
        js.executeScript("window.scrollBy(0, 500);");
        waitclickable(logoutLink);
        WebElement logOut = Hooks.driver.findElement(logoutLink);
        return logOut ;
    }
}

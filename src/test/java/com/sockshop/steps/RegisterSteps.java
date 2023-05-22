package com.sockshop.steps;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;



public class RegisterSteps {

    private static WebDriver driver;
    static ConfigFile cf = new ConfigFile();
    static String baseURL = cf.getBaseURL();
    String driverPath = cf.getDriverPath();


    public static int randomPortGenerator() {

        int min = 10000;
        int max = 60000;
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    //loading website with selenium driver

    @Given("I am on the home page")
    public void navigateToHomePage() {
        //for multiple instances of testing
        int portNumber = randomPortGenerator();
        ConfigFile.Timer(5000);

        System.setProperty("webdriver.chrome.driver", this.driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=" + portNumber);
        driver = new ChromeDriver(options);
        driver.get(baseURL);
    }

    @When("I enter my user details")
    public void enterUserDetails() throws InterruptedException {
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement registerLink2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu #register")));
        WebElement registerLink = driver.findElement(By.cssSelector(".menu #register"));
        registerLink.click();

        ConfigFile.Timer(5000);
        WebElement username = driver.findElement(By.cssSelector("#register-username-modal"));
        String userName = "srikanthtest"+String.valueOf(randomPortGenerator());
        username.sendKeys(userName);

        ConfigFile.Timer(2000);
        WebElement firstName = driver.findElement(By.cssSelector("#register-first-modal"));
        firstName.sendKeys("srikanth");

        ConfigFile.Timer(2000);
        WebElement lastName = driver.findElement(By.cssSelector("#register-last-modal"));
        lastName.sendKeys("pula");

        ConfigFile.Timer(2000);
        WebElement email = driver.findElement(By.cssSelector("#register-email-modal"));
        email.sendKeys("srikanth"+String.valueOf(randomPortGenerator()) +"@test.com");

        ConfigFile.Timer(2000);
        WebElement password = driver.findElement(By.cssSelector("#register-password-modal"));
        password.sendKeys("Srikanth");
    }

    @When("I click the register button")
    public void clickRegisterButton()  {
        ConfigFile.Timer(5000);
        WebElement registerButton = driver.findElement(By.cssSelector("#register-modal .btn.btn-primary"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", registerButton);

    }

    @Then("I should be logged in with my username")
    public void i_should_be_logged_in_with_my_username() {
        ConfigFile.Timer(5000);
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @After
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}


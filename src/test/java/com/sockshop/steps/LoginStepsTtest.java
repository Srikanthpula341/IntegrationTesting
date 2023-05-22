package com.sockshop.steps;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;



public class LoginStepsTtest {

    private static WebDriver driver;
    static ConfigFile cf = new ConfigFile();
    static String baseURL = cf.getBaseURL();
    String driverPath = cf.getDriverPath();

    @Given("I am on the login page")
    public void navigateToLoginPage() {
        int portNumber = 24424;
        String baseURL = cf.getBaseURL();
        String driverPath = cf.getDriverPath();
        // Specify the actual path to ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", this.driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=" + portNumber);
        driver = new ChromeDriver(options);
        driver.get(baseURL);
    }

    @When("I enter random username and password")
    public void enterUsernameAndPassword()  {
        ConfigFile.Timer(3000);
        WebElement loginLink = driver.findElement(By.cssSelector("a[href='#'][data-target='#login-modal']"));
        System.out.println(driver.findElement(By.cssSelector("a[href='#'][data-target='#login-modal']")));
        loginLink.click();

        ConfigFile.Timer(3000);
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.sendKeys("Srikanfgjf");
        ConfigFile.Timer(3000);

        passwordField.sendKeys("@456789fr");
    }

    @When("I click the login button")
    public void clickLoginButton() {
        ConfigFile.Timer(3000);
        WebElement loginButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", loginButton);
    }

    @Then("I should be taken to the home page and say error")
    public void verifyHomePageAndShowError() {
        ConfigFile.Timer(3000);
        WebElement errorMessage = driver.findElement(By.cssSelector(".alert.alert-danger"));
        String actualErrorMessage = errorMessage.getText();
        String expectedErrorMessage = "Invalid login credentials.";

        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }

    @After
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}



package com.sockshop.steps;


import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CartSteps {

    private static WebDriver driver;
    private static ConfigFile cf = new ConfigFile();
    static String baseURL = cf.getBaseURL();
    String driverPath = cf.getDriverPath();

    @Given("I am on the initial page")
    public void i_am_on_the_initial_page() {
        int portNumber = ConfigFile.randomPortGenerator();
        System.setProperty("webdriver.chrome.driver", this.driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-debugging-port=" + portNumber);
        driver = new ChromeDriver(options);
        driver.get(baseURL);
        ConfigFile.Timer(3000);
    }

    @When("I select the item for details")
    public void i_select_the_item_for_details()  {
        ConfigFile.Timer(3000);
        WebElement item = driver.findElement(By.cssSelector("div.product h3 a"));

        item.click();
        ConfigFile.Timer(3000);

    }

    @When("I click the add to cart")
    public void i_click_the_add_to_cart(){
        ConfigFile.Timer(3000);
        WebElement addCart = driver.findElement(By.cssSelector("#buttonCart"));
        ConfigFile.Timer(3000);
        addCart.click();

    }

    @Then("I should be go to cart to check item")
    public void i_should_be_go_to_cart_to_check_item() throws InterruptedException {
        ConfigFile.Timer(3000);
        WebElement cartButton = driver.findElement(By.cssSelector("div#basket-overview a.btn.btn-primary"));
        cartButton.click();

        ConfigFile.Timer(3000);
        WebElement cartTotal = driver.findElement(By.cssSelector("#cartTotal"));
        System.out.println(cartTotal.getText());
        String cartTotalValue = cartTotal.getText();
        double cartValue = Double.parseDouble(cartTotalValue.substring(1));
        Assert.assertTrue("Cart total should be greater than zero", cartValue > 0);
    }

    @After
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}


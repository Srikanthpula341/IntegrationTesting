package com.sockshop;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:feature/",
        glue = "com.sockshop.steps",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
@SpringBootTest
public class IntegrationTestingApplicationTests {

    @Configuration
    @EnableAutoConfiguration(exclude = RestTemplateAutoConfiguration.class)
    public static class TestConfig {
        // Define your test configuration or leave it empty
    }


}
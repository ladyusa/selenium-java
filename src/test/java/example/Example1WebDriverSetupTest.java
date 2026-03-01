package example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example1WebDriverSetupTest {

    @Test
    void testChromeGoogle() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.co.th/");
        assertTrue(driver.getTitle().startsWith("Google"));

        driver.quit();
    }

    @Test
    void testFirefoxGoogle() {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.co.th/");
        assertTrue(driver.getTitle().startsWith("Google"));

        driver.quit();
    }
}
package example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Example3MultipleGoogleTest {

    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("https://www.google.co.th/");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    void testGoogleTitle() {
        assertTrue(driver.getTitle().startsWith("Google"));
    }

    @Test
    void testSearchGoogle() {
        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        searchButton.click();

        searchBox = driver.findElement(By.name("q"));
        assertEquals("Selenium", searchBox.getAttribute("value"));
    }
}
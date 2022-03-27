package book;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTest {
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    void testBookHeading() {
        driver.get("http://localhost:8080/");
        WebElement heading = driver.findElement(By.tagName("h1"));
        assertEquals("Welcome to Wisdom Book Website", heading.getText());
    }

    @Test
    void testAddBook() {
        driver.get("http://localhost:8080/book/add");

        WebElement nameField = driver.findElement(By.id("nameInput"));
        WebElement authorField = driver.findElement(By.id("authorInput"));
        WebElement priceField = driver.findElement(By.id("priceInput"));
        nameField.sendKeys("Clean Code");
        authorField.sendKeys("Robert Martin");
        priceField.sendKeys("600");

        WebElement submitButton = driver.findElement(By.className("btn"));
        submitButton.click();

        WebElement name = driver
                .findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
        WebElement author = driver
                .findElement(By.xpath("//table/tbody/tr[1]/td[2]"));
        WebElement price = driver
                .findElement(By.xpath("//table/tbody/tr[1]/td[3]"));

        assertEquals("Clean Code", name.getText());
        assertEquals("Robert Martin", author.getText());
        assertEquals("600.00", price.getText());
    }
}

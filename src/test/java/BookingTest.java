import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingTest {

    private RemoteWebDriver driver;

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    void bookingTest() {
        this.driver.get("http://localhost:3000/bookings");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        // select movie
        this.driver.findElement(
                By.cssSelector("#root > div > form > div > select:nth-child(2)"))
                .click();
        this.driver.findElement(
                By.cssSelector("#root > div > form > div > select:nth-child(2) > option:nth-child(5)"))
                .click();
        this.driver.findElement(
                By.cssSelector("#root > div > form > div > select:nth-child(5)"))
                .click();
        this.driver.findElement(
                By.cssSelector("#root > div > form > div > select:nth-child(5) > option:nth-child(5)"))
                .click();
        this.driver.findElement(
                By.cssSelector("#root > div > form > div > select:nth-child(8)"))
                .click();
        this.driver.findElement(
                By.cssSelector("#root > div > form > div > select:nth-child(8) > option:nth-child(3)"))
                .click();
        this.driver.findElement(
                By.cssSelector("#seats"))
                .click();
        this.driver.findElement(
                        By.cssSelector("#seats"))
                .sendKeys("5");
    }

    @AfterEach
    void tearDown() {
        this.driver.close();
    }
}

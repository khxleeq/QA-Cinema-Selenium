import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutTest {

    private RemoteWebDriver driver;

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    void checkoutTest() {
        this.driver.get("http://localhost:3000/bookings");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(200));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("#root > div > form > div > select:nth-child(2)")
                ));

        this.driver.findElement(
                By.cssSelector("#root > div > form > div > select:nth-child(2)")).toString();

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
        this.driver.findElement(
                By.cssSelector("#root > div > form > div > select:nth-child(16)"))
                .click();
        this.driver.findElement(
                By.cssSelector("#root > div > form > div > select:nth-child(16) > option:nth-child(2)"))
                .click();
        this.driver.findElement(
                By.cssSelector("#bookerName"))
                .sendKeys("Selenium Testing");
        this.driver.findElement(
                By.cssSelector("#root > div > form > div > button"))
                .click();
        this.driver.findElement(
                By.cssSelector("#root > div > div.checkout > button"))
                .click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("#email")));

        this.driver.findElement(
                By.cssSelector("#email"))
                .sendKeys("test@selenium.com");
        this.driver.findElement(
                By.cssSelector("#cardNumber"))
                .sendKeys("4242424242424242");
        this.driver.findElement(
                By.cssSelector("#cardExpiry"))
                .sendKeys("0123");
        this.driver.findElement(
                By.cssSelector("#cardCvc"))
                .sendKeys("123");
        this.driver.findElement(
                By.cssSelector("#billingName"))
                .sendKeys("Sel Test");
        this.driver.findElement(
                By.cssSelector("#billingPostalCode"))
                .sendKeys("Ab12CD");
        this.driver.findElement(
                By.cssSelector("#root > div > div > div.App-Payment > div" +
                        " > div.PaymentFormFixedHeightContainer.flex-container.direction-column" +
                        " > form > div.PaymentForm-confirmPaymentContainer.mt4.flex-item.width-grow " +
                        "> div:nth-child(2) > button"))
                .click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root > div > h1")));

        String expectedUrl = "http://localhost:3000/success";
        assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @AfterEach
    void tearDown() {
        this.driver.close();
    }
}

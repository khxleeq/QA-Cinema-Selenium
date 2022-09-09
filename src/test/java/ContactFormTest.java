import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactFormTest {
    private RemoteWebDriver driver;


    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();

        driver.manage().window().maximize();
        // opens a new window
    }

    @Test
    void demoTest() {
        this.driver.get("http://localhost:3000/"); // goes to the page
        //driver.get("http://automationpractice.com/index.php");


        WebElement contactUs = driver.findElement(By.cssSelector("#root > div > footer > ul > li:nth-child(3) > a"));
        contactUs.click();


        WebElement name = driver.findElement(By.cssSelector("#root > div > div:nth-child(8) > div > div > form > input:nth-child(1)"));
        String nameValue = "TestName";
        name.sendKeys(nameValue);

        WebElement email = driver.findElement(By.cssSelector("#root > div > div:nth-child(8) > div > div > form > input:nth-child(2)"));
        String address = "test@email.com";
        email.sendKeys(address);

        WebElement subject = driver.findElement(By.cssSelector("#root > div > div:nth-child(8) > div > div > form > input:nth-child(3)"));
        String subjectInput = "MovieSubject";
        subject.sendKeys(subjectInput);

        WebElement message = driver.findElement(By.cssSelector("#root > div > div:nth-child(8) > div > div > form > textarea"));
        String msg = "Message";
        message.sendKeys(msg);

        WebElement sendMsg = driver.findElement(By.cssSelector("#root > div > div:nth-child(8) > div > div > form > button"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click;", sendMsg);

        assertEquals("TestName",
                this.driver.findElement(By.cssSelector("#root > div > div:nth-child(8) > div > div > form > input:nth-child(1)")).getAttribute("value"));
        assertEquals("test@email.com",
                this.driver.findElement(By.cssSelector("#root > div > div:nth-child(8) > div > div > form > input:nth-child(2)")).getAttribute("value"));
        assertEquals("MovieSubject",
                this.driver.findElement(By.cssSelector("#root > div > div:nth-child(8) > div > div > form > input:nth-child(3)")).getAttribute("value"));
        assertEquals("Message",
                this.driver.findElement(By.cssSelector("#root > div > div:nth-child(8) > div > div > form > textarea")).getAttribute("value"));
    }


    @AfterEach
    void tearDown() {
        this.driver.close();
    }
}

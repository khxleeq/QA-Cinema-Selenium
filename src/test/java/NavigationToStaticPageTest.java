import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavigationToStaticPageTest {

    private RemoteWebDriver driver;

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    void testOpeningTimes() {
        this.driver.get("http://localhost:3000/");

        WebElement dropDownMenu = this.driver.findElement(By.cssSelector("#basic-nav-dropdown"));
        dropDownMenu.click();

        WebElement openingTimesBtn = this.driver.findElement(By.cssSelector("#basic-navbar-nav > div > div > div > a:nth-child(1)"));
        openingTimesBtn.click();

        WebElement titleResult = this.driver.findElement(By.cssSelector("#root > div > div > h1"));
        assertEquals("Opening Times", titleResult.getText());
    }

    @Test
    void testClassification() {
        this.driver.get("http://localhost:3000/");

        WebElement dropDownMenu = this.driver.findElement(By.cssSelector("#basic-nav-dropdown"));
        dropDownMenu.click();

        WebElement classificationBtn = this.driver.findElement(By.cssSelector("#basic-navbar-nav > div > div > div > a:nth-child(3)"));
        classificationBtn.click();

        WebElement titleResult = this.driver.findElement(By.cssSelector("#classification-page > h1"));
        assertEquals("Classification", titleResult.getText());
    }

    @Test
    void testScreens() {
        this.driver.get("http://localhost:3000/");

        WebElement dropDownMenu = this.driver.findElement(By.cssSelector("#basic-nav-dropdown"));
        dropDownMenu.click();

        WebElement screensBtn = this.driver.findElement(By.cssSelector("#basic-navbar-nav > div > div > div > a:nth-child(4)"));
        screensBtn.click();

        WebElement titleResult = this.driver.findElement(By.cssSelector("#screens-page > div:nth-child(1) > h1"));
        assertEquals("Screens", titleResult.getText());
    }

    @Test
    void testAbout() {
        this.driver.get("http://localhost:3000/");

        WebElement dropDownMenu = this.driver.findElement(By.cssSelector("#basic-nav-dropdown"));
        dropDownMenu.click();

        WebElement aboutBtn = this.driver.findElement(By.cssSelector("#basic-navbar-nav > div > div > div > a:nth-child(5)"));
        aboutBtn.click();

        WebElement titleResult = this.driver.findElement(By.cssSelector("#root > div > div > h1"));
        assertEquals("About QA Cinemas", titleResult.getText());
    }

    @Test
    void testContact() {
        this.driver.get("http://localhost:3000/");

        WebElement dropDownMenu = this.driver.findElement(By.cssSelector("#basic-nav-dropdown"));
        dropDownMenu.click();

        WebElement contactUsBtn = this.driver.findElement(By.cssSelector("#basic-navbar-nav > div > div > div > a:nth-child(7)"));
        contactUsBtn.click();

        WebElement titleResult = this.driver.findElement(By.cssSelector("#root > div > h1"));
        assertEquals("Contact", titleResult.getText());
    }


    @AfterEach
    void tearDown() {this.driver.close(); }
}

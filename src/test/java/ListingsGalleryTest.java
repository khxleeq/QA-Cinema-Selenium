import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListingsGalleryTest {
    private RemoteWebDriver driver;

    @BeforeEach
    void setup() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void movieListingTest() {
        this.driver.get("http://localhost:3000/CurrentMovieList"); //goes to the web page
        this.driver.findElement(By.cssSelector("#root > div > div > div.filter-container > button:nth-child(2)")).click();
        this.driver.findElement(By.cssSelector("#root > div > div > div.movie-container > a:nth-child(1) > div > img")).click();
        WebElement result = driver.findElement(By.cssSelector("#root > div > div > div > div.box > div > h2"));
        assertEquals("TOP GUN: MAVERICK (2022)", result.getText());
    }

    @AfterEach
    void tearDown() {
        this.driver.close();
    }
}




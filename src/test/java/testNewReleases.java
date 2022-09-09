package qa.cinemas;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


public class testNewReleases {
	
	private RemoteWebDriver driver;
	
	@BeforeEach
	void setup() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // forces execution of test stages to wait for 20 seconds 
		
	}
	
	@Test
	void TestNewReleases() {
		this.driver.get("http://localhost:3000/CurrentMovieList");
		
		this.driver.findElement(By.cssSelector
				("#basic-navbar-nav > div > a:nth-child(4)")).click(); // finds New Releases in Nav Bar and clicks to access page
		
		this.driver.findElement(By.cssSelector
				("#root > div > div > div > a:nth-child(1)")).click(); // finds and clicks on the first movie container
		
		
	}
	
	@AfterEach
	void tearDown() {
//		this.driver.close();
		
	}

}
	



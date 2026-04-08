package tests;

	import org.openqa.selenium.*;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Excelutil;

	public class LoginTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/login"); // replace with real URL
	}

	@Test(dataProvider = "loginData")
	public void loginTest(String username, String password) {

	driver.findElement(By.id("username")).sendKeys(username);
	driver.findElement(By.id("password")).sendKeys(password);
	driver.findElement(By.cssSelector("button[type='submit']")).click();

	System.out.println("Testing with: " + username);
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() {
	return Excelutil.getData("testdata/testdata.xlsx", "Sheet1");
	}

	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	}


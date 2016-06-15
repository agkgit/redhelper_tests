import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.testng.AssertJUnit.fail;

public class TestRCInvalidNumbers {

	WebDriver driver;

	@Before
	public  void beforeTest() {
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.private.browsing.autostart",true);
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.get("http://www.vernee.ru/qa");
	}

	@Test
	public void setUnvalidNumber() throws InterruptedException {


//        WebElement rcFrameNumber = driver.findElement(By.className("rc-connector-frame"));
//        driver.switchTo().frame(rcFrameNumber);
//        WebElement numberArea = driver.findElement(By.id("rc-phone-input"));
//        driver.switchTo().defaultContent();
//        WebElement button = driver.findElement(By.id("rc-phone-button"));
//        int i = 1;

		for (String number : TestSettings.numbers) {

			driver.navigate().refresh();
			WebElement rcFrameNumber = driver.findElement(By.className("rc-connector-frame"));
			driver.switchTo().frame(rcFrameNumber);
			driver.findElement(By.id("rc-phone-input")).clear();
			driver.findElement(By.id("rc-phone-input")).sendKeys(number);
			driver.switchTo().defaultContent();

			driver.findElement(By.id("rc-phone-button")).click();
			button.click();

			try {
				WebElement warningElement = (new WebDriverWait(driver, 1))
						.until(ExpectedConditions.presenceOfElementLocated(By.id("rc-phone-input-warning")));
			} catch (TimeoutException e) {
				fail("Не появилось предупреждение");
			}
		}

	}
}

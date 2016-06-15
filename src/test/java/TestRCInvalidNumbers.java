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

	@Test
	public void setUnvalidNumber() throws InterruptedException {

//		PageWithRCWidget pageWithRCWidget = new PageWithRCWidget();
//		pageWithRCWidget.openSite("http://vernee.ru/qa");
//		pageWithRCWidget.clickWidgetButton();
//		pageWithRCWidget.inputNumber("79999864875");
//		pageWithRCWidget.clickThePhoneButton();

		WebDriver driver = new FirefoxDriver();
        driver.get("http://www.vernee.ru/qa");
        driver.findElement(By.id("rc-phone")).click();
	}
}

//		for (String number : TestSettings.numbers) {
//
//			WebElement rcFrameNumber = driver.findElement(By.className("rc-connector-frame"));
//			driver.switchTo().frame(rcFrameNumber);
//			driver.findElement(By.id("rc-phone-input")).clear();
//			driver.findElement(By.id("rc-phone-input")).sendKeys(number);
//			driver.switchTo().defaultContent();
//
//			driver.findElement(By.id("rc-phone-button")).click();
//			button.click();
//
//			try {
//				WebElement warningElement = (new WebDriverWait(driver, 1))
//						.until(ExpectedConditions.presenceOfElementLocated(By.id("rc-phone-input-warning")));
//			} catch (TimeoutException e) {
//				fail("Не появилось предупреждение");
//			}
//		}
//	}
//}

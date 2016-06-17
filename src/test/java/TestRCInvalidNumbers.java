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
		PageWithRCWidget pageWithRCWidget = new PageWithRCWidget();
		pageWithRCWidget.openSite("http://vernee.ru/qa");

		for (String number : TestSettings.numbers) {
			pageWithRCWidget.reload();
			pageWithRCWidget.clickWidgetButton();
			pageWithRCWidget.inputNumber(number);
			pageWithRCWidget.clickThePhoneButton();
			pageWithRCWidget.waitWarningInvalidNumber();
		}

		pageWithRCWidget.close();
	}
}

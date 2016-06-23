import org.openqa.selenium.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.fail;

public class RCWidgetPage extends TestPage {

	//элементы виджета на тестируемой странице
	By rc_phone = By.id("rc-phone");
	By rc_connector_frame = By.className("rc-connector-frame");
	By rc_phone_input = By.id("rc-phone-input");
	By rc_phone_button = By.id("rc-phone-button");
	By rc_phone_input_warning = By.id("rc-phone-input-warning");

	//открытие виджета
	public void clickWidgetButton() {
		try {
			WebElement byWidgetButton = (new WebDriverWait(driver, 1))
					.until(ExpectedConditions.presenceOfElementLocated(rc_phone));
		} catch (TimeoutException e) {
			fail("Виджет недоступен");
		}
		driver.findElement(rc_phone).click();
	}

	//ввод номера
	public void inputNumber(String number) {
		try {
			WebElement byWidgetButton = (new WebDriverWait(driver, 1))
					.until(ExpectedConditions.presenceOfElementLocated(rc_connector_frame));
		} catch (TimeoutException e) {
			fail("rc_connector_frame недоступен");
		}
		driver.switchTo().frame(driver.findElement(rc_connector_frame));

		try {
			WebElement byWidgetButton = (new WebDriverWait(driver, 1))
					.until(ExpectedConditions.presenceOfElementLocated(rc_phone_input));
		} catch (TimeoutException e) {
			fail("rc_phone_input недоступен");
		}
		WebElement rcPhoneInput = driver.findElement(rc_phone_input);

		rcPhoneInput.clear();
		rcPhoneInput.sendKeys(number);
		driver.switchTo().defaultContent();
	}

	//нажатие кнопки "Позвонить"
	public void clickThePhoneButton() {

		try {
			WebElement byWidgetButton = (new WebDriverWait(driver, 1))
				.until(ExpectedConditions.presenceOfElementLocated(rc_phone_button));
	} catch (TimeoutException e) {
		fail("rc_connector_frame недоступен");
	}

		driver.findElement(rc_phone_button).click();
	}

	//ожидание появления предупреждения 'Внимание! Проверьте правильность набранного номера'
	public void waitWarningInvalidNumber() {
		String failText = "не появилось предупреждение 'Внимание! Проверьте правильность набранного номера'";
		this.waitWithFailText(rc_phone_input_warning, failText);
	}

	//ожидания при состоявшемся звонке
	public void waitPhoneDialElements() {

		this.wait(By.id("rc-phone-dial"));
		this.wait(By.id("rc-phone-dial-snake"));
		this.wait(By.id("rc-phone-dial-snake-curtain"));
		this.wait(By.id("rc-phone-dial-snake-curtain2"));
		this.wait(By.id("rc-phone-dial-half-circle"));
		this.wait(By.id("rc-phone-dial-circle"));

	}

}
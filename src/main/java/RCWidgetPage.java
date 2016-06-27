import org.openqa.selenium.*;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

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
		this.wait(rc_phone);
		driver.findElement(rc_phone).click();
	}

	//ввод номера
	public void inputNumber(String number) {
		this.wait(rc_connector_frame);
		driver.switchTo().frame(driver.findElement(rc_connector_frame));

		this.wait(rc_phone_input);
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
		System.out.println("rc-phone-dial is visible\t" + new Date(System.currentTimeMillis()));					//del
		this.wait(By.id("rc-phone-dial-snake"));
		System.out.println("rc-phone-dial-snake is visible\t" + new Date(System.currentTimeMillis()));				//del
		this.wait(By.id("rc-phone-dial-snake-curtain"));
		System.out.println("rc-phone-dial-snake-curtain is visible\t" + new Date(System.currentTimeMillis()));		//del
		this.wait(By.id("rc-phone-dial-snake-curtain2"));
		System.out.println("rc-phone-dial-snake-curtain2 is visible\t" + new Date(System.currentTimeMillis()));		//del
		this.wait(By.id("rc-phone-dial-half-circle"));
		System.out.println("rc-phone-dial-half-circle\t" + new Date(System.currentTimeMillis()));					//del
		this.wait(By.id("rc-phone-dial-circle"));
		System.out.println("rc-phone-dial-circle\t" + new Date(System.currentTimeMillis()));						//del
	}

}
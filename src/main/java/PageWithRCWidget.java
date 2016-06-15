import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class PageWithRCWidget {

	public WebDriver driver;

	//элементы виджета на тестируемой странице
	By rc_phone = By.id("rc-phone");
	By rc_connector_frame = By.className("rc-connector-frame");
	By rc_phone_input = By.id("rc-phone-input");
	By rc_phone_button = By.id("rc-phone-button");
	By rc_phone_input_warning = By.id("rc-phone-input-warning");

	//конструкторы
	PageWithRCWidget(){
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.private.browsing.autostart", true);
		this.driver = new FirefoxDriver(firefoxProfile);
	};

	PageWithRCWidget(WebDriver driver){
		this.driver = driver;
	}

	//открытие виджета
	public void clickWidgetButton() {
		driver.findElement(rc_phone).click();
	}

	//обновление страницы
	public void refresh() {
		driver.navigate().refresh();
	}

	//ввод номера
	public void inputNumber(String number) {
		driver.switchTo().frame(driver.findElement(rc_connector_frame));
		WebElement rcPhoneInput = driver.findElement(rc_phone_input);
		rcPhoneInput.clear();
		rcPhoneInput.sendKeys(number);
		driver.switchTo().defaultContent();
	}

	//нажатие кнопки "Позвонить"
	public void clickThePhoneButton() {
		driver.findElement(rc_phone_button).click();
	}

}

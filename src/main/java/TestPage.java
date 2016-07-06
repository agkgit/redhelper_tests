import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class TestPage {

	WebDriver driver;

	//конструкторы
	TestPage(){
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.private.browsing.autostart", true);
		this.driver = new FirefoxDriver();

		this.manage();

	};
	TestPage(WebDriver driver){
		this.driver = driver;
	}
	TestPage(BrowsersEnum browser){
		switch (browser) {
			case GOOGLE_CHROME:		this.driver = new ChromeDriver();									break;
			case OPERA:				this.driver = new OperaDriver();									break;
			case MS_EDGE:			this.driver = new EdgeDriver();										break;
			case PHANTOMJS:			this.driver = new PhantomJSDriver(new DesiredCapabilities());		break;
			case APPLE_SAFARI:		break;
			case MOZILLA_FIREFOX:	break;
			default:
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setPreference("browser.private.browsing.autostart", true);
				this.driver = new FirefoxDriver();
		}

		this.manage();

	}

	public void manage(int implicitlyWait, int pageLoadTimeout) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	public void manage() {
		this.manage(0, 0);
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	@Step("открытие тестируемого сайта с виджетом RC")
	public void openSite(String url) {
		this.driver.get(url);
	}

	@Step("обновление страницы")
	public void reload() {
		driver.navigate().refresh();
	}

	@Step("закрытие страницы")
	public void close() {
		driver.close();
	}



//Ожидания элементов-----------------------------------------------------------------------------------
	@Step("ожидание элемента")
	public void wait(By byElement, int seconds, String failText) {
		try {
			(new WebDriverWait(driver, seconds)).until(ExpectedConditions.visibilityOf(driver.findElement(byElement)));
		} catch (TimeoutException e) {
			fail(failText);
		} catch (NoSuchElementException e) {
			fail(failText);
		}
	}
	@Step("ожидание элемента")
	public void wait(By byElement, String failText) {
		this.wait(byElement, 10, failText);
	}
	@Step("ожидание элемента")
	public void wait(By byElement, int seconds) {
		this.wait(byElement, seconds, "элемент не найден");
	}
	@Step("ожидание элемента")
	public void wait(By byElement) {
		this.wait(byElement, 10, "элемент не найден");
	}
//-----------------------------------------------------------------------------------------------------

}
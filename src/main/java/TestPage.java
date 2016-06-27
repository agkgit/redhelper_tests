import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class TestPage {

	enum BrowsersEnum { GOOGLE_CHROME, MOZILLA_FIREFOX, OPERA, MS_EDGE, APPLE_SAFARI, PHANTOMJS }

	WebDriver driver;

	//конструкторы
	TestPage(){
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.private.browsing.autostart", true);
		this.driver = new FirefoxDriver();
	};
	TestPage(WebDriver driver){
		this.driver = driver;
	}
	TestPage(BrowsersEnum browser){
		switch (browser) {
			case GOOGLE_CHROME:		this.driver = new ChromeDriver(); break;
			case OPERA:				this.driver = new OperaDriver(); break;
			case MS_EDGE:			this.driver = new EdgeDriver(); break;
			case APPLE_SAFARI:		break;
			case PHANTOMJS:			break;
			case MOZILLA_FIREFOX:	break;
			default:
				FirefoxProfile firefoxProfile = new FirefoxProfile();
				firefoxProfile.setPreference("browser.private.browsing.autostart", true);
				this.driver = new FirefoxDriver();
		}
	}

	public WebDriver getDriver() {
		return this.driver;
	}

	//открытие тестируемого сайта с виджетом RC
	public void openSite(String url) {
		this.driver.get(url);
	}

	//обновление страницы
	public void reload() {
		driver.navigate().refresh();
	}

	//закрытие страницы
	public void close() {
		driver.close();
	}

	//ожидание элемента
	public void wait(By byElement) {
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(byElement)));
		} catch (TimeoutException e) {
			fail("элемент недоступен");
		}
	}
	public void waitWithFailText(By byElement, String failText) {
		try {
			(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(driver.findElement(byElement)));
		} catch (TimeoutException e) {
			fail(failText);
		}
	}

}
import com.sun.deploy.Environment;
import com.sun.deploy.security.ruleset.DRSHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.OutputStream;
import java.io.FileOutputStream;

import java.lang.String;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.testng.Assert.fail;



public class My extends TestPage {

	public static final String MY_URL = "http://test.redhelper.ru/my/redconnect";

	// константы типа By
	public final By BY_DELETE_PHONE;
	public final By BY_DO_DELETE_PHONE_YES;
	public final By BY_ADD_NUMBER;
	public final By BY_NUMBER_IMPUT;
	public final By BY_ADD_WORK_TIME;
	public final By BY_START_WORK_TIME;
	public final By BY_STOP_WORK_TIME;
	public final By BY_SAVE_SETTINGS;
	public final By BY_REDCONNECT_MENU;
	public final By BY_BUSINESS_TARIFF;
	public final By BY_FREE_TARIFF;

	RCEnvironment rcEnvironment;
	String login, password;
	String urlMy;
	FileOutputStream output = null;

	public My(RCEnvironment rcEnvironment, WebDriver driver) {
		FileOutputStream output;
		super(driver);
		this.rcEnvironment = rcEnvironment;
		this.output = new FileOutputStream("C:/Users/QA/Desktop/projects/redhelper_tests/src/main/javaconfig.properties");

		BY_DELETE_PHONE = By.xpath(".//a[@ng-click-outside='cancelDeletePhone(phone)']");
		BY_DO_DELETE_PHONE_YES = By.xpath(".//button[@ng-click='doDeletePhone(phone)']");
		BY_ADD_NUMBER = By.cssSelector("div.rc-new-item:nth-child(3) > span:nth-child(2)");
		BY_REDCONNECT_MENU = By.xpath("//*[@id=\"a-redconnect\"]");
		BY_BUSINESS_TARIFF = By.xpath(".//div[@class='rc-mode-name' and contains(.,'Business')]");
		BY_FREE_TARIFF = By.xpath(".//div[@class='rc-mode-name' and contains(.,'Business')]");

		if (this.rcEnvironment == RCEnvironment.TEST) {
			this.urlMy = TestSettings.urlTestMy;
			this.login = TestSettings.rcLoginTest;
			this.password = TestSettings.rcPassTest;

			BY_NUMBER_IMPUT =		By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[1]/div[1]/div[1]/div/input[1]");
			BY_ADD_WORK_TIME =		By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[2]/a[1]");
			BY_START_WORK_TIME =	By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[4]/div[2]/input[1]");
			BY_STOP_WORK_TIME =		By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[4]/div[2]/input[2]");
			BY_SAVE_SETTINGS =		By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[5]/button");

		} else {
			this.urlMy = TestSettings.urlProdMy;
			this.login = TestSettings.rcLoginProd;
			this.password = TestSettings.rcPassProd;

			BY_NUMBER_IMPUT =		By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[1]/div[1]/div[1]/div/input[1]");
			BY_ADD_WORK_TIME =		By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[2]/a[1]");
			BY_START_WORK_TIME =	By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[4]/div[2]/input[1]");
			BY_STOP_WORK_TIME =		By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[4]/div[2]/input[2]");
			BY_SAVE_SETTINGS = 		By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[5]/button");

		}
	}
	public My(RCEnvironment rcEnvironment) {
		this(rcEnvironment, new PhantomJSDriver(new DesiredCapabilities()));
	}


	@Step("открытие личного кабинета")
	public void openMy() {
		this.openSite(urlMy);

		driver.findElement(By.id("name")).sendKeys(login);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("login-button")).click();
	}

	@Step("открытие меню RedConnect")
	public void openRedConnectMenu() {
		this.wait(BY_REDCONNECT_MENU, 3, "не найден элемент BY_REDCONNECT_MENU");
		driver.findElement(BY_REDCONNECT_MENU).click();
	}

	@Step("установка free-тарифа")
	public void setFreeTariff() {
		this.wait(BY_FREE_TARIFF);
		driver.findElement(BY_FREE_TARIFF).click();
	}

	@Step("установка business-тарифа")
	public void setBusinessTariff() {
		this.wait(BY_BUSINESS_TARIFF, 10, "не найден элемент BY_BUSINESS_TARIFF");
		driver.findElement(BY_BUSINESS_TARIFF).click();
	}

	@Step("удаление операторов")
	public void deleteOperators() {

		// ожидание для тестовой среды

		this.wait(BY_REDCONNECT_MENU, "не найден элемент BY_REDCONNECT_MENU");
		driver.findElement(BY_REDCONNECT_MENU).click();

		for (; ; ) {
			try {
				driver.findElement(BY_DELETE_PHONE).click();
				driver.findElement(BY_DO_DELETE_PHONE_YES).click();
			} catch (Exception e) {
				break;
			}
		}
	}

	@Step("установка оператора")
	public void setOperator(RCOperator operator) {

		driver.findElement(BY_ADD_NUMBER).click();

		this.wait(BY_NUMBER_IMPUT, "не найден BY_NUMBER_IMPUT");
		driver.findElement(BY_NUMBER_IMPUT).sendKeys(operator.number);

		driver.findElement(BY_ADD_WORK_TIME).click();

		WebElement timeStartElement = driver.findElement(BY_START_WORK_TIME);
		timeStartElement.clear();
		timeStartElement.sendKeys(operator.timeStart);

		WebElement timeStopElement = driver.findElement(BY_STOP_WORK_TIME);
		timeStopElement.clear();
		timeStopElement.sendKeys(operator.timeStop);

		driver.findElement(BY_SAVE_SETTINGS).click();
	}

	@Step("установка операторов")
	public void setOperators(RCOperator... operators) {

		Integer i = 2;

		for (RCOperator operator : operators) {

			driver.findElement(BY_ADD_NUMBER);
			String numberXpathString = "/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[" + i + "]/li[1]/div[2]/div[1]/div[1]/div[1]/div/input";

			try {
				WebElement numberElement = (new WebDriverWait(driver, 3))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath(numberXpathString)));
				numberElement.sendKeys(operator.number);

			} catch (org.openqa.selenium.TimeoutException e) {
				fail("Не появился элемент -> " + i);
			}


			By by_addWorkTime = By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[" + i + "]/li[1]/div[2]/div[2]/a[1]");
			driver.findElement(by_addWorkTime).click();

			By by_timeStartElement = By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[" + i + "]/li[1]/div[2]/div[4]/div[2]/input[1]");
			WebElement timeStartElement = driver.findElement(by_timeStartElement);
			timeStartElement.clear();
			timeStartElement.sendKeys(operator.timeStart);

			By by_timeStopElement = By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[" + i + "]/li[1]/div[2]/div[4]/div[2]/input[1]");
			WebElement timeStopElement = driver.findElement(by_timeStopElement);
			timeStopElement.clear();
			timeStopElement.sendKeys(operator.timeStop);

			driver.findElement(BY_SAVE_SETTINGS).click();

			i += 3;
		}
	}



}

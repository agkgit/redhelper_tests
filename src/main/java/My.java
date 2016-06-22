import com.redhelper.RCEnvironment;
import com.redhelper.RCOperator;
import com.redhelper.TestSettings;
import com.sun.deploy.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.String;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.testng.Assert.fail;


public class My extends TestPage {

		public static final String MY_URL = "http://test.redhelper.ru/my/redconnect";

		// константы типа By
		public static final By BY_DELETE_PHONE			= By.xpath(".//a[@ng-click-outside='cancelDeletePhone(phone)']");
		public static final By BY_DO_DELETE_PHONE_YES	= By.xpath(".//button[@ng-click='doDeletePhone(phone)']");
		public static final By BY_ADD_NUMBER			= By.cssSelector("div.rc-new-item:nth-child(3) > span:nth-child(2)");
		public static final By BY_NUMBER_IMPUT			= By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[1]/div[1]/div[1]/div/input[1]");
		public static final By BY_ADD_WORK_TIME			= By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[2]/a[1]");
		public static final By BY_START_WORK_TIME		= By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[4]/div[2]/input[1]");
		public static final By BY_STOP_WORK_TIME		= By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul[2]/li[1]/div[2]/div[4]/div[2]/input[2]");
		public static final By BY_SAVE_SETTINGS			= By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[5]/button");
		public static final By BY_REDCONNECT_MENU		= By.xpath("//*[@id=\"a-redconnect\"]");
		public static final By BY_BUSINESS_TARIFF		= By.xpath(".//div[@class='rc-mode-name' and contains(.,'Business')]");
		public static final By BY_FREE_TARIFF			= By.xpath(".//div[@class='rc-mode-name' and contains(.,'Business')]");

		RCEnvironment rcEnvironment;
		String login, password;
		String urlMy;

		public void openMy() {
			super.openSite(urlMy);

			driver.findElement(By.id("name")).sendKeys(login);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.className("login-button")).click();

			driver.findElement(BY_REDCONNECT_MENU).click();
		}

		public void setFreeTariff() {
			driver.findElement(BY_FREE_TARIFF).click();
		}
		public void setBusinessTariff() {
			driver.findElement(BY_BUSINESS_TARIFF).click();
		}

		public void deleteOperators() {

			// ожидание для тестовой среды
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//driver.get(MY_URL);
			driver.findElement(BY_REDCONNECT_MENU).click();

			for (;;) {
				try {
					driver.findElement(BY_DELETE_PHONE).click();
					driver.findElement(BY_DO_DELETE_PHONE_YES).click();
				} catch (Exception e) {
					break;
				}
			}
		}
		public void setOperator( RCOperator operator ) {

			driver.findElement(BY_ADD_NUMBER).click();

			WebElement numberInputElement = driver.findElement(BY_NUMBER_IMPUT);
			numberInputElement.sendKeys(operator.number);

			driver.findElement(BY_ADD_WORK_TIME).click();

			WebElement timeStartElement = driver.findElement(BY_START_WORK_TIME);
			timeStartElement.clear();
			timeStartElement.sendKeys(operator.timeStart);

			WebElement timeStopElement = driver.findElement(BY_STOP_WORK_TIME);
			timeStopElement.clear();
			timeStopElement.sendKeys(operator.timeStop);

			driver.findElement(BY_SAVE_SETTINGS).click();
		}
		public void setOperators (RCOperator...operators) {

		Integer i = 2;

		for (RCOperator operator : operators) {

			driver.findElement(BY_ADD_NUMBER);
			String numberXpathString = "/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul["+ i +"]/li[1]/div[2]/div[1]/div[1]/div[1]/div/input";

			try {
				WebElement numberElement = (new WebDriverWait(driver, 3))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath(numberXpathString)));
				numberElement.sendKeys(operator.number);

			} catch (org.openqa.selenium.TimeoutException e) {
				fail("Не появился элемент -> " + i);
			}


			By by_addWorkTime = By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul["+ i +"]/li[1]/div[2]/div[2]/a[1]");
			driver.findElement(by_addWorkTime).click();

			By by_timeStartElement = By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul["+ i +"]/li[1]/div[2]/div[4]/div[2]/input[1]");
			WebElement timeStartElement = driver.findElement(by_timeStartElement);
			timeStartElement.clear();
			timeStartElement.sendKeys(operator.timeStart);

			By by_timeStopElement = By.xpath("/html/body/div[3]/div[3]/div[3]/div[2]/div[3]/div[4]/div/div/div[2]/div[2]/ul["+ i +"]/li[1]/div[2]/div[4]/div[2]/input[1]");
			WebElement timeStopElement = driver.findElement(by_timeStopElement);
			timeStopElement.clear();
			timeStopElement.sendKeys(operator.timeStop);

			driver.findElement(BY_SAVE_SETTINGS).click();

			i += 3;
		}
	}

		public My(RCEnvironment rcEnvironment) {

			this.rcEnvironment = rcEnvironment;

			if (rcEnvironment == RCEnvironment.TEST) {
				this.urlMy = TestSettings.urlTestMy;
				this.login = TestSettings.rcLoginTest;
				this.password = TestSettings.rcPassTest;
			} else {
				this.urlMy = TestSettings.urlProdMy;
				this.login = TestSettings.rcLoginProd;
				this.password = TestSettings.rcPassProd;
			}

			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		}

	}

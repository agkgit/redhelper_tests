import com.redhelper.RCEnvironment;
import com.redhelper.RCOperator;
import com.redhelper.TestSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import static org.testng.AssertJUnit.fail;

public class TestRCInvalidNumbers {

	@Test
	public void setUnvalidNumber() throws InterruptedException {
		RCWidgetPage rcWidgetPage = new RCWidgetPage();
		rcWidgetPage.openSite("http://www.vernee.ru/qa");

		for (String number : TestSettings.numbers) {
			rcWidgetPage.reload();
			rcWidgetPage.clickWidgetButton();
			rcWidgetPage.inputNumber(number);
			rcWidgetPage.clickThePhoneButton();
			rcWidgetPage.waitWarningInvalidNumber();
		}
		rcWidgetPage.close();
	}

	@Test
	public void testik() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.ya.ru");
		Thread.sleep(10000);
		driver.close();
//		RCWidgetPage rcWidgetPage = new RCWidgetPage();
//		rcWidgetPage.openSite("http://vernee.ru/qa");
//		rcWidgetPage.waitWarningInvalidNumber();
	}

	@Test
	public void mainTest() throws InterruptedException {
		WebDriver phantomjsDriver = new PhantomJSDriver( new DesiredCapabilities() );
		My cabinet = new My(RCEnvironment.PRODUCTION, phantomjsDriver);
		cabinet.manage(5, 5);
		cabinet.openMy();
		cabinet.openRedConnectMenu();
		cabinet.setBusinessTariff();
		cabinet.deleteOperators();
		cabinet.setOperator(new RCOperator("9094065104", "11:11", "12:12"));
//		//cabinet.setOperator(new RCOperator("9999864875"));
		cabinet.close();
//
//		FirefoxProfile firefoxProfile = new FirefoxProfile();
//		firefoxProfile.setPreference("browser.private.browsing.autostart", true);
//		WebDriver firefoxDriver = new FirefoxDriver(firefoxProfile);
//		RCWidgetPage rcWidgetPage = new RCWidgetPage();
//		rcWidgetPage.openSite("http://vernee.ru/qa");
//		rcWidgetPage.clickWidgetButton();
//		rcWidgetPage.inputNumber("79999864875");
//		rcWidgetPage.clickThePhoneButton();
//		rcWidgetPage.waitPhoneDialElements();
//		rcWidgetPage.close();
	}

}
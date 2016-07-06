import com.redhelper.RCEnvironment;
import com.redhelper.RCOperator;
import com.redhelper.TestSettings;
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
		RCWidgetPage rcWidgetPage = new RCWidgetPage();
		rcWidgetPage.openSite("http://vernee.ru/qa");
		rcWidgetPage.waitWarningInvalidNumber();
	}

	@Test
	public void mainTest() throws InterruptedException {

		My cabinet = new My(RCEnvironment.TEST);
		cabinet.openMy();
		cabinet.openRedConnectMenu();
		cabinet.setBusinessTariff();
		cabinet.deleteOperators();
		cabinet.setOperator(new RCOperator("9094065104"));
		cabinet.close();

		RCWidgetPage rcWidgetPage = new RCWidgetPage(BrowsersEnum.PHANTOMJS);
		rcWidgetPage.openSite("http://vernee.ru/qa");
		rcWidgetPage.clickWidgetButton();
		rcWidgetPage.inputNumber("79607088020");
		rcWidgetPage.clickThePhoneButton();
		rcWidgetPage.waitPhoneDialElements();
		rcWidgetPage.close();
	}

}
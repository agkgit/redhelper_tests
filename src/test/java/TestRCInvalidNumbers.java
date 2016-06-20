import com.redhelper.RCEnvironment;
import com.redhelper.RCOperator;
import com.redhelper.TestSettings;
import org.omg.CORBA.Environment;
import org.testng.annotations.*;
import static org.testng.AssertJUnit.fail;


public class TestRCInvalidNumbers {

	@Test
	public void setUnvalidNumber() throws InterruptedException {
		RCWidgetPage rcWidgetPage = new RCWidgetPage();
		rcWidgetPage.openSite("http://vernee.ru/qa");

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
	public void mainTest() throws InterruptedException {
		RCWidgetPage rcWidgetPage = new RCWidgetPage();
		My cabinet = new My(RCEnvironment.TEST);
		cabinet.setBusinessTariff();
		cabinet.deleteOperators();
		cabinet.setOperator(new RCOperator("79999864875"));
		cabinet.close();
		rcWidgetPage.openSite("http://vernee.ru/qa");
		rcWidgetPage.inputNumber("79999864875");
		rcWidgetPage.clickThePhoneButton();
		Thread.sleep(50000);
		rcWidgetPage.close();
	}
}

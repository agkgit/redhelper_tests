import org.testng.annotations.*;

import static org.testng.AssertJUnit.fail;


public class TestRCInvalidNumbers {

	@Test
	public void setUnvalidNumber() throws InterruptedException {
		RCWidgetPage RCWidgetPage = new RCWidgetPage();
		RCWidgetPage.openSite("http://vernee.ru/qa");

		for (String number : TestSettings.numbers) {
			RCWidgetPage.reload();
			RCWidgetPage.clickWidgetButton();
			RCWidgetPage.inputNumber(number);
			RCWidgetPage.clickThePhoneButton();
			RCWidgetPage.waitWarningInvalidNumber();
		}

		RCWidgetPage.close();
	}
}

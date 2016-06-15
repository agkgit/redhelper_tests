//    //import com.sun.jdi.event.WatchpointEvent;
//    import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Wait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.Assert.fail;
//
//
//    public class RHTestChat {
//
//		//variables
//
//		Thread botThread1;
//		Thread botThread2;
//		WebElement rhIFrame;
//		WebDriver driver;
//		JabberBot bot1 = new JabberBot("krupeninadmin", "qweasd", "xmpp.redhelper.ru", "xmpp.redhelper.ru", 5222);
//		JabberBot bot2 = new JabberBot("krupenin", "qweasd", "xmpp.redhelper.ru", "xmpp.redhelper.ru", 5222);
//
//
//		@Before
//		public  void beforeTest() {
//
//			FirefoxProfile firefoxProfile = new FirefoxProfile();
//			firefoxProfile.setPreference("browser.private.browsing.autostart",true);
//
//			driver = new FirefoxDriver();
//		}
//
//		@Test
//		public void sendMessagesVisitorToOperator() throws InterruptedException {
//
//			botThread1 = new Thread(bot1);
//			botThread2 = new Thread(bot2);
//
//			botThread1.start();
//			botThread2.start();
//
//			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//			driver.get("http://www.vernee.ru/t");
//
//			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//			driver.findElement(By.id("rh-badge")).click();
//
//			final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
//
//			rhIFrame = driver.findElement(By.id("rh-chatFrame"));
//			driver.switchTo().frame(rhIFrame);
//			WebElement rhTextArea = driver.findElement(By.id("chatTextarea"));
//			WebElement rhSendButton = driver.findElement(By.id("chatSend"));
//
//			for (String message : TestSettings.messages) {
//				rhTextArea.sendKeys(message);
//				rhSendButton.click();
//
//				String xpathVar = ".//div[@class='msgBlock fromOperator'][last()]/div[@class='msg']/div[@class='textWrapper']/div[text()='" + message + "']";
//				try {
//					WebElement dynamicElement = (new WebDriverWait(driver, 4))
//							.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathVar)));
//				} catch (TimeoutException e) {
//					fail("Не появился элемент " + xpathVar);
//				}
//			}
//
//
//		}
//
//		@After
//		public void aftefTest() throws InterruptedException {
//			Thread.sleep(5000);
//			driver.close();
//		}
//
//	}
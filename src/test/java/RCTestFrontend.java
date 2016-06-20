////import com.sun.jdi.event.WatchpointEvent;
//
//import org.apache.xpath.operations.String;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.concurrent.TimeUnit;
//
//import static org.junit.Assert.fail;
//
//public class RCTestFrontend {
//
//    WebDriver driver;
//
//    @Before
//    public  void beforeTest() {
//        FirefoxProfile firefoxProfile = new FirefoxProfile();
//        firefoxProfile.setPreference("browser.private.browsing.autostart",true);
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//        driver.get("http://www.vernee.ru/qa");
//    }
//
//    @Test
//    public void setUnvalidNumber() throws InterruptedException {
//
//
////        WebElement rcFrameNumber = driver.findElement(By.className("rc-connector-frame"));
////        driver.switchTo().frame(rcFrameNumber);
////        WebElement numberArea = driver.findElement(By.id("rc-phone-input"));
////        driver.switchTo().defaultContent();
////        WebElement button = driver.findElement(By.id("rc-phone-button"));
////        int i = 1;
//
//        for (String number : com.redhelper.TestSettings.numbers) {
//
//            driver.navigate().refresh();
//            WebElement rcFrameNumber = driver.findElement(By.className("rc-connector-frame"));
//            driver.switchTo().frame(rcFrameNumber);
//            driver.findElement(By.id("rc-phone-input")).clear();
//            driver.findElement(By.id("rc-phone-input")).sendKeys(number);
//            driver.switchTo().defaultContent();
//
//            driver.findElement(By.id("rc-phone-button")).click();
//            //button.click();
//
//            try {
//                WebElement warningElement = (new WebDriverWait(driver, 1))
//                        .until(ExpectedConditions.presenceOfElementLocated(By.id("rc-phone-input-warning")));
//            } catch (TimeoutException e) {
//                fail("Не появилось предупреждение");
//            }
//        }
//
//    }
////
////
////
////        final Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
////
////        rhIFrame = driver.findElement(By.id("rh-chatFrame"));
////        driver.switchTo().frame(rhIFrame);
////        WebElement rhTextArea = driver.findElement(By.id("chatTextarea"));
////        WebElement rhSendButton = driver.findElement(By.id("chatSend"));
////
////        for (String message : com.redhelper.TestSettings.messages) {
////            rhTextArea.sendKeys(message);
////            rhSendButton.click();
////
////            String xpathVar = ".//div[@class='msgBlock fromOperator'][last()]/div[@class='msg']/div[@class='textWrapper']/div[text()='" + message + "']";
////            try {
////                WebElement dynamicElement = (new WebDriverWait(driver, 4))
////                        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathVar)));
////            } catch (TimeoutException e) {
////                fail("Не появился элемент " + xpathVar);
////            }
////        }
////
//
//    @After
//    public void aftefTest() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.close();
//    }
//
//}
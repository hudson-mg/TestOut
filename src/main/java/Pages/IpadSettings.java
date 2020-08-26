package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utilities.PageUtil;


public class IpadSettings {
    WebDriver driver = null;

    // WebElements
    By btnMailContactsCalendars = By.id("siMailContactsCalendars");
    By lblAccount = By.xpath("//div[contains(text(), 'Account')]");
    By lblMailCalendarsNotes = By.xpath("//div[contains(text(), 'Mail, Calendars, Notes')]");
    By btnWiFi = By.id("siWiFi");

    public IpadSettings(WebDriver driver) {
        this.driver = driver;
    }

    public void selectMailContactsCalendars() {
        System.out.println(">> Select Mail Contacts and Calendars");
        PageUtil.waitForVisible(driver, btnMailContactsCalendars, 3);
        driver.findElement(btnMailContactsCalendars).click();
    }

    public WebElement getElementByXpathContainsText(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public void selectUser(String User) {

        System.out.println(">> Select User");PageUtil.waitForVisible(driver, lblMailCalendarsNotes, 3);
        getElementByXpathContainsText("//div[contains(text(), '"+User+"')]").click();
    }

    public void selectEmailAddress(String EmailAddress) {
        System.out.println(">> Select email address: mbrown@gmail.com");
        PageUtil.waitForVisible(driver, lblAccount, 3);
        getElementByXpathContainsText("//div[contains(text(), '"+EmailAddress+"')]").click();
    }

    public void selectWifi() {
        System.out.println(">> Click Wi-FI");
        PageUtil.waitForVisible(driver, btnWiFi, 3);
        driver.findElement(btnWiFi).click();
    }

}

package Pages;

import Utilities.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class IpadWiFi {
    WebDriver driver = null;

    // WebElements
    By btnCorpNet = By.xpath("//div[contains(text(), 'CorpNet')]");
    By txtPassword = By.xpath("//input[@data-typename='PasswordBox']");
    By btnJoin = By.id("btnJoin");

    public IpadWiFi(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCorpNet() {
        System.out.println(">> Click CorpNet");
        PageUtil.waitForVisible(driver, btnCorpNet, 3);
        driver.findElement(btnCorpNet).click();
    }

    public void enterPassword(String password) {
        System.out.println(">> Enter password: " +password);
        PageUtil.waitForClickable(driver, txtPassword, 3);
        driver.findElement(txtPassword).clear();
        driver.findElement(txtPassword).sendKeys(password);
    }

    public void selectJoin() {
        System.out.println(">> Click join");
        PageUtil.waitForClickable(driver, btnJoin, 3);
        driver.findElement(btnJoin).click();
    }

}

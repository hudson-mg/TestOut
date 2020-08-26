package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utilities.PageUtil;


public class IpadMain {
    WebDriver driver = null;

    // WebElements
    By btnSettings = By.id("wpDesktop.DesktopIcon15");

    public IpadMain(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSettings() {
        System.out.println(">> Select settings");
        PageUtil.waitForVisible(driver, btnSettings, 25);
        driver.findElement(btnSettings).click();
    }

}

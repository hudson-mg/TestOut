package Pages;

import Utilities.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;


public class IpadAccountSettings {
    WebDriver driver = null;

    // WebElements
    By btnAdvanced = By.id("siAdvanced.Grid.tbArrow");
    By getSSLState = By.id("siUseSSL.Grid.tbOnOff.Grid.SwitchRoot.Canvas.SwitchTrack.StackPanel.Border1");
    By toggleSSL = By.id("siUseSSL.Grid.tbOnOff.Grid.SwitchRoot");
    By lblServerPort = By.id("tbServerPort");
    By btnAccount = By.id("btnAccount");
    By btnDone = By.id("btnDone.grid.contentPresenter.TextBlock");

    public IpadAccountSettings(WebDriver driver) {
        this.driver = driver;
    }

    public void selectAccountAdvanced() {
        System.out.println(">> Select advanced");
        PageUtil.waitForVisible(driver, btnAdvanced, 3);
        PageUtil.waitForClickable(driver, btnAdvanced, 3);
        driver.findElement(btnAdvanced).click();
    }

    public void enableSSL() {
        System.out.println(">> Slide button to Enable SSL");
        PageUtil.waitForVisible(driver, getSSLState, 3);
        // If SSL toggle state is disabled, enable it. Else leave it enabled
        if (driver.findElement(getSSLState).getAttribute("Style").contains("left: -18px")) {
           new Actions(driver)
                   .moveToElement(driver.findElement(toggleSSL))
                   .pause(Duration.ofSeconds(1))
                   .clickAndHold(driver.findElement(toggleSSL))
                   .pause(Duration.ofSeconds(1))
                   .moveByOffset(50, 0)
                   .pause(Duration.ofSeconds(1))
                   .release().perform();
       }
    }

    public String getServerPort() {
        System.out.println(">> Verify Server Port");
        return driver.findElement(lblServerPort).getAttribute("value");
    }

    public void selectAccount() {
        System.out.println(">> Select account");
        PageUtil.waitForVisible(driver, btnAccount, 3);
        driver.findElement(btnAccount).click();
    }

    public void selectDone() {
        System.out.println(">> Click done");
        PageUtil.waitForVisible(driver, btnDone, 3);
        driver.findElement(btnDone).click();
    }

}

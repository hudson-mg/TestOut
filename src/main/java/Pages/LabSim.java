package Pages;

import Utilities.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LabSim {
    WebDriver driver = null;

    // WebElements
    By btnDone = By.id("bDone");
    By lblScore = By.xpath("//*[@id='reportDiv']/div/div[1]/div[2]");

    public LabSim(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDone() {
        System.out.println(">> Click Done");
        PageUtil.waitForVisible(driver, btnDone, 3);
        driver.findElement(btnDone).click();
    }

    public String getResults() {
        System.out.println(">> verify score results");
        driver.switchTo().frame("_ifrmreport_");
        PageUtil.waitForVisible(driver, lblScore, 3);
        return driver.findElement(lblScore).getText();
    }

}

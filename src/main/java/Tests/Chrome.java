package Tests;

import Pages.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {
    public static WebDriver driver =null;

    @BeforeClass
    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver","D:\\Dev\\Drivers\\chrome\\chromedriver.exe");
        System.out.println(">> Starting test in Chrome Browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testoutlivecontent.blob.core.windows.net/netpro2018v5-en-us/en-us/sims/typescriptv1/netpro2018v5/simstartup_webpack.html?package=netpro2018v5windowspackage&sim=ipademail_np5&dev=true&automation=true");
    }

    @Test
    public void IpadSimulatedTest() {
        IpadMain ipadMain = new IpadMain(driver);
        IpadSettings ipadSettings = new IpadSettings(driver);
        IpadAccountSettings ipadAccountSettings = new IpadAccountSettings(driver);
        IpadWiFi ipadWifi = new IpadWiFi(driver);
        LabSim labSim = new LabSim(driver);

        ipadMain.selectSettings();
        ipadSettings.selectMailContactsCalendars();
        ipadSettings.selectUser("Maggie Brown");
        ipadSettings.selectEmailAddress("mbrown@gmail.com");
        ipadAccountSettings.selectAccountAdvanced();
        ipadAccountSettings.enableSSL();
        Assert.assertEquals("The Server Port was incorrect:", "993", ipadAccountSettings.getServerPort());
        ipadAccountSettings.selectAccount();
        ipadAccountSettings.selectDone();

        ipadSettings.selectWifi();
        ipadWifi.selectCorpNet();
        ipadWifi.enterPassword("@CorpNetWeRSecure!&");
        ipadWifi.selectJoin();
        labSim.selectDone();
        Assert.assertEquals("The test was not completed successfully", "Your Score: 1 of 1 (100%)", labSim.getResults());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
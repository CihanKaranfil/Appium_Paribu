package paribu.Giriş;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class GirisModulü {
    @Test
    public void test01() throws MalformedURLException, InterruptedException {
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "app-release.apk";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("udid", "emulator-5554");
        //capabilities.setCapability("app", appUrl);
        capabilities.setCapability("appPackage", "com.paribu.app");
        capabilities.setCapability("appActivity", "com.picassomobile.MainActivity");

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, capabilities);
        Thread.sleep(4000);

        WebElement piyasalar = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Piyasalar\"]"));
        piyasalar.click();
        Thread.sleep(1000);
        WebElement arama = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text=\"Varlık ismi/kısaltması ile arayın\"]"));
        arama.click();
        arama.sendKeys("enj");

        WebElement enj = driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));
        enj.click();
        //arama.sendKeys("ada");

        driver.pressKey(new KeyEvent(AndroidKey.BACK));

        arama.sendKeys("ada");


    }

}

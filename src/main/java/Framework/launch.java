package Framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class launch {
	public static AndroidDriver<AndroidElement> driver;
@Test()
public AndroidDriver<AndroidElement> capabilities() throws MalformedURLException{
	DesiredCapabilities cap = new DesiredCapabilities();
	File f = new File("src");
	File fs = new File(f,"Amazon_shopping.apk");

	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2 API 27");
	cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
	cap.setCapability("newCommandTimeout", 100000);

	cap.setCapability("--session-override", true);
	driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	return driver;
			
}
}

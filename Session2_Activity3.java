package MavenTest.NewAppium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Session2Activity3 {

	AppiumDriver<MobileElement> driver = null;
WebDriverWait wait;
@BeforeClass
public void GoogletaskPrep() throws InterruptedException, IOException {
	
  // Set the Desired Capabilities
  DesiredCapabilities caps = new DesiredCapabilities();
  caps.setCapability("deviceId", "ZY222XVZBD");
  caps.setCapability("deviceName", "Moto G");
  caps.setCapability("platformName", "android");
  caps.setCapability("appPackage", "com.android.contacts");
  caps.setCapability("appActivity", ".DialtactsContactsEntryActivity");
  caps.setCapability("noReset", "true");
	driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}

@Test
public void addContact() 
{
	driver.findElementByAccessibilityId("Create new contact").click();
	driver.findElementByXPath("//android.widget.EditText[@text = 'Name']").sendKeys("Pradeep");
	driver.findElementByXPath("//android.widget.EditText[@text = 'Phone']").sendKeys("9910118047");
	driver.findElementByXPath("//android.widget.Button[@text = 'Done']").click();
	driver.findElementByXPath("//android.widget.EditText[@text = 'Search among 150 contacts']").sendKeys("Pradeep);
	String contactName = driver.findElementByXPath("//android.widget.TextView[@text = 'Pradeep']").getText();
			//driver.findElementById("com.android.contacts:id/service_layout").getText();
	Assert.assertEquals(contactName, "Pradeep");
}


  @AfterClass
  public void afterClass() {
	
		    driver.quit();

	  }

}

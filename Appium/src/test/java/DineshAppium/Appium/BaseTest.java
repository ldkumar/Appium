package DineshAppium.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	AppiumDriverLocalService service;
	AndroidDriver driver;
	
	
	
	@BeforeClass
	public void configuationAppium() throws MalformedURLException, URISyntaxException
	{
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\shaur\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("DineshPhone");
		options.setApp("D:\\Selenium Programs\\Appium\\Apkfile\\ApiDemos-debug.apk");
		
		
		 driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		
		
	}
	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile:longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));
	}
	

	@AfterClass
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}
}

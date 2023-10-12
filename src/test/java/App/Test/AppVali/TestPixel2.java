package App.Test.AppVali;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.Assert;
import io.appium.java_client.MobileElement;
public class TestPixel2 {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	
     @BeforeClass
	public void configureAppium() throws MalformedURLException, InterruptedException 
     {
		
		Map<String , String> env = new HashMap<String , String>(System.getenv());
		env.put("ANDROID_HOME", "C:\\Users\\rti\\AppData\\Local\\Android\\Sdk");
		env.put("JAVA_HOME", "C:\\Program Files\\Java\\jdk-17.0.1");
		
//		//run appium server automatically
//		 service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Sarif\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//		.withIPAddress("127.0.0.1").usingPort(4723).withEnvironment(env).withTimeout(Duration.ofSeconds(300)).build();
//		 
//		 service.start();
		 
		// create capabilities
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("pixel_7");
		options.setPlatformName("Android");
//		options.setCapability("platformVersion","13.0");
		//options.setAutomationName("UiAutomator2");
		
		options.setApp(System.getProperty("user.dir")+"\\resource\\ApiDemos-debug.apk");
		//options.setApp(System.getProperty("user.dir")+"\\resource\\General-Store.apk");
		options.setChromedriverExecutable("C:\\Users\\Selenium\\chromedriverM.exe");
	
		
		//create object for AndroidDriver/ IOSDriver 
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	
		//Object Locators: xpath, id, className, accessibilityId, androidUIautomator
		//driver.findElement(By.xpath(null))
		
	}
     @AfterClass
     public void CloseConnections() throws MalformedURLException, InterruptedException 
     {
    	 driver.quit();
     }
//     @AfterMethod
//     public void teardown() {
//         // This method will run after each test method
//         // Simulate pressing the "Home" button
//         KeyEvent keyEvent = new KeyEvent();
//         keyEvent.withKey(AndroidKey.HOME);
//         driver.pressKey(keyEvent);
//         // Add cleanup or resource release code here
//     }
     @Test(priority = 3)
     public void scrollToEnd() {
    	 boolean canScrollMore;
 		do {
 		 canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
 			    "left", 100, "top", 100, "width", 200, "height", 200,
 			    "direction", "down",
 			    "percent", 3.0
 			));
 		
 		} while(canScrollMore);
     }
     @Test(priority = 1)
     public void test_os_option( ) { 
    	 List<WebElement> myElements = driver.findElements(AppiumBy.accessibilityId("OS"));
    	 for(WebElement e : myElements) {
    	   Assert.assertEquals(e.getText(),"OS","Failed to find OS element");
//    	   System.out.println(e.getText());
    	 }
    			 
     }
     @Test(priority =2 )
     public void test_layout_animations_option_list( ) {
    	 driver.findElement(AppiumBy.accessibilityId("Animation")).click();  
    	 driver.findElement(AppiumBy.accessibilityId("Layout Animations")).click();
    	 List<WebElement> checkboxes = driver.findElements(By.className("android.widget.CheckBox"));
    	 List<String> expected_layout_animation_list = new ArrayList<>( Arrays.asList("Custom Animations","In","Out","Changing-In","Changing-Out"));
    	 List<String> actual_layout_animation_list = new ArrayList<String>();
    	 for(WebElement e : checkboxes) {
    	   System.out.println(e.getText());
    	   actual_layout_animation_list.add(e.getText());
    	 }
    	 Assert.assertEquals(actual_layout_animation_list,expected_layout_animation_list);
    			 
     }
     
}
package lv.bb.reklama.demo.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FunctionalTest {
	
	protected WebDriver driver;
	
	public void setUp(){
		
		System.setProperty("webdriver.chrome.driver", "chromedriver_83.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--enable-automation");
		
		driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("Chrome has started");
	}

	public void tearDown() {
		driver.quit();
	}
}

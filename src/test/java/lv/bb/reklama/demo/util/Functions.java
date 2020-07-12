package lv.bb.reklama.demo.util;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import lv.bb.reklama.demo.pageobjects.BasePage;

public class Functions extends BasePage {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions action = new Actions(driver);
	
	public Functions(WebDriver driver) {
		super(driver);
	}
	
	public void clickElement (WebElement element) {
		System.out.println("clicking element: " + element);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public void waitForJStoLoad() {
		ExpectedCondition<Boolean> pageLoadCondition = 
			(WebDriver driver) -> js.executeScript("return document.readyState").equals("complete");
		wait.until(pageLoadCondition);
		}
	
	public void scrollElementIntoView(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public String getElementText(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getText();
	}
	
	public void typeText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(text);
	}
	
	public void hoverAndClickElement(WebElement sourceElement, WebElement targetElement) {
		wait.until(ExpectedConditions.visibilityOf(sourceElement));
		action.moveToElement(sourceElement).pause(1000).click(targetElement).build().perform();
		waitForJStoLoad();
	}
	
	public void switchHandles(int handleElement) {
		ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs_windows.get(handleElement));
	}
}

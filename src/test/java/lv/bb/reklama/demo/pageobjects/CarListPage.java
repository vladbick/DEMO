package lv.bb.reklama.demo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lv.bb.reklama.demo.util.Functions;

public class CarListPage extends BasePage {
	
	public CarListPage(WebDriver driver) {
		super(driver);
	}
	
	Functions function = new Functions(driver);
    
    @FindBy(css = "#posts > tbody")
    private WebElement tblPostsBody;
    
	public AdDetailsPage clickOnAd(int adNumber) {
		function.waitForJStoLoad();
		function.clickElement(tblPostsBody.findElement(By.xpath("./tr[" + adNumber + "]")));
        return new AdDetailsPage(driver);
	}
	
	public String getAdTitle(int adNumber) {
		String title = tblPostsBody.findElement(By.xpath("./tr[" + adNumber + "]/td/div[@class=\"text\"]/a")).getText();
		System.out.println("Ad title: " + title);
		return title;
	}
}

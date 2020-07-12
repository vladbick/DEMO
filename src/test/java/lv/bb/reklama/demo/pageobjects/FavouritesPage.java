package lv.bb.reklama.demo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import lv.bb.reklama.demo.util.Functions;

public class FavouritesPage extends BasePage {
	
	public FavouritesPage(WebDriver driver) {
		super(driver);
	}
	
	Functions function = new Functions(driver);
    
    @FindBy(css = "#icon_view > div > table > tbody > tr:first-child > td.text > p")
    private WebElement txaFirstElement;
    
    @FindBy(css = "#icon_view > div > table > tbody > tr:last-child > td.text > p")
    private WebElement txaLastElement;
    
    @FindBy(xpath = "//form[@id=\"buttons-form\"]/input[@type=\"button\"][contains(@onclick, \"cleanFavorites\")]")
    private WebElement btnClearFavourites;
    
    @FindBy(css = "#icon_view > div > table > tbody")
    private WebElement tblAds;
    
	public String getFirstElementText() {
		return function.getElementText(txaFirstElement);
	}
	
	public FavouritesPage clickRemoveAllFavourites() {
		function.waitForJStoLoad();
		function.clickElement(btnClearFavourites);
		return new FavouritesPage(driver);
	}
	
	public AdDetailsPage clickOnAd(int adNumber) {
		function.clickElement(tblAds.findElement(By.xpath("./tr[" + adNumber + "]")));
		return new AdDetailsPage(driver);
	}

	public FavouritesPage removeAd(int adNumber) {
		function.waitForJStoLoad();
		int numberOfFavourites = getNumberOfFavourites();
    	WebElement element = tblAds.findElement(By.xpath("./tr[" + adNumber + "]"));
    	WebElement target = tblAds.findElement(By.xpath("./tr[" + adNumber + "]/td/div/div/a[@class=\"fav-remove\"]"));
    	function.hoverAndClickElement(element, target);
    	numberOfFavourites--;
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"favorites_count\"][contains(text(), \"" + numberOfFavourites + "\")]"))));
		return new FavouritesPage(driver);
	}

}

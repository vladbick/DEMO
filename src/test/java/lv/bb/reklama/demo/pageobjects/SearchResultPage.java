package lv.bb.reklama.demo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import lv.bb.reklama.demo.util.Functions;

public class SearchResultPage extends BasePage {
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	Functions function = new Functions(driver);
	
    @FindBy(css = "#posts > tbody")
    private WebElement tblPostsBody;
    
    @FindBy(id = "favorites-link")
    private WebElement lnkFavourites;
    
    public SearchResultPage addToFavourites(int numberOfAds) {
    	function.waitForJStoLoad();
    	int numberOfFavourites = getNumberOfFavourites();
    	for (int i=1; i<=numberOfAds; i++) {
    		WebElement element = tblPostsBody.findElement(By.xpath("./tr[" + i + "]"));
    	    WebElement target = tblPostsBody.findElement(By.xpath("./tr[" + i + "]/td/div/div/a[@class=\"fav-add\"]"));
    	    function.hoverAndClickElement(element, target);
    	    numberOfFavourites++;
    	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"favorites_count\"][contains(text(), \"" + numberOfFavourites + "\")]"))));
    	    function.waitForJStoLoad();
    	}
    	return new SearchResultPage(driver);
    }
    
	public FavouritesPage clickFavouritesLink() {
		function.clickElement(lnkFavourites);
        return new FavouritesPage(driver);
	}

}

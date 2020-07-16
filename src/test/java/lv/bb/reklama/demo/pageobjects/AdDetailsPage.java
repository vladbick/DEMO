package lv.bb.reklama.demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lv.bb.reklama.demo.util.Functions;

public class AdDetailsPage extends BasePage {
	
	public AdDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	Functions function = new Functions(driver);
    
    @FindBy(id = "favs-link")
    private WebElement lnkFavouritesAdd;
    
    @FindBy(id = "favorites-link")
    private WebElement lnkFavourites;
    
    @FindBy(css = "#content > p")
    private WebElement txtAdBody;
    
	public AdDetailsPage scrollToAddRemoveFavouritesLink() {
		function.waitForJStoLoad();
		function.scrollElementIntoView(lnkFavouritesAdd);
        return new AdDetailsPage(driver);
	}
	
	public FavouritesPage clickAddRemoveToFavouritesLink() {
		function.clickElement(lnkFavouritesAdd);
        return new FavouritesPage(driver);
	}
	
	public FavouritesPage clickFavouritesLink() {
		function.clickElement(lnkFavourites);
        return new FavouritesPage(driver);
	}
	
	public String getAdText() {
		String text = txtAdBody.getText();
		System.out.println("Ad title: " + text);
		return text;
	}
}
package lv.bb.reklama.demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
    @FindBy(id = "favorites_count")
    private WebElement txtFavouritesCount;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		this.wait = new WebDriverWait(driver, 30);
	}
	
	public int getNumberOfFavourites() {
		wait.until(ExpectedConditions.visibilityOf(txtFavouritesCount));
		return Integer.parseInt(txtFavouritesCount.getText());
	}
}

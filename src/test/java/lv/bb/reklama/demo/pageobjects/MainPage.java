package lv.bb.reklama.demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lv.bb.reklama.demo.util.Functions;

public class MainPage extends BasePage {
	
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	Functions function = new Functions(driver);
	
	String link = "https://reklama.bb.lv/ru/";
	
    @FindBy(xpath = "//a[@href=\"/ru/transport/cars/menus.html\"]")
    private WebElement lnkAutoMenu;
    
    @FindBy(xpath = "//form[@name=\"frmSearch\"]/a")
    private WebElement lnkExtendedSearch;
    
    @FindBy(name = "imgSearch")
    private WebElement btnSearch;
    
    public CarBrandsPage clickAutoMenu () {
        function.clickElement(lnkAutoMenu);
        return new CarBrandsPage(driver);
    }
    
    public SearchPage clickExtendedSearchLink () {
        function.clickElement(lnkExtendedSearch);
        return new SearchPage(driver);
    }
    
    public SearchResultPage clickSearch () {
        function.clickElement(btnSearch);
        return new SearchResultPage(driver);
    }

	public MainPage goToMainPage() {
		driver.get(link);
		function.waitForJStoLoad();
		return new MainPage(driver);
	}

}

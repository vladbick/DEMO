package lv.bb.reklama.demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lv.bb.reklama.demo.util.Functions;

public class CarBrandsPage extends BasePage {
	
	public CarBrandsPage(WebDriver driver) {
		super(driver);
	}
	
	Functions function = new Functions(driver);
	
    @FindBy(xpath = "//a[@href=\"/ru/transport/cars/audi/menus.html\"]")
    private WebElement lnkAudiMenu;
    
    public CarModelPage clickAudiMenu () {
        function.clickElement(lnkAudiMenu);
        return new CarModelPage(driver);
    }


}

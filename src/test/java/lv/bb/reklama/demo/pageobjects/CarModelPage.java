package lv.bb.reklama.demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lv.bb.reklama.demo.util.Functions;

public class CarModelPage extends BasePage{

	public CarModelPage(WebDriver driver) {
		super(driver);
	}
	
	Functions function = new Functions(driver);
	
    @FindBy(xpath = "//a[@href=\"/ru/transport/cars/audi/80/table.html\"]")
    private WebElement lnkAudi80Menu;

	public CarListPage clickA8Menu() {
		function.clickElement(lnkAudi80Menu);
        return new CarListPage(driver);
	}
}

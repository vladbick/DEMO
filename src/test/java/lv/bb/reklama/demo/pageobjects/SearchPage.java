package lv.bb.reklama.demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lv.bb.reklama.demo.util.Functions;

public class SearchPage extends BasePage {
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	Functions function = new Functions(driver);
	
	@FindBy(name = "s_andlike_txt_bigtext")
    private WebElement txtInput;
	
	@FindBy(xpath = "(//input[@name=\"s_minmax_price_num_cost[]\"])[1]")
    private WebElement txtPriceFrom;
	
	@FindBy(xpath = "(//input[@name=\"s_minmax_price_num_cost[]\"])[2]")
    private WebElement txtPriceTo;
	
	@FindBy(xpath = "//input[@name=\"btnSearch\"][@type=\"submit\"][@onclick=\"return testSearch()\"]")
	private WebElement btnSearch;
	
    public SearchPage typePriceFrom (float priceFrom) {
        function.typeText(txtPriceFrom, Float.toString(priceFrom));
        return new SearchPage(driver);
    }

    public SearchPage typePriceTo (float priceTo) {
        function.typeText(txtPriceTo, Float.toString(priceTo));
        return new SearchPage(driver);
    }
    
    public SearchPage typeSearchInput (String text) {
        function.typeText(txtInput, text);
        return new SearchPage(driver);
    }
    
    public SearchResultPage clickSearchButton () {
    	function.clickElement(btnSearch);
    	return new SearchResultPage(driver);
    }
}

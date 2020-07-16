package lv.bb.reklama.demo.stepdefs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lv.bb.reklama.demo.pageobjects.CarBrandsPage;
import lv.bb.reklama.demo.pageobjects.AdDetailsPage;
import lv.bb.reklama.demo.pageobjects.BasePage;
import lv.bb.reklama.demo.pageobjects.CarListPage;
import lv.bb.reklama.demo.pageobjects.CarModelPage;
import lv.bb.reklama.demo.pageobjects.FavouritesPage;
import lv.bb.reklama.demo.pageobjects.MainPage;
import lv.bb.reklama.demo.pageobjects.SearchPage;
import lv.bb.reklama.demo.pageobjects.SearchResultPage;
import lv.bb.reklama.demo.util.FunctionalTest;
import lv.bb.reklama.demo.util.Functions;

public class FavouritesStepDef extends FunctionalTest {
	
	@Before
	public void init() {
		super.setUp();
	}
	
	@After
	public void tearDown() {
		super.tearDown();
	}
	
	String adText;
	int numberOfFavourites;
	
	@Given("I am on a main page")
	public void i_am_on_a_main_page() {
		MainPage mainPage = new MainPage(driver);
		mainPage.goToMainPage();
		numberOfFavourites = 0;
	}
	
	@When("I click on auto ad section")
	public void i_click_on_auto_ad_section() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickAutoMenu();
	}
	
	@And("click on audi car manufacturer")
	public void click_on_audi_car_manufacturer() {
		CarBrandsPage carBrandsPage = new CarBrandsPage(driver);
		carBrandsPage.clickAudiMenu();
	}
	
	@And("click on A8 model")
	public void click_on_A8_model() {
		CarModelPage carModelPage = new CarModelPage(driver);
		carModelPage.clickA8Menu();
	}
	
	@And("click on ad number {int}")
	public void click_on_add_number_int(int adNumber) {
		CarListPage carListPage = new CarListPage(driver);
		AdDetailsPage adDetailsPage = carListPage.clickOnAd(adNumber);
		String text = adDetailsPage.getAdText();
		if (text.length() > 100) {
			adText = text.substring(4, 100);
		}
		else {
			adText = text;
		}
	}
	
	@And("I scroll down to see add/remove to/from favourites button")
	public void i_scroll_down_to_see_add_remove_from_favourites_button() {
		AdDetailsPage AdDetailsPage = new AdDetailsPage(driver);
		AdDetailsPage.scrollToAddRemoveFavouritesLink();
	}
	
	@And("click on add/remove to/from favourites button")
	public void click_on_add_to_favourites_button() {
		AdDetailsPage AdDetailsPage = new AdDetailsPage(driver);
		AdDetailsPage.clickAddRemoveToFavouritesLink();
	}
	
	@Then("^number of favourites (increased|decreased) by (\\d+?)$")
	public void number_of_favourites_increases(String resultType, int number) {
		BasePage basePage = new BasePage(driver);
		if (resultType.equals("increased")) {
			assertEquals(numberOfFavourites+number, basePage.getNumberOfFavourites());
		}
		else if (resultType.equals("decreased")) {
			assertEquals(numberOfFavourites-number, basePage.getNumberOfFavourites());
		}
	}
	
	@And("ad appears in favourites first in list")
	public void ad_appears_in_favourites_first_in_list() {
		FavouritesPage favouritesPage = new AdDetailsPage(driver).clickFavouritesLink();
		assertTrue(favouritesPage.getFirstElementText().contains(adText));
	}
	
	@When("I open extended search")
	public void i_open_extended_search() {
		MainPage mainPage = new MainPage(driver);
		mainPage.clickExtendedSearchLink();
	}
	
	@And("type price from {float}")
	public void type_price_from_float(float priceFrom) {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.typePriceFrom(priceFrom);
	}
	
	@And("type price to {float}")
	public void type_price_to_float(float priceTo) {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.typePriceFrom(priceTo);
	}
	
	@And("type search for {string}")
	public void type_search_for_string(String text) {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.typeSearchInput(text);
	}

	@And("click search")
	public void click_search() {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.clickSearchButton();
	}
	
	@And("add {int} ads from a list")
	public void add_int_ads_from_a_list(int numberOfAds) {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		searchResultPage.addToFavourites(numberOfAds);
	}
	
	@Given("I have {int} ads in my favourites")
	public void i_have_int_ads_in_my_favourites(int numberOfAds) {
		MainPage mainPage = new MainPage(driver);
		mainPage.goToMainPage();
		SearchResultPage resultPage = mainPage.clickSearch();
		resultPage.addToFavourites(numberOfAds);
		numberOfFavourites = numberOfAds;
	}
	
	@When("I click on view favourites")
	public void i_click_on_view_favourites() {
		SearchResultPage searchResultPage = new SearchResultPage(driver);
		searchResultPage.clickFavouritesLink();
	}
	
	@And("click remove all ads from favourites")
	public void click_remove_all_ads_from_favourites() {
		FavouritesPage favouritesPage = new FavouritesPage(driver);
		favouritesPage.clickRemoveAllFavourites();
	}
	
	@And("remove ad number {int} from a list")
	public void remove_ad_number_int_from_a_list(int adNumber) {
		FavouritesPage favouritesPage = new FavouritesPage(driver);
		favouritesPage.removeAd(adNumber);
	}
	
	@And("click on ad number {int} in favourites")
	public void click_on_ad_number_int_in_favourites(int adNumber) {
		FavouritesPage favouritesPage = new FavouritesPage(driver);
		favouritesPage.clickOnAd(adNumber);
		Functions function = new Functions(driver);
		function.switchHandles(1);
	}
}
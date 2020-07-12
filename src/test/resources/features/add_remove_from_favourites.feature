Feature: add, remove to favourites
	Adding ads to favourites in different ways and removing them from favourites
	
	@demo
	Scenario: Add a single ad to favourites
		Given I am on a main page
		When I click on auto ad section
		And click on audi car manufacturer
		And click on A8 model
		And click on ad number 1
		And I scroll down to see add to favourites button
		And click on add to favourites button
		Then number of favourites increased by 1
		And ad appears in favourites first in list
		
	@demo
	Scenario: Search for ads and add them from a list
		Given I am on a main page
		When I open extended search
		And type price from 500.0
		And type price to 5000.0
		And type search for "audi"
		And click search
		And add 2 ads from a list
		Then number of favourites increased by 2
		
	@demo
 	Scenario: Remove ads from favourites one by one
		Given I have 2 ads in my favourites
		When I click on view favourites
		And remove ad number 1 from a list
		And click on ad number 2 in favourites
		And I scroll down to see remove from favourites button
		And click on remove from favourites button
		Then number of favourites decreased by 2
	
	@demo
	Scenario: Remove all ads from favourites
		Given I have 3 ads in my favourites
		When I click on view favourites
		And click remove all ads from favourites
		Then number of favourites decreased by 3
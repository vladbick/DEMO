package lv.bb.reklama.demo.test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags = "@demo",
		features = "src/test/resources/features/add_remove_from_favourites.feature",
		glue = {"lv.bb.reklama.demo.stepdefs"})
public class TestRunnerDemo {
	
}

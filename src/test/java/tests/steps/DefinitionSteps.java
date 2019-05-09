package tests.steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import tests.steps.serenity.UserSteps;

public class DefinitionSteps {

    @Steps
    UserSteps user;

    @Given("the user is on the Google home page")
    public void givenTheUserIsOnTheWiktionaryHomePage() {
        user.is_on_the_home_page();
    }

    @When("the user looks up the definition of the word '(.*)'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        user.looks_for(word);
    }

    @Then("they should see the definition '(.*)'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        user.should_see_definition(definition);
    }
    @When("^I capture all the links containing Adaptavist$")
    public void i_capture_all_the_links_containing_adaptavist()  {
        user.collect_links();
    }
    @And("^I navigate to each of them$")
    public void i_navigate_to_each_of_them() {
       user.navigate_to_each_link();
    }


}

package Stepdefinitions;

import Pages.Baseclass;
import Pages.Projectspage;
import Utilities.Utility;
import io.cucumber.java.en.Then;

import java.util.Map;

public class DSprojectstepdefinition extends Baseclass {

    private Projectspage pp = new Projectspage(driver);

    Utility utility = new Utility();

    @Then("I click on create project button")
    public void i_click_on_create_project_button() {
        pp.click_on_createproject();

    }

    @Then("I enter Project Title as a unique value")
    public void iEnterProjectTitleAsAUniqueValue() {
        pp.enter_project_title();
    }

    @Then("I enter State Project number as unique value")
    public void iEnterStateProjectNumberAsUniqueValue() {
        pp.enter_state_project_number();

    }

    @Then("I enter Federal Project number as {string}")
    public void i_enter_federal_project_number_as(String message) {
        pp.enterfederalprojectnumber(message);
    }

    @Then("I enter Project description as {string}")
    public void i_enter_project_description_as(String message) {
        pp.enterProjectDescription(message);
    }

    @Then("I enter motorist notification as {string}")
    public void i_enter_motorist_notification_as(String message) {
        pp.entermotoristnotification(message);

    }

    @Then("I validate the success message is shown after project creation")
    public void i_validate_the_success_message_is_shown_after_project_creation() {

        pp.validate_success_msg();

    }


    @Then("I click on create project button inside")
    public void iClickOnCreateProjectButtonInside() {
        pp.createprojectbuttoninside();
    }


}

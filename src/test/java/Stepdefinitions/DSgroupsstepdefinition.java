package Stepdefinitions;

import Pages.Baseclass;
import Pages.Groupspage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DSgroupsstepdefinition extends Baseclass {

    Groupspage gp = new Groupspage(driver);

    @Then("I click on Groups icon and navigate to groups page")
    public void i_click_on_gropus_icon_and_navigate_to_groups_page() {

        gp.clickongroups();

    }

    @And("I validate I landed on Groups Page")
    public void iValidateILandedOnGroupsPage() {

        gp.validate_groups_text();

    }

    @Then("I click on create Group button")
    public void iClickOnCreateGroupButton() {
        gp.click_on_create_grp();
    }

    @Then("enter group title and group description")
    public void enterGroupTitleAndGroupDescription() {
        gp.entergrptitle_and_grpdesc();

    }

    @Then("I click on save button")
    public void iClickOnSaveButton() {

        gp.click_on_Save();
    }

    @Then("I validate success message is shown after group creation")
    public void iValidateSuccessMessageIsShownAfterGroupCreation() {

        gp.validate_success_msg();
    }

    @Then("I click on back button from groups page")
    public void iClickOnBackButtonFromGroupsPage() {
        gp.click_on_back_btn();

    }

    @Then("I validate the created group is there in the list")
    public void iValidateTheCreatedGroupIsThereInTheList() {
        gp.Fetch_groups_list();
    }

    @Then("I click on delete button for the created group and click on delete")
    public void iClickOnDeleteButtonForTheCreatedGroupAndClickOnDelete() {
        gp.clickondeletebutton();

    }

    @And("I validate success message is shown after group deletion")
    public void iValidateSuccessMessageIsShownAfterGroupDeletion() {
        gp.deleted_success_msg();
    }


    @Then("I go to view recently deleted groups tab and I check for the deleted group")
    public void iGoToViewRecentlyDeletedGroupsTabAndICheckForTheDeletedGroup() {
        gp.fetch_deleted_groups_list();
    }

    @Then("I click on Restore group from the list")
    public void iClickOnRestoreGroupFromTheList() {
        gp.restoreGroup();
    }

    @Then("I click on View active groups button")
    public void iClickOnViewActiveGroupsButton() {
        gp.click_on_activegroups();
    }

    @And("Validate restored group is present in the active group list")
    public void validateRestoredGroupIsPresentInTheActiveGroupList() {
        gp.validate_restored_group_in_list();
    }

    @And("I validate the success message on group restoration")
    public void iValidateTheSuccessMessageOnGroupRestoration() {
        gp.restore_success_msg();

    }

    @Then("I click on Staffing button")
    public void iClickOnStaffingButton() {
        gp.click_onstaffing_btn();
    }

    @Then("I fetch the count before adding an employee")
    public void iFetchTheCountBeforeAddingAnEmployee() {
        gp.validate_count_before_adding();
    }

    @Then("I click on Add employee button")
    public void iClickOnAddEmployeeButton() {
        gp.click_on_add_button_staffing();
    }

    @Then("I Validate the count of employees after adding")
    public void iValidateTheCountOfEmployeesAfterAdding() {
        gp.validate_count_After_Adding();
    }

    @Then("I validate the success message on adding an employee")
    public void iValidateTheSuccessMessageOnAddingAnEmployee() {
        gp.validate_success_message_after_Adding();
    }
}

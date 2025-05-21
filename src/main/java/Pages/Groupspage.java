package Pages;

import Utilities.Utility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Groupspage extends Baseclass {

    Utility utility;

    String title;
    String desc;

    String employees_unassigned_count_before;

    String employees_unassigned_count_after;

    @FindBy(xpath = "//a[@href='/admin/groups']")
    WebElement btn_groups;

    @FindBy(xpath = "//h1[text()='Groups']")
    WebElement txt_groups;

    @FindBy(xpath = "//span[text()='Create Group']")
    WebElement btn_create_group;

    @FindBy(xpath = "//label[text()='Group Name']/parent::div//div/input")
    WebElement txt_grptitle;

    @FindBy(xpath = "//label[text()='Group Description']/parent::div//div/input")
    WebElement txt_grpdesc;

    @FindBy(xpath = "//span[text()='Save']")
    WebElement btn_save;

    @FindBy(xpath = "//div[text()='Group created']")
    WebElement success_msg;

    @FindBy(xpath = "//span[text()='Group Staffing']/parent::button")
    WebElement btn_staffing;

    @FindBy(xpath = "//a[@role='button']")
    WebElement btn_back;

    @FindBy(xpath = "//span[text()='Yes, Delete Group']")
    WebElement btn_delete_popup;

    @FindBy(xpath = "//div[text()='Group successfully deleted']")
    WebElement del_success_msg;

    @FindBy(xpath = "//span[text()='View Recently Deleted Groups']")
    WebElement btn_recent_deleted_groups;

    @FindBy(xpath = "//span[text()='Yes, Restore Group']")
    WebElement btn_restore_popup;

    @FindBy(xpath = "//div[text()='Group successfully restored']")
    WebElement success_msg_restore;

    @FindBy(xpath = "//span[text()='View Active Groups']")
    WebElement btn_active_grp;

    @FindBy(xpath = "//span[text()='Add']")
    WebElement btn_staffing_add;

    @FindBy(xpath = "//p[text()='Members']/following::p")
    WebElement txt_members_assigned;

    @FindBy(xpath = "//p[text()='Employees']/following::p")
    WebElement txt_employees_actul_count;




    public void clickongroups() {
        btn_groups.click();
    }

    public void validate_groups_text() {
        String expected = "Groups";
        String actual = txt_groups.getText();
        Assert.assertEquals(actual, expected);
    }

    public void click_on_create_grp() {
        btn_create_group.click();
    }

    public void entergrptitle_and_grpdesc() {
        Map<String, String> entervalue = utility.getUniqueGroupData();
        title = entervalue.get("GroupTitle");
        desc = entervalue.get("GroupDescription");
        txt_grptitle.sendKeys(title);
        System.out.println(title);
        txt_grpdesc.sendKeys(desc);
    }

    public void click_on_Save() {
        utility.pageLoadTimeImplicity();
        btn_save.click();
    }

    public void validate_success_msg() {

        utility.pageLoadTimeImplicity();
        String expected = "Group created";
        String actual = success_msg.getText();
        Assert.assertEquals(actual, expected);
    }

    public void click_on_back_btn() {
        btn_back.click();
    }

    public void Fetch_groups_list() {
        String expected = title;
        System.out.println("title is :" + title);
        utility.pageLoadTimeImplicity();

        WebElement createdgrp = driver.findElement(By.xpath("//p[text()='" + title + "']"));
        boolean result1 = createdgrp.isDisplayed();
        System.out.println(result1);

        List<WebElement> groupslist = driver.findElements(By.xpath("//p[text()='" + title + "']"));
        boolean result = false;

        for (WebElement list : groupslist) {
            System.out.println(list.getText());
            if (list.getText().equals(expected)) {
                result = true;
                break;
            }
        }
        if (!result) {
            Assert.fail("Group title not found in the list: " + expected);
        }


    }

    public void clickondeletebutton() {

        btn_back.click();
        WebElement btn_delete = driver.findElement(By.xpath("//p[text()='" + title + "']//following::button"));
        btn_delete.click();
        btn_delete_popup.click();

    }

    public void deleted_success_msg() {
        String expected = "Group successfully deleted";
        utility.pageLoadTimeImplicity();
        String actual = del_success_msg.getText();
        Assert.assertEquals(actual, expected);
    }

    public void fetch_deleted_groups_list() {
        utility.pageLoadTimeImplicity();
       utility.scrollToTopAndClickWithWait(btn_recent_deleted_groups);


        System.out.println("Deleted group title is: " + title);
        utility.pageLoadTimeImplicity();

        try {
            // Locate the deleted group element
            WebElement deletedGrp = driver.findElement(By.xpath("//p[text()='" + title + "']"));

            // Check if the deleted group is displayed
            boolean result = deletedGrp.isDisplayed();
            System.out.println("Is deleted group displayed: " + result);

            // Assert to fail if the group is not displayed
            Assert.assertTrue("Deleted group is not visible in the list", result);

        } catch (NoSuchElementException e) {
            // Fail the test if the deleted group is not found
            Assert.fail("Deleted group not found in the list: " + title);
        }


    }

    public void restoreGroup() {
        WebElement btn_restore = driver.findElement(By.xpath("//p[text()='" + title + "']//following::button"));
        btn_restore.click();
        btn_restore_popup.click();
        utility.pageLoadTimeImplicity();

    }

    public void restore_success_msg() {
        utility.pageLoadTimeImplicity();
        String expected = "Group successfully restored";
        utility.pageLoadTimeImplicity();
        String actual = success_msg_restore.getText();
        Assert.assertEquals(actual, expected);
    }

    public void click_on_activegroups() {
        btn_active_grp.click();
    }

    public void validate_restored_group_in_list() {

        System.out.println("Restored group title is: " + title);
        utility.pageLoadTimeImplicity();

        try {

            WebElement restoredGrp = driver.findElement(By.xpath("//p[text()='" + title + "']"));


            boolean result = restoredGrp.isDisplayed();
            System.out.println("Is restored group displayed: " + result);


            Assert.assertTrue("Restored group is not visible in the list", result);

        } catch (NoSuchElementException e) {

            Assert.fail("Restored group not found in the list: " + title);
        }


    }

    public void click_onstaffing_btn()
    {
        btn_staffing.click();
    }

    public void validate_success_message_after_Adding()
    {
        String actual = "Employee successfully added to group";
        utility.pageLoadTimeImplicity();
        WebElement success   = driver.findElement(By.xpath("//div[text()='Employee successfully added to group']"));
        String expected = success.getText();
        Assert.assertEquals("String is not a valid string ",actual,expected);
    }

    public void validate_count_before_adding()  {

        WebElement visible = driver.findElement(By.xpath("//div[@class='MuiCardContent-root']/ul/li"));

        utility.elementVisibilityOf(visible);
        utility.elementVisibilityOf(txt_employees_actul_count);
        String count = txt_employees_actul_count.getText();
        System.out.println("Count is :"+ count);
    }

    public void click_on_add_button_staffing()

    {
        utility.pageLoadTimeImplicity();
        try {

            btn_staffing_add.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException encountered. Retrying...");
            btn_staffing_add.click();
        }
    }

    public void validate_count_After_Adding()
    {

        utility.pageLoadTimeImplicity();
        employees_unassigned_count_after =txt_employees_actul_count.getText(); //18
        int employees_unassigned_count_after_arit = Integer.parseInt(employees_unassigned_count_after);
        Assert.assertEquals("Employee count did not update correctly after adding.",employees_unassigned_count_before,employees_unassigned_count_after_arit + 1);

    }


    public Groupspage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        utility = new Utility();

    }

}

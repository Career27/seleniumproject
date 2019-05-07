package com.dlg.steps;

import com.dlg.covercheck.pageFactory.CovercheckPageFactory;
import com.dlg.web.env.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class dlgSteps implements BaseTest {

    CovercheckPageFactory coverCheck = new CovercheckPageFactory(driver);

//    RequirementUtils requtil = new RequirementUtils();
//    public static final String baseURL = "https://covercheck.vwfsinsuranceportal.co.uk/";
    String WEB_URL = requtil.getEnvPropertyValue("WEB_URL");

    @Given("^User navigates to cover check page$")
    public void user_navigates_to_cover_check_page() throws InterruptedException {
        driver.get(WEB_URL);
    }

    @Then("^User checks for page title as \"([^\"]*)\"$")
    public void user_validates_page_title_as(String pgTitle) throws InterruptedException {
        WebElement title = driver.findElement(By.id("dlg-dealersearch-title"));
        String pageTitle = title.getText();
        Assert.assertEquals(pgTitle,pageTitle);
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^User checks for page subtitle as \"([^\"]*)\"$")
    public void user_validates_page_subtitle_as(String pgSubTitle) throws InterruptedException {
        WebElement subTitle = driver.findElement(By.id("dlg-dealersearch-subtitle"));
        String pageSubTitle = subTitle.getText();
        Assert.assertEquals(pgSubTitle, pageSubTitle);
    }

    @When("^User enters the vehicle registration number as \"([^\"]*)\"$")
    public void user_enters_the_vehicle_registration_number_as(String vehicleReg) throws InterruptedException {
        WebElement txtBoxRegistration = driver.findElement(By.name("vehicleReg"));
        txtBoxRegistration.sendKeys(vehicleReg);
    }

    @When("^User clicks on Find Vehicle button$")
    public void user_clicks_on_Find_Vehicle_button() throws InterruptedException {
        WebElement btnFindVehicle = driver.findElement(By.name("btnfind"));
        btnFindVehicle.click();
    }

    @Then("^User checks for CoverStartDate as \"([^\"]*)\" and CoverEndDate as \"([^\"]*)\" in search result$")
    public void user_checks_for_CoverStartDate_as_and_CoverEndDate_as(String startDate, String endDate) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement txtCoverStartDate = driver.findElement(By.xpath("//*[@id='page-container']/div[4]/div[2]/span"));
        String coverStartDate = txtCoverStartDate.getText();
        Assert.assertEquals(startDate,coverStartDate);

        WebElement txtCoverEndDate = driver.findElement(By.xpath("//*[@id='page-container']/div[4]/div[3]/span"));
        String coverEndDate = txtCoverEndDate.getText();
        Assert.assertEquals(endDate, coverEndDate);
    }



    @When("^User clicks on \"([^\"]*)\" button$")
    public void user_clicks_on_button(String arg1) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^User checks for search result message as \"([^\"]*)\"$")
    public void user_checks_for_search_result_message_displayed_as(String searchResult) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
//        WebElement searchMessage = driver.findElement(By.xpath("//*[@id='page-container']/div[4]"));
        WebElement searchMessage = driver.findElement(By.className("result"));
        String result = searchMessage.getText();
        Assert.assertEquals(searchResult,result);
    }

    @Then("^User checks the search result message for invalid registation as \"([^\"]*)\"$")
    public void user_checks_for_search_result_message_for_invalid_registation_as(String arg1) throws InterruptedException {
        WebElement errorMsg = driver.findElement(By.className("error-required"));
        String erMessage = errorMsg.getText();
        Assert.assertEquals(arg1, erMessage);
    }


    @Then("^User checks for Please enter a valid car registration message$")
    public void user_checks_for_Please_enter_a_valid_car_registration_message()throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
    }

}

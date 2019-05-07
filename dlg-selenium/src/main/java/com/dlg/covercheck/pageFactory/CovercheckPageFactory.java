package com.dlg.covercheck.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static com.dlg.web.env.BaseTest.wait;

public class CovercheckPageFactory {

    WebDriver driver;

    @FindBy(how = How.ID, using="dlg-dealersearch-title")
    WebElement pageTitle;

    @FindBy(id="dlg-dealersearch-subtitle")
    WebElement pageSubTitle;

    @FindBy(id="vehicleReg")
    WebElement txtVehicleReg;

    @FindBy(name="btnfind")
    WebElement btnfindVehicle;

    @FindBy(xpath=".//*[@id='page-container']/div[4]/div[1]")
    WebElement searchResultFor;

    @FindBy(xpath=".//*[@id='page-container']/div[4]/div[2]/span")
    WebElement coverStartDate;

    @FindBy(xpath=".//*[@id='page-container']/div[4]/div[3]/span")
    WebElement coverEndtDate;

 //		WebDriverWait wait = new WebDriverWait(driver, 15);

    public CovercheckPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String txtPageTitle(){
        String pgTitle = pageTitle.getText();
        System.out.println(pgTitle);
        return driver.getTitle();
    }

    public void txtPageSubTitle(){
        String pgSubTitle = pageSubTitle.getText();
        System.out.println(pgSubTitle);
    }

    public void setVehicleReg(String vehicleReg){
        txtVehicleReg.clear();
        txtVehicleReg.sendKeys(vehicleReg);
    }

    public void clickFindVehicle(){
        btnfindVehicle.click();
    }

    public void txtSearchResultFor(){
        wait.until(ExpectedConditions.visibilityOf(this.searchResultFor));
        String resulttext = searchResultFor.getText();
        System.out.println(resulttext);
    }

    public void txtCoverStartDate(){
        String StartDate = coverStartDate.getText();
        System.out.println(StartDate);
    }

    public void txtCoverEndDate(){
        String EndDate = coverEndtDate.getText();
        System.out.println(EndDate);
    }

}

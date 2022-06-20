package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FreeCarCheckPage extends AbstractDriverClass {

    @FindBy(id = "vrm-input")
    WebElement enterRegNum;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div/div/div/div/form/button")
    WebElement freeCarCheck;

    public WebElement getEnterRegNum(){
        return enterRegNum;
    }

    public void enterRegNumberandClick(String regNum) {

        enterRegNum.sendKeys(regNum);
        freeCarCheck.click();

    }

    public FreeCarCheckPage getObjects(){
        return createPage(FreeCarCheckPage.class);
    }

}

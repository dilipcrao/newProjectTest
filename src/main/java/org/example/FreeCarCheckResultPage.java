package org.example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FreeCarCheckResultPage extends AbstractDriverClass {



    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[1]/dt")
    WebElement Registration;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[1]/dd")
    WebElement RegistrationValue;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[2]/dt")
    WebElement Make;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[2]/dd")
    WebElement MakeValue;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[3]/dt")
    WebElement Model;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[3]/dd")
    WebElement ModelValue;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[4]/dt")
    WebElement Colour;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[4]/dd")
    WebElement ColourValue;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[5]/dt")
    WebElement Year;

    @FindBy(xpath = "//*[@id=\"m\"]/div[2]/div[3]/div[1]/div/span/div[2]/dl[5]/dd")
    WebElement YearValue;




    public String getRegistrationValue() {

        System.out.println(RegistrationValue.getText());
        return RegistrationValue.getText();
    }
    public String getMakeValue() {

        System.out.println(MakeValue.getText());
        return  MakeValue.getText();
    }
    public String getModelValue() {

        System.out.println(ModelValue.getText());
        return ModelValue.getText();
    }
    public String getColourValue() {

        System.out.println(ColourValue.getText());
        return ColourValue.getText();
    }
    public String getYearValue() {

        System.out.println(YearValue.getText());
       return  YearValue.getText();
    }

    public FreeCarCheckResultPage getObjects(){
        return createPage(FreeCarCheckResultPage.class);
    }

}

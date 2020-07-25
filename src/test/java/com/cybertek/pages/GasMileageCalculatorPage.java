package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GasMileageCalculatorPage {

    public GasMileageCalculatorPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "uscodreading")
    public WebElement currentOdo;

    @FindBy(id = "uspodreading")
    public WebElement previousOdo;

    @FindBy(id = "usgasputin")
    public WebElement gasInput;

  //  @FindBy(id = "usgasprice")
   // public WebElement priceButton;

    @FindBy(xpath = "(//input[@alt='Calculate'])[1]")
    public WebElement calculateButton;

    @FindBy(xpath = "//b[contains(text(),'mpg')]")
    public WebElement resultInGas;




}

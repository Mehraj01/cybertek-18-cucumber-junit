package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @Before(order = 2)
    public void setUpScenario(){
        System.out.println("-----> Before annotation: Setting up browser");
    }

    @Before(value = "@db",order = 1)
    public void setUpDatabaseConnection(){
        System.out.println("-----------------> BEFORE ANNOTATION: DB CONNECTION CREATED <------------------");
    }

    @After(order = 5)
    public void tearDownScenario(Scenario scenario){
        //System.out.println("-----> After annotation: Closing browser");
//        System.out.println("scenario.getName() = " + scenario.getName());
//        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
//        System.out.println("scenario.isFailed() = " + scenario.isFailed());

        //#1 we need to take screenshot using Selenium
        // getScreenshotAs: to be able to use this method we have to cast our driver type to TakesScreenshot
        //byte[]screenshot=( (TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        //# we are going to attach it into our report

        //#2 we are going to attach it into our report: using attach ,method
        //attach method accepts 3 arguments. #1: Screenshot itself #2: image type #3 current scenario's name

        if(scenario.isFailed()){// if the scenario is failed it will return true. In a first line inside of t
            // he if statement it will take screenshot and second line it will attached screenshot to our report.
            byte[]screenshot=( (TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }



    }

    @After(value = "@db", order = 4)
    public void tearDownDatabaseConnection(){
        System.out.println("-----------------> AFTER ANNOTATION: DB CONNECTION CLOSED <------------------");
    }

    @BeforeStep
    public void setUpStep(){
        System.out.println("============> BEFORESTEP: TAKING SCREENSHOT <===============");

    }

    @AfterStep
    public void tearDownStep(){
        System.out.println("============> AFTERSTEP: TAKING SCREENSHOT <===============");

    }



}

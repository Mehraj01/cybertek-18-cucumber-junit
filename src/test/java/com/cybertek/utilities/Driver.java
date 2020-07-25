package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

//We create Driver utilities using Singleton Design Pattern.
//-> How did we achieve singleton?
//-> We created private constructor, and created a method to return the instance of that class. (WebDriver)

//- A design pattern is not a framework. It is just the part of a framework.
//- Usually just another layer in our framework to make "something" easy to handle for ourselves.

public class Driver {// Singleton Class: private constructor and public getter method

    private Driver(){//1-Make constructor private
// Private constructor : ensures that none else can create an instance of the WebDriver
//	  -We will allow reach to this driver only through our getter method.
    }

    private static WebDriver driver;// private static variable


    public static WebDriver getDriver(){// getter method will allow read only

        if (driver == null){// if my driver is null. It will not create a drive if already were created
            String browser = ConfigurationReader.getProperty("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "chrome-remote":// Connection with Selenium Grid
                    try {
                        // same thing as ChromeOptions
                        //To request Selenium Grid to run tests on Chrome
                        //DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
                        //desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
                        ChromeOptions chromeOptions=new ChromeOptions();
                        URL url =new URL("http://54.237.219.12:4444/wd/hub");
                        driver= new RemoteWebDriver(url, chromeOptions);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

                case "firefox-remote":
                    try {
                        // to request grid to run tests on firefox
                        FirefoxOptions firefoxOptions=new FirefoxOptions();
                        URL url =new URL("http://54.237.219.12:4444/wd/hub");
                        driver= new RemoteWebDriver(url, firefoxOptions);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    throw new RuntimeException("Wrong browser name :: "+browser);

            }
        }

        return driver;

    }

    public static void closeDriver(){

        if(driver!=null){
            driver.quit();
            driver=null;
        }

    }




}

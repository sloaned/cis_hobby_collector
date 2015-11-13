package com.catalyst.collector.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by derekdelaney on 11/13/15.
 */
public class SeleniumSettings {

    private WebDriver driver;

    public SeleniumSettings(){
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/catalyst/collector/PageObjectFramework/Drivers/chromedriver");
        driver = new ChromeDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

}

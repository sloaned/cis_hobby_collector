package com.catalyst.collector.SeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;

/**
 * Created by derekdelaney on 11/16/15.
 */
public abstract class TestPageObject {
    protected WebDriver driver;
    SeleniumSettings seleniumSettings;

    @Before
    public void setup(){
        seleniumSettings = new SeleniumSettings();
        driver = seleniumSettings.getDriver();
    //    driver.navigate().refresh();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}

package com.catalyst.collector.PageObjectFramework.Pages;


import com.catalyst.collector.SeleniumFramework.Pages.IndexPage;
import com.catalyst.collector.SeleniumFramework.SeleniumSettings;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by ddelaney on 11/13/2015.
 */
public class FrontPage {
    private WebDriver driver;
    SeleniumSettings seleniumSettings;

    @Before
    public void setup(){
        seleniumSettings = new SeleniumSettings();
        driver = seleniumSettings.getDriver();
    }

    @Test
    public void checkThatItGoesToTheRightPage(){

        IndexPage index = new IndexPage(driver);

        String actualURL = index.getUrl();

        assertEquals("http://localhost:8080/", actualURL);
    }

    @Test
    public void checkThatThePageGetsTheTitle(){

        IndexPage index = new IndexPage(driver);

        String actualtitle = index.getTitle();

        assertEquals("Hobby Collector", actualtitle);
    }

}

package com.catalyst.collector.SeleniumFramework.Pages;

import com.catalyst.collector.SeleniumFramework.PageObject;
import org.openqa.selenium.WebDriver;

/**
 * Created by derekdelaney on 11/13/15.
 */
public class IndexPage extends PageObject {
    public IndexPage(WebDriver driver) {
        super(driver);
        goTo("http://localhost:8080");
    }
}

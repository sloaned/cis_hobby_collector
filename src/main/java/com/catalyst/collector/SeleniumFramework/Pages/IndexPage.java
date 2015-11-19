package com.catalyst.collector.SeleniumFramework.Pages;

import com.catalyst.collector.SeleniumFramework.PageObject;
import org.openqa.selenium.WebDriver;

public class IndexPage extends PageObject {
    public IndexPage(WebDriver driver) {
        super(driver);
        goTo("http://localhost:8080");
    }
}
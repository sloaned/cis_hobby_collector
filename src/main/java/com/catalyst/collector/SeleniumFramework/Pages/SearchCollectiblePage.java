package com.catalyst.collector.SeleniumFramework.Pages;

import com.catalyst.collector.SeleniumFramework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchCollectiblePage extends PageObject {
    public SearchCollectiblePage(WebDriver driver) {
        super(driver);
        goTo("http://localhost:8080/home");
    }

    public void clickSearchCollectible(){
        click(By.id("searchButton"));
    }
}
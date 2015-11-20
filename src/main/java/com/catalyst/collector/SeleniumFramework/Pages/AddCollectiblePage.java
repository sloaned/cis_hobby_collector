package com.catalyst.collector.SeleniumFramework.Pages;

import com.catalyst.collector.SeleniumFramework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCollectiblePage extends PageObject {
    public AddCollectiblePage(WebDriver driver) {
        super(driver);
        goTo("http://localhost:8080/home");
    }

    public void clickAddCollectible(){
        click(By.id("addCollectibleButton"));
    }

}
package com.catalyst.collector.SeleniumFramework.Pages;

import com.catalyst.collector.SeleniumFramework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by derekdelaney on 11/16/15.
 */
public class AddCollectiblePage extends PageObject {
    public AddCollectiblePage(WebDriver driver) {
        super(driver);
        goTo("http://localhost:8080");
    }

    public void clickAddCollectible(){
        click(By.linkText("Add Collectible"));
    }

}

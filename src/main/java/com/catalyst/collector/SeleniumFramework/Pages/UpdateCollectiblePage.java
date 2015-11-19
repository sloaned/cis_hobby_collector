package com.catalyst.collector.SeleniumFramework.Pages;

import com.catalyst.collector.SeleniumFramework.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ddelaney on 11/19/2015.
 */
public class UpdateCollectiblePage extends PageObject {
    public UpdateCollectiblePage(WebDriver driver) {
        super(driver);
        goTo("http://localhost:8080/home");
    }

    public void clickOnCatalogToEnableUpdate(){
        click(By.xpath("//*[@id='1']/td[1]/div[1]")); // click on the first catalog number.
    }
}

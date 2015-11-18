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
<<<<<<< .merge_file_a02272
        goTo("http://localhost:8080");
=======
        goTo("http://localhost:8080/home");
>>>>>>> .merge_file_a05328
    }

    public void clickAddCollectible(){
        click(By.id("addCollectibleButton"));
    }

}

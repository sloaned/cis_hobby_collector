package com.catalyst.collector.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by derekdelaney on 11/13/15.
 */
public abstract class PageObject {
    private WebDriver driver;

    //Shared XPaths
    private By BODY = By.xpath("//body");

    public PageObject(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Click the element at the given selector.
     * @param by - the by selector for the given element
     */
    public void click(By by){
        find(by).click();
    }

    /**
     * Finds the element by the given selector.
     * @param by - the by selector for the given element.
     * @return WebElement - the element found by the given by.
     */
    public WebElement find(By by){
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public String getInnerHtml(By by){
        return find(by).getText();
    }

    /**
     * Gets the text from the given locator.
     * @param by - the by selector for the given element.
     * @return String - the text at the given by.
     */
    public String getText(By by){
        return find(by).getText();
    }

    /**
     * Gets the title of the current page.
     * @return String - the title at teh current page.
     */
    public String getTitle(){
        return driver.getTitle();
    }

    /**
     * Gets the URL of the current page.
     * @return - String - the current URL.
     */
    public String getUrl(){
        return driver.getCurrentUrl();
    }

    /**
     * Go to the given URL.
     * @param url - the full url of the page you want ot visit
     */
    public void goTo(String url){
        driver.get(url);
    }

    /**
     * Inputs data into an input box
     * @param by - the by selector for the given element.
     * @param value - the text to input into the input box.
     */
    public void sendKeys(By by, String value){
        find(by).clear();
        find(by).sendKeys(value);
    }

    /**
     * Selects an option from a select box based on text.
     * @param by - the by selector for the given element.
     * @param text - the text to select by.
     */
    public void selectByText(By by, String text){
        Select select = new Select(find(by));
        select.selectByVisibleText(text);
    }

}

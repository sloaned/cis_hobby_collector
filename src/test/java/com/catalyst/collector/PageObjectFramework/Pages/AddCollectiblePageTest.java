package com.catalyst.collector.PageObjectFramework.Pages;

import com.catalyst.collector.SeleniumFramework.Pages.AddCollectiblePage;
import com.catalyst.collector.SeleniumFramework.TestPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class AddCollectiblePageTest extends TestPageObject {

    private static final String VALID_TYPE = "Validtype";
    private static final String VALID_COLOR = "Validcolor";
    private static final String VALID_CONDITION = "Validcondition";
    private static final String VALID_ERA = "Validera";
    private static final String VALID_DESCRIPTION = "Validdescription";
    private static final String VALID_NAME = "Validname";
    private static final String VALID_CATALOG_NUMBER = "MMM-123498767543";
    private static final String VALID_KEYWORDS = "keywords,are,fun,";
    private static final String VALID_PURCHASE_DATE = "10/10/1000";


    @Test
    public void addACollectibleToTheTableSuccessfullyTest() throws InterruptedException {
        AddCollectiblePage addCollectiblePage = new AddCollectiblePage(driver);

        WebElement iLoveSelenium = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='category']")));

        int current = driver.findElements(By.xpath("/html/body/div/div/table/tbody/tr")).size();
        int expected = current+1;


        String expectedType = VALID_CATALOG_NUMBER;
        addCollectiblePage.clickAddCollectible();
        addCollectiblePage.sendKeys(By.id("inputType"), VALID_TYPE);
        addCollectiblePage.sendKeys(By.id("inputColor"), VALID_COLOR);
        addCollectiblePage.sendKeys(By.id("inputCondition"), VALID_CONDITION);
        addCollectiblePage.sendKeys(By.id("inputAge"), VALID_ERA);
        addCollectiblePage.sendKeys(By.id("inputDescription"), VALID_DESCRIPTION);
        addCollectiblePage.sendKeys(By.id("inputName"), VALID_NAME);
        addCollectiblePage.sendKeys(By.id("inputCatalogNumber"), VALID_CATALOG_NUMBER);
        addCollectiblePage.sendKeys(By.id("inputKeywords"), VALID_KEYWORDS);
        addCollectiblePage.sendKeys(By.id("inputPurchaseDate"), VALID_PURCHASE_DATE);

        addCollectiblePage.click(By.id("submitAdd"));

        WebElement newRow = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='category'][contains(., 'Validtype')]")));
        int actual = driver.findElements(By.xpath("/html/body/div/div/table/tbody/tr")).size();
        assertEquals(expected, actual);
    }
}
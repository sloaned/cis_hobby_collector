package com.catalyst.collector.PageObjectFramework.Pages;

import com.catalyst.collector.SeleniumFramework.Pages.AddCollectiblePage;
import com.catalyst.collector.SeleniumFramework.TestPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

/**
 * Created by derekdelaney on 11/16/15.
 */
public class AddCollectiblePageTest extends TestPageObject {

    private static final String VALID_TYPE = "Validtype";
    private static final String VALID_COLOR = "Validcolor";
    private static final String VALID_CONDITION = "Validcondition";
    private static final String VALID_ERA = "Validera";
    private static final String VALID_DESCRIPTION = "Validdescription";
    private static final String VALID_NAME = "Validname";
    private static final String VALID_CATALOG_NUMBER = "MMM-123498767543";
    private static final String VALID_KEYWORDS = "keywords,are,fun,";


    @Test
    public void addACollectibleToTheTableSuccessfullyTest() throws InterruptedException {
        AddCollectiblePage addCollectiblePage = new AddCollectiblePage(driver);

        String expectedType = VALID_TYPE;
        addCollectiblePage.clickAddCollectible();
        addCollectiblePage.sendKeys(By.id("inputType"), VALID_TYPE);
        addCollectiblePage.sendKeys(By.id("inputColor"), VALID_COLOR);
        addCollectiblePage.sendKeys(By.id("inputCondition"), VALID_CONDITION);
        addCollectiblePage.sendKeys(By.id("inputAge"), VALID_ERA);
        addCollectiblePage.sendKeys(By.id("inputDescription"), VALID_DESCRIPTION);
        addCollectiblePage.sendKeys(By.id("inputName"), VALID_NAME);
        addCollectiblePage.sendKeys(By.id("inputCatalogNumber"), VALID_CATALOG_NUMBER);
        addCollectiblePage.sendKeys(By.id("inputKeywords"), VALID_KEYWORDS);

        addCollectiblePage.click(By.id("submitAdd"));

        WebElement newRow = new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/table/tbody/tr[7]/td[1]/div")));
        String actualType = newRow.getText();

        assertEquals(expectedType, actualType);
    }
}
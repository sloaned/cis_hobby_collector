package com.catalyst.collector.PageObjectFramework.Pages;

import com.catalyst.collector.SeleniumFramework.Pages.UpdateCollectiblePage;
import com.catalyst.collector.SeleniumFramework.TestPageObject;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class UpdateCollectiblePageTest extends TestPageObject {
    private static final String VALID_TYPE = "Validtype";
    private static final String VALID_COLOR = "Validcolor";
    private static final String VALID_CONDITION = "Validcondition";
    private static final String VALID_ERA = "Validera";
    private static final String VALID_DESCRIPTION = "Validdescription";
    private static final String VALID_NAME = "Validname";
    private static final String VALID_CATALOG_NUMBER = "UNI-123498767543";
    private static final String VALID_KEYWORDS = "keywords,are,fun";
    private static final String VALID_PURCHASE_DATE = "10/10/1000";
    private static final String INVALID_KEYWORDS = "keywords,,";
    private static final String INVALID_PURCHASE_DATE = "00/00/0000";

    @Test
    public void successTestUpdatingACollectibleOnTheTable() throws InterruptedException {
        String expectedText = "Success";
        UpdateCollectiblePage updateCollectiblePage = new UpdateCollectiblePage(driver);
        Thread.sleep(2000);
        updateCollectiblePage.clickOnCatalogToEnableUpdate();
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='CatalogNumber']/input"), VALID_CATALOG_NUMBER);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='name']/input"), VALID_NAME);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='category']/input"), VALID_TYPE);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='color']/input"), VALID_COLOR);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='condition']/input"), VALID_CONDITION);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='purchaseDate']/input"), VALID_PURCHASE_DATE);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='age']/input"), VALID_ERA);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='ellipsis description']/input"), VALID_DESCRIPTION);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='keywords']/input"), VALID_KEYWORDS);
        updateCollectiblePage.selectByText(By.xpath("//*[@id='1']/td[4]/div[2]/select"), "false");

        updateCollectiblePage.click(By.className("editSubmitButton"));
        Thread.sleep(1000);

        String actualText = updateCollectiblePage.find(By.xpath("//*[@id='toast-container']/div/div[1]")).getText();

        assertEquals(expectedText, actualText);
    }

    @Test
    public void failureTestUpdatingACollectibleOnTheTable() throws InterruptedException {
        String expectedText = "Error";
        UpdateCollectiblePage updateCollectiblePage = new UpdateCollectiblePage(driver);
        Thread.sleep(2000);
        updateCollectiblePage.clickOnCatalogToEnableUpdate();
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='CatalogNumber']/input"), VALID_CATALOG_NUMBER);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='name']/input"), VALID_NAME);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='category']/input"), VALID_TYPE);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='color']/input"), VALID_COLOR);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='condition']/input"), VALID_CONDITION);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='purchaseDate']/input"), INVALID_PURCHASE_DATE);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='age']/input"), VALID_ERA);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='ellipsis description']/input"), VALID_DESCRIPTION);
        updateCollectiblePage.sendKeys(By.xpath("//div[@class='keywords']/input"), INVALID_KEYWORDS);
        updateCollectiblePage.selectByText(By.xpath("//*[@id='1']/td[4]/div[2]/select"), "true");

        updateCollectiblePage.click(By.className("editSubmitButton"));

        Thread.sleep(1000);
        String actualText = updateCollectiblePage.find(By.xpath("//*[@id='toast-container']/div/div[1]")).getText();

        assertEquals(expectedText, actualText);
    }
}
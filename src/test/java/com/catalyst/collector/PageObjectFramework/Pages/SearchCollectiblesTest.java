package com.catalyst.collector.PageObjectFramework.Pages;
import com.catalyst.collector.SeleniumFramework.Pages.SearchCollectiblePage;
import com.catalyst.collector.SeleniumFramework.TestPageObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class SearchCollectiblesTest extends TestPageObject {
    private static final String VALID_TYPE = "arrowhead";
    private static final String VALID_COLOR = "green";
    private static final String VALID_CONDITION = "mint";
    private static final String VALID_ERA = "paleolithic";
    private static final String VALID_DESCRIPTION = "e";
    private static final String VALID_NAME = "Magazine";
    private static final String VALID_CATALOG_NUMBER = "AAA-123456789101";
    private static final String VALID_KEYWORD = "Shiny";


    @Test
    public void searchCollectiblePageForTypeArrowhead() throws InterruptedException {
        SearchCollectiblePage sCP = new SearchCollectiblePage(driver);
        WebElement wait = new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='category']")));
        int expected = driver.findElements(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='category'][contains(., 'Arrowhead')]")).size();
        sCP.clickSearchCollectible();
        sCP.sendKeys(By.id("collectibleSearch"), VALID_TYPE);
        sCP.click(By.id("submitSearch"));
        waitAndVerify(expected, sCP);

    }

    @Test
    public void searchCollectiblePageForGreenColor() throws InterruptedException {
        SearchCollectiblePage sCP = new SearchCollectiblePage(driver);
        WebElement wait = new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='color']")));
        int expected = driver.findElements(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='color'][contains(., 'Green')]")).size();
        sCP.clickSearchCollectible();
        sCP.sendKeys(By.id("colorSearch"), VALID_COLOR);
        sCP.click(By.id("submitSearch"));
        waitAndVerify(expected, sCP);

    }

    @Test
    public void searchCollectiblePageForMintCondition() throws InterruptedException {
        SearchCollectiblePage sCP = new SearchCollectiblePage(driver);
        WebElement wait = new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='condition']")));
        int expected = driver.findElements(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='condition'][contains(., 'Mint')]")).size();
        sCP.clickSearchCollectible();
        sCP.sendKeys(By.id("conditionSearch"), VALID_CONDITION);
        sCP.click(By.id("submitSearch"));
        waitAndVerify(expected, sCP);

    }

    @Test
    public void searchCollectiblePageForPaleolithicEra() throws InterruptedException {
        SearchCollectiblePage sCP = new SearchCollectiblePage(driver);
        WebElement wait = new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='age']")));
        int expected = driver.findElements(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='age'][contains(., 'Paleolithic')]")).size();
        sCP.clickSearchCollectible();
        sCP.sendKeys(By.id("eraSearch"), VALID_ERA);
        sCP.click(By.id("submitSearch"));
        waitAndVerify(expected, sCP);

    }

    @Test
    public void searchCollectiblePageForMagazineName() throws InterruptedException {
        SearchCollectiblePage sCP = new SearchCollectiblePage(driver);
        WebElement wait = new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='name']")));
        int expected = driver.findElements(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='name'][contains(., 'Magazine')]")).size();
        sCP.clickSearchCollectible();
        sCP.sendKeys(By.id("nameSearch"), VALID_NAME);
        sCP.click(By.id("submitSearch"));
        waitAndVerify(expected, sCP);

    }

    @Test
    public void searchCollectiblePageForShinyKeyword() throws InterruptedException {
        SearchCollectiblePage sCP = new SearchCollectiblePage(driver);
        WebElement wait = new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='keywords']")));
        int expected = driver.findElements(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='keywords'][contains(., 'Shiny')]")).size();
        sCP.clickSearchCollectible();
        sCP.sendKeys(By.id("keywordsSearch"), VALID_KEYWORD);
        sCP.click(By.id("submitSearch"));
        waitAndVerify(expected, sCP);

    }

    @Test
    public void searchCollectiblePageForCatalogNumber() throws InterruptedException {
        SearchCollectiblePage sCP = new SearchCollectiblePage(driver);
        WebElement wait = new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='CatalogNumber']")));
        int expected = driver.findElements(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='CatalogNumber'][contains(., 'AAA-123456789101')]")).size();
        sCP.clickSearchCollectible();
        sCP.sendKeys(By.id("catalogNumberSearch"), VALID_CATALOG_NUMBER);
        sCP.click(By.id("submitSearch"));
        waitAndVerify(expected, sCP);
    }

    @Test
    public void searchCollectiblePageForDescriptionWithE() throws InterruptedException {
        SearchCollectiblePage sCP = new SearchCollectiblePage(driver);
        WebElement wait = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='ellipsis description']")));
        int expected = driver.findElements(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='ellipsis description'][contains(., 'e')]")).size();
        sCP.clickSearchCollectible();
        sCP.sendKeys(By.id("descriptionSearch"), VALID_DESCRIPTION);
        sCP.click(By.id("submitSearch"));

        waitAndVerify(expected, sCP);
    }

    @Test
    public void searchCollectiblePageForStatusNotSold() throws InterruptedException {
        SearchCollectiblePage sCP = new SearchCollectiblePage(driver);
        WebElement wait = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='soldStatus']")));
        int expected = driver.findElements(By.xpath("/html/body/div/div/table/tbody/tr/td/div[@class='soldStatus'][contains(., 'False')]")).size();
        sCP.clickSearchCollectible();
        Select soldStatus = new Select(sCP.find(By.id("soldSearch")));
        soldStatus.selectByValue("notsold");
        sCP.click(By.id("submitSearch"));

        waitAndVerify(expected, sCP);
    }

    public void waitAndVerify(int expected, SearchCollectiblePage sCP) throws InterruptedException {
        WebElement newRow = new WebDriverWait(driver, 100).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/table/tbody")));
        Thread.sleep(1000);
        int actual = sCP.findElements(By.xpath("/html/body/div[1]/div/table/tbody/tr")).size();
        assertEquals(expected, actual);
    }


}
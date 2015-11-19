package com.catalyst.collector.PageObjectFramework.Pages;


import com.catalyst.collector.SeleniumFramework.Pages.IndexPage;
import com.catalyst.collector.SeleniumFramework.TestPageObject;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class FrontPage extends TestPageObject {

    @Test
    public void checkThatItGoesToTheRightPage(){

        IndexPage index = new IndexPage(driver);

        String actualURL = index.getUrl();

        assertEquals("http://localhost:8080/", actualURL);
    }

    @Test
    public void checkThatThePageGetsTheTitle(){

        IndexPage index = new IndexPage(driver);

        String actualtitle = index.getTitle();

        assertEquals("Hobby Collector Login", actualtitle);
    }



}
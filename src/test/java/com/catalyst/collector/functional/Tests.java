package com.catalyst.collector.functional;

import catalyst.PageObjectFramework.Framework.PageObjectTest;
import catalyst.PageObjectFramework.Models.FrontPage;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gstringfellow on 11/9/2015.
 */
public class Tests extends PageObjectTest {

    @Test
    public void AmIOnCorrectPageTest(){
        FrontPage fp = new FrontPage(getDriver());
        String expectedUrl = "http://localhost:8080/";
        String actualUrl = fp.getUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

    }
}

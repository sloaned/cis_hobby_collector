package catalyst.PageObjectFramework.Models;

import catalyst.PageObjectFramework.Framework.PageObject;
import org.openqa.selenium.WebDriver;

/**
 * Created by gstringfellow on 11/9/2015.
 */
public class FrontPage extends PageObject {
    public FrontPage(WebDriver driver) {
        super(driver);

        _url = "localhost:8080/";
        goTo(_url);
    }
}

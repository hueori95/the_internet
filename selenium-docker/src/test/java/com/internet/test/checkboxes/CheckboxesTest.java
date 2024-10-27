package com.internet.test.checkboxes;

import com.internet.page.Checkboxes.CheckboxesPage;
import com.internet.test.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxesTest extends AbstractTest {
    private CheckboxesPage checkboxesPage;

    @BeforeTest
    public void setPageObject() {
        checkboxesPage = new CheckboxesPage(driver);
    }
    @Test
    public void openpage(){
        checkboxesPage.goTo("http://localhost:7080/checkboxes");
        Assert.assertTrue(checkboxesPage.isAt());
    }

    @Test(dependsOnMethods = "openpage")
    public void veritycheckboxes(){
        Assert.assertFalse(checkboxesPage.is_selected_box1());
        Assert.assertTrue(checkboxesPage.is_selected_box2());

        checkboxesPage.clickoncheckbox1();
        Assert.assertTrue(checkboxesPage.is_selected_box1());

        checkboxesPage.clickoncheckbox2();
        Assert.assertFalse(checkboxesPage.is_selected_box2());
    }
}

package com.internet.test.dropdown;

import com.internet.page.Dropdown.DropdownPage;
import com.internet.test.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownTest extends AbstractTest {
    private DropdownPage dropdownPage;

    @BeforeTest
    public void setPageObject() {
        dropdownPage = new DropdownPage(driver);
    }
    @Test
    public void openpage(){
        dropdownPage.goTo("http://localhost:7080/dropdown");
        Assert.assertTrue(dropdownPage.isAt());
    }

    @Test(dependsOnMethods = "openpage")
    public void veritydropdownlist(){
        dropdownPage.workDropdownlist();
    }
}

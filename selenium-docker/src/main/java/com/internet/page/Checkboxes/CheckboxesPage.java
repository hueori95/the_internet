package com.internet.page.Checkboxes;

import com.internet.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckboxesPage extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(CheckboxesPage.class);
    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[text()='Checkboxes']")
    private WebElement titlepage;

    @FindBy(css = "#checkboxes>input:first-child")
    private WebElement checkbox1;

    @FindBy(css = "#checkboxes>input:last-child")
    private WebElement checkbox2;

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.titlepage));
        return this.titlepage.isDisplayed();
    }
    public void goTo(String url){
        this.driver.get(url);
    }

    public void clickoncheckbox1(){
        checkbox1.click();
    }

    public void clickoncheckbox2(){
        checkbox2.click();
    }
    public boolean is_selected_box1(){
        boolean islected =  checkbox1.isSelected();
        return islected;
    }
    public boolean is_selected_box2(){
        return checkbox2.isSelected();
    }
}

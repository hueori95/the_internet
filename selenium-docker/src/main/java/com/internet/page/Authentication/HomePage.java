package com.internet.page.Authentication;

import com.internet.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends AbstractPage {
    private  static final Logger log = LoggerFactory.getLogger(HomePage.class);
    @FindBy(xpath = "//div[@class='flash success']")
    private WebElement data_alert;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.data_alert));
        return this.data_alert.isDisplayed();
    }
}

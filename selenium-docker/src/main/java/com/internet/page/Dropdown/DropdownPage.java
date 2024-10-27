package com.internet.page.Dropdown;

import com.internet.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

import static java.lang.Thread.sleep;

public class DropdownPage extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(DropdownPage.class);
    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[text()='Dropdown List']")
    private WebElement titlepage;

    @FindBy(id = "dropdown")
    private WebElement dropdownElement;

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.titlepage));
        return this.titlepage.isDisplayed();
    }
    public void goTo(String url){
        this.driver.get(url);
    }

    public void workDropdownlist(){
        Select dropdown = new Select(dropdownElement);

        List<WebElement> options = dropdown.getOptions();

        for (WebElement option : options) {
            String optionText = option.getText();
            if(!optionText.equals("Please select an option")){
                dropdown.selectByVisibleText(optionText);
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                WebElement selectedOption = dropdown.getFirstSelectedOption();
                Assert.assertEquals(selectedOption.getText(), optionText, "Cannot select: " + optionText);
            }
        }
    }

}

package com.internet.page.Fileuploads;

import com.internet.page.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.Thread.sleep;

public class FileUploadsPage extends AbstractPage {
    private static final Logger log = LoggerFactory.getLogger(FileUploadsPage.class);
    public FileUploadsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[text()='File Uploader']")
    private WebElement titlepage;

    @FindBy(id = "file-upload")
    private WebElement fileInput;

    @FindBy(id = "file-submit")
    private WebElement submitbutton;

    @FindBy(xpath = "//h3[text()='File Uploaded!']")
    private WebElement successMessage;

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.titlepage));
        return this.titlepage.isDisplayed();
    }
    public void goTo(String url){
        this.driver.get(url);
    }

    public void uploadfilesfunction(){
        String filePath = Paths.get("src", "test", "resources", "test-data-upload", "1000.txt").toAbsolutePath().toString();

        fileInput.sendKeys(filePath);
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        submitbutton.click();

        Assert.assertTrue(successMessage.isDisplayed(), "File was not uploaded successfully.");

    }


}

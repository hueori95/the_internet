package com.internet.test.fileuploads;

import com.internet.page.Fileuploads.FileUploadsPage;
import com.internet.test.AbstractTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FileUploadsTest extends AbstractTest {
    private FileUploadsPage uploadpage;
    private String testDataPath;
    @BeforeTest
    public void setPageObject() {
        uploadpage = new FileUploadsPage(driver);
    }
    @Test
    public void openpage(){
        uploadpage.goTo("http://localhost:7080/upload");
        Assert.assertTrue(uploadpage.isAt());
    }

    @Test(dependsOnMethods = "openpage")

    public void verityfileupload(){
        uploadpage.uploadfilesfunction();
    }
}

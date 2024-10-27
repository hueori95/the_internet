package com.internet.test.authentication;

import com.internet.page.Authentication.HomePage;
import com.internet.page.Authentication.LoginPage;
import com.internet.test.AbstractTest;
import com.internet.test.authentication.model.AuthenticationTestData;
import com.internet.util.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AuthenticationTest extends AbstractTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private AuthenticationTestData testData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setPageObject(String testDataPath) {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        this.testData = JsonUtil.getTestData(testDataPath, AuthenticationTestData.class);
    }
    @Test
    public void logintest(){
        loginPage.goTo("http://localhost:7080/login");
        Assert.assertTrue(loginPage.isAt());
        loginPage.login(testData.getUsername(),testData.getPassword());
    }

    @Test(dependsOnMethods = "logintest")
    public void verityLogin(){
        if(testData.getLogin().equals("success"))
            Assert.assertTrue(homePage.isAt());
        else Assert.assertTrue(loginPage.isAtFaillogin());
    }
}

package com.internet.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.internet.listener.TestListener;
import com.internet.util.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Listeners({TestListener.class})
public abstract class AbstractTest {
    protected WebDriver driver;
    @BeforeTest
//    @Parameters("browser")
    public void setDriver(ITestContext ctx) throws MalformedURLException {
        if(Boolean.getBoolean("selenium.grid.enable")){
            this.driver = getRemoteDriver();
        }else {
            this.driver = getLocalDriver();
        }

        ctx.setAttribute(Constants.DRIVER, this.driver);
//        if(Boolean.getBoolean("selenium.grid.enable")){
//            this.driver = getRemoteDriver(browser);
//        }else {
//            this.driver = getLocalDriver();
//        }
    }

    private WebDriver getRemoteDriver() throws MalformedURLException {
        // http://localhost:4444
        Capabilities capabilities;
        if (System.getProperty("browser").equalsIgnoreCase("chrome"))
            capabilities = new ChromeOptions();
        else capabilities = new FirefoxOptions();

        return new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
    }
    private WebDriver getLocalDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        this.driver = new ChromeDriver(chromeOptions);
        return this.driver;
    }

    @AfterTest
    public void quiteDriver(){
        this.driver.quit();
    }

    @AfterMethod
    public void sleep(){
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }
}

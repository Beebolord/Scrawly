package com.company;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class FirstTestTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.Chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void firstTest() {
        driver.get("https://virtuo.ciussscn.rtss.qc.ca/GuichetWeb/");
        driver.manage().window().setSize(new Dimension(1055, 800));
        driver.findElement(By.cssSelector(".ng-touched")).sendKeys("510217");
        driver.findElement(By.cssSelector(".ng-touched")).sendKeys("510217");
        driver.findElement(By.cssSelector(".ng-untouched")).sendKeys("Satan258069911!");
        driver.findElement(By.cssSelector(".ng-untouched")).sendKeys(Keys.TAB);
    }
}

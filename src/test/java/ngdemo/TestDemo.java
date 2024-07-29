/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package ngdemo;

import dev.failsafe.internal.util.Assert;
import java.time.Duration;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import poms.PageYaPost;

/**
 *
 * @author Maxim
 */
public class TestDemo{
    
    private WebDriver driver;
    private String YaAdress = "https://passport.yandex.ru/registration?mode=register";
    private String GoogleAdress = "https://google.ru";
    private PageYaPost yaPost;
    
    
    public TestDemo() {
    }
  
    @Test(dependsOnMethods = {"google"})
    public void googleSearchFirst(){
       WebElement searchFirst = driver.findElement(By.xpath("//div[@id='rso']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/a[1]/h3[1]"));
       searchFirst.click();
       String namePage = driver.getTitle();
       org.testng.Assert.assertEquals(namePage, "Selenium", "Открылась не та страница!");
    }
    
    
    @Test
    public void google() {
        driver.navigate().to(GoogleAdress);
        WebElement query = driver.findElement(By.name("q"));
        query.sendKeys("selenium");
        query.sendKeys(Keys.ENTER);
    } 
    
    @Test(dependsOnMethods = {"OpenYaSite"})
    public void YaPost(){
        yaPost.sendName("Maxim");
        yaPost.sendLastName("Konovalov");
        yaPost.sendLogin("mn.konovalov2001");
        yaPost.sendPassword("testpassword2001@");
        yaPost.sendPasswordConfirm("testpassword2001@");
        yaPost.sendNumberPhone("9005326798");
        yaPost.clickButtonCreate();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='phoneCode']")));
        yaPost.sendNumberCode("2345");
        yaPost.clickButtonVerify();
    }
    
    @Test
    public void openYaSite(){
        driver.navigate().to(YaAdress);
        String namePage = driver.getTitle();
        org.junit.Assert.assertEquals(namePage, "Регистарция", "Открылась не та страница!");
    }
    
    @BeforeClass
    public void setUp(){
        System.setProperty("webdirver.chrome.driver", ".//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        yaPost = new PageYaPost(driver);
    }
}

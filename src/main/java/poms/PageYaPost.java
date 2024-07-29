/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poms;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Maxim
 */
public class PageYaPost {
    
    private WebDriver driver;
    
    @FindBy(id = "firstname")
    @CacheLookup
    WebElement name;
    
    @FindBy(id = "lastname")
    @CacheLookup
    WebElement lastName;
    
    @FindBy(id = "login")
    @CacheLookup
    WebElement login;
    
    @FindBy(id = "password")
    @CacheLookup
    WebElement pass;
    
    @FindBy(id = "password_confirm")
    @CacheLookup
    WebElement passConfirm;
    
    @FindBy(id = "phone")
    @CacheLookup
    WebElement number;
    
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/div[4]/span[1]/button[1]")
    @CacheLookup
    WebElement createButton;
    
    @FindBy(id = "phoneCode")
    @CacheLookup
    WebElement num;
    
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/main[1]/div[1]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[2]/button[1]")
    @CacheLookup
    WebElement verifyButton;
    
    
    public PageYaPost(WebDriver driver){
        this.driver = driver;
    }
    
    public void sendName(String name){
        this.name.sendKeys(name);
    }
    
    public void sendLastName(String lName){
        lastName.sendKeys(lName);
    }
    
    public void sendLogin(String log){
        login.sendKeys(log);
    }
    
    public void sendPassword(String pass){
        this.pass.sendKeys(pass);
    }
    
    public void sendPasswordConfirm(String passConf){
        passConfirm.sendKeys(passConf);
    }
    
    public void sendNumberPhone(String num){
        number.sendKeys(num);
    }
    
    public void sendNumberCode(String nums){
        num.sendKeys(nums);
    }
    public void clickButtonCreate(){
        createButton.sendKeys(Keys.ENTER);
    }
    
    public void clickButtonVerify(){
        verifyButton.sendKeys(Keys.ENTER);
    }
}

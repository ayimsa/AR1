package com.unitedcoder.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class MharaMultipleUserDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
       driver.get("https://demo.mahara.org/");
        ArrayList<String> userName=new ArrayList<>();
        userName.addAll(Arrays.asList("admin","student","learner","staff","sitestaff"));
       String password="MaharaDemo";
        for (int i=0;i<userName.size();i++){
            WebElement login=driver.findElement(By.id("login_login_username"));
            login.sendKeys(userName.get(i));
            Thread.sleep(1000);
                WebElement key=driver.findElement(By.id("login_login_password"));
                key.click();
                key.sendKeys(password);
              //WebElement  enter=driver.findElement(By.id("login_submit"))+Keys.ENTER;
              driver.findElement(By.id("login_submit")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/header/div/div/div[2]/div/button/span[2]")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("logoutbutton")).click();
            Thread.sleep(1000);
            WebElement messege=driver.findElement(By.xpath("//*[@id=\"messages\"]/div/div"));
            if (messege.isDisplayed()){
                System.out.println("Test is successful");
            }
        }

driver.close();
driver.quit();


    }
}

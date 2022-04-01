package com.unitedcoder.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
    public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
driver.manage().window().maximize();
   // driver.get("https://www.google.com");
      driver.navigate().to("https://www.amazon.com/");
      WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
     searchBox.sendKeys("iphone"+ Keys.ENTER);
      WebElement result= driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]"));
        System.out.println(result.getText());
        if(result.isDisplayed())
            System.out.println("Amazon search test is passed");
        else
            System.out.println("Amazon search test is failed!");
       // driver.close();
        driver.quit();
        }
    }


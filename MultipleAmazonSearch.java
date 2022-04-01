package com.unitedcoder.uiautomation;

import com.unitedcoder.classconcept.Products;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class MultipleAmazonSearch {
    public static void main(String[] args) {
      System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        DateTime beginTime=new DateTime();
        driver.navigate().to("https://www.amazon.com/");
        /*List<String> products=new ArrayList<>();
        products.add("java book");
        products.add("shoes");
        products.add("laptop");
        products.add("white bord pen");*/
        Products searchProducts=new Products();
        searchProducts.setProducts(new String[]{"java book","shoes","laptop","white bord pen"});
        int navigateCount=1;
        for (String value:searchProducts.getProducts()){
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        //searchBox.clear();
        searchBox.sendKeys(value+ Keys.ENTER);
        if (navigateCount<searchProducts.getProducts().length){
driver.navigate().back();}
navigateCount++;
        }
driver.close();
        driver.quit();
DateTime endTime=new DateTime();
        Period period=new Period(beginTime,endTime, PeriodType.seconds());
        System.out.println("Total test time is "+period.getSeconds());




    }
}

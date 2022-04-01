package com.unitedcoder.uiautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class WebDriverGoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        ArrayList<String> googleSearchWords=new ArrayList<>();
        googleSearchWords.add("Java");
        googleSearchWords.add("Java Tutorial");
        googleSearchWords.add("Selenium Master");
        googleSearchWords.add("Selenium Test Automation");
        googleSearchWords.add("Software Test Automation Engineer");
        for(String eachSearch: googleSearchWords) {
            //Define a Chrome Driver Instance
            WebDriver driver = new ChromeDriver();
            //Maximize Browser Window
            driver.manage().window().maximize();
            //Navigate to the Testing Website
            driver.get("https://www.google.com");
            //Find search text field
            driver.findElement(By.name("q")).sendKeys(eachSearch + Keys.ENTER);
            Thread.sleep(3000); //let the code sleep 3 seconds;
            String siteTitle = driver.getTitle();
            System.out.println(siteTitle.contains(eachSearch));
            //get the search result status
            String result = driver.findElement(By.id("resultStats")).getText();
            System.out.println(result);
            //get only numbers from the search result   About 3,710,000 results
            String totalSearchResult = result.substring(0, result.indexOf('r'));
            totalSearchResult = totalSearchResult.replace("About", "").
                    replace(",", "").trim();
            long totalCount = Long.parseLong(totalSearchResult);
            System.out.println(totalCount);
            System.out.print("At least one result is returned? ");
            System.out.print(totalCount > 1);
            //close driver
            driver.close();
            driver.quit();
        }




    }
}

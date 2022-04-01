package com.unitedcoder.uiautomation;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExerciseClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","c:\\webdriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.navigate().to("https://amazon.com/");
Thread.sleep(5000);
WebElement flag=driver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]/span/span[2]/span[1]"));
        Point cordinate= flag.getLocation();
        int xLocation= cordinate.getX();
        int yLocation= cordinate.getY();
        System.out.println("x cordinate of flag is: "+xLocation);
        System.out.println("y cordinate of flag is: "+yLocation);
        Dimension dimension=new Dimension(400,600);
        driver.manage().window().setSize(dimension);


    }
}

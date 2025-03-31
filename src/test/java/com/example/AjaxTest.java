package com.example;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxTest {
    public static void main(String[] args) {

        String driverPath = Paths.get(System.getProperty("user.dir"), "drivers", "chromedriver").toString();

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();

        WebDriver driver =  new ChromeDriver(options);
        try{
        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait = new WebDriverWait(driver,10 );

        WebElement enableAfterButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter")));
        System.out.println("按钮已经变成可点击状态");

        enableAfterButton.click();
        WebElement colorChangeButton = driver.findElement(By.id("colorChange"));
        wait.until(ExpectedConditions.attributeToBe(colorChangeButton, "class", "text-danger"));
        System.out.println("按钮颜色已改变");

    }catch(Exception e){
        e.printStackTrace();
    }finally{
        driver.quit();
    }

        

    }
    
}

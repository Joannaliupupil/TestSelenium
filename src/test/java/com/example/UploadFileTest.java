package com.example;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.*;


public class UploadFileTest {
    public static void main(String[] args) {
        String driverPath = Paths.get(System.getProperty("user.dir"), "drivers", "chromedriver").toString();

        System.setProperty("webdriver.chrome.driver", driverPath);

        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);
        // 打开百度
        driver.get("https://www.baidu.com");
        // 文件本地地址
        File UploadFile = new File("/Users/joanna/Downloads/sd/image.png");
        // 找到相机按钮
        WebElement carmeral = driver.findElement(By.className("soutu-btn"));
        // 点击相机
        carmeral.click();
        // 显示等待
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // 找到上传按钮
        WebElement fileInput = driver.findElement(By.className("upload-pic"));
        // 上传
        fileInput.sendKeys(UploadFile.getAbsolutePath());
        System.out.println("文件上传成功");
        // String text = wait.until(ExpectedConditions.visibilityOfElementLocated(driver.getTitle()).getText();
        // System.out.println("11111111111111"+text);
        // 对比
        // Assertions.assertEquals("上传成功", driver.findElement(By.className("upload-success")).getText());
        // 示例：定位第一张图片（需根据实际页面结构调整）
        // WebElement imageElement = driver.findElement(By.xpath("//div[contains(@class, 'graph-product-list-img')][1]//img"));

        // // 显式等待确保元素可见
        // imageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
        //     By.xpath("//div[contains(@class, 'imgbox')][1]//img")
        // ));
        // // 创建Actions对象
        // Actions actions = new Actions(driver);
        // System.out.println("1111111111111");
        // // WebElement picElement = driver.findElement(By.className("graph-product-list-img"));
        // System.out.println("22222222");
        // actions.moveToElement(imageElement).perform();
        // System.out.println("悬停");
        
        
        
        System.out.println("页面源代码：");
        System.out.println("==================================================");
        System.out.println(driver.getPageSource().substring(0, Math.min(5000, driver.getPageSource().length())));
        System.out.println("==================================================");
        List<WebElement> allImages = driver.findElements(By.tagName("img"));
        System.out.println("找到的图片总数：" + allImages.size());
            
        for (int i = 0; i < allImages.size(); i++) {
            WebElement img = allImages.get(i);
            try {
                // if (img.isDisplayed() && 
                //     img.getSize().getWidth() > 100 && 
                //     img.getSize().getHeight() > 100) {
                    
                //     System.out.println("找到可见的大图片 #" + (i+1));
                    
                //     // 滚动到图片位置
                //     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", img);
                //     Thread.sleep(1000);
                    
                    // 创建Actions对象并悬停
                    Actions actions = new Actions(driver);
                    actions.moveToElement(img).perform();
                    
                    System.out.println("成功悬停在图片上");
                    Thread.sleep(3000);
                    
                    // 成功找到一个图片后退出
                    break;
                // }
            } catch (Exception e) {
                System.out.println("处理图片 #" + (i+1) + " 时出错: " + e.getMessage());
            }
            finally {
                // 关闭浏览器
                driver.quit();
            }

        
        
    }
}
}
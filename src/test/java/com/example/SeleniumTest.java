package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.nio.file.Paths;

public class SeleniumTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("开始设置ChromeDriver...");
        
        try {
            // 使用本地下载的ChromeDriver
            String driverPath = Paths.get(System.getProperty("user.dir"), "drivers", "chromedriver").toString();
            System.setProperty("webdriver.chrome.driver", driverPath);
            System.out.println("ChromeDriver路径: " + driverPath);
            
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            
            System.out.println("正在初始化ChromeDriver...");
            driver = new ChromeDriver(options);
            System.out.println("ChromeDriver初始化成功");
        } catch (Exception e) {
            System.out.println("ChromeDriver初始化失败: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @Test
    public void testExample() {
        try {
            System.out.println("开始执行测试...");
            driver.get("https://www.baidu.com");
            
            String title = driver.getTitle();
            System.out.println("页面标题: " + title);
            
            Assert.assertTrue(title.contains("百度"), "页面标题应该包含'百度'");
            System.out.println("测试完成");
        } catch (Exception e) {
            System.out.println("测试执行失败: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("正在清理资源...");
        if (driver != null) {
            driver.quit();
            System.out.println("ChromeDriver已关闭");
        }
    }
} 
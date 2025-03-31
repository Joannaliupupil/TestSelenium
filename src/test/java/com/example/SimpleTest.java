package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.nio.file.Paths;
//import java.util.concurrent.TimeUnit;

public class SimpleTest {
    public static void main(String[] args) {
        WebDriver driver = null;
        
        try {
            System.out.println("开始设置ChromeDriver...");
            
            // 设置ChromeDriver路径
            String driverPath = Paths.get(System.getProperty("user.dir"), "drivers", "chromedriver").toString();
            File driverFile = new File(driverPath);
            if (!driverFile.exists()) {
                System.out.println("错误: ChromeDriver文件不存在: " + driverPath);
                return;
            }
            
            // 设置可执行权限
            driverFile.setExecutable(true);
            
            // 设置系统属性
            System.setProperty("webdriver.chrome.driver", driverPath);
            System.out.println("ChromeDriver路径: " + driverPath);
            
            // 最简化的Chrome选项
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--headless");
            
            System.out.println("正在初始化ChromeDriver...");
            driver = new ChromeDriver(options);
            
            System.out.println("ChromeDriver初始化成功");
            
            // 打开百度网页
            driver.get("https://www.baidu.com");
            System.out.println("成功打开百度页面");
            
            // 获取并验证页面标题
            String title = driver.getTitle();
            System.out.println("页面标题: " + title);
            driver.get("https://www.baidu.com");
            //
            driver.findElement(By.id("su")).click();

            driver.quit();

            
        } catch (Exception e) {
            System.out.println("测试过程中出现异常: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 关闭浏览器
            if (driver != null) {
                try {
                    driver.quit();
                    System.out.println("ChromeDriver已关闭");
                } catch (Exception e) {
                    System.out.println("关闭ChromeDriver时出错: " + e.getMessage());
                }
            }
            
            System.out.println("程序结束");
        }
    }
} 
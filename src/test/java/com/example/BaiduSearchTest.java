package com.example;  // 添加包声明
import java.nio.file.Paths;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class BaiduSearchTest {
    public static void main(String[] args) {
        // 设置ChromeDriver路径
        String driverPath = Paths.get(System.getProperty("user.dir"), "drivers", "chromedriver").toString();

        System.setProperty("webdriver.chrome.driver", driverPath);

        // 设置Chrome选项
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");

        // 初始化WebDriver
        WebDriver driver = new ChromeDriver(options);
        try {
            // // 打开百度首页
            // driver.get("https://www.baidu.com");

            // // 定位搜索框和搜索按钮
            // WebElement searchBox = driver.findElement(By.name("wd"));
            // WebElement searchButton = driver.findElement(By.id("su"));

            // 输入不同的搜索内容
            String[] searchTerms = {"普通文本", "特殊字符!@#$%^&*()"};

            for (String term : searchTerms) {
                 // 打开百度首页
            driver.get("https://www.baidu.com");

            // 定位搜索框和搜索按钮
            WebElement searchBox = driver.findElement(By.name("wd"));
            WebElement searchButton = driver.findElement(By.id("su"));

                // 清空搜索框并输入搜索内容
                searchBox.clear();
                searchBox.sendKeys(term);
                System.out.println("输出搜索内容"+term);
                // 点击搜索按钮
                searchButton.click();

                // 等待页面加载并验证标题
                Thread.sleep(2000); // 简单的等待，建议使用显式等待
                String title = driver.getTitle();
                System.out.println("搜索内容: " + term + "，页面标题: " + title);

                // 验证标题是否包含搜索内容
                if (title.contains(term)) {
                    System.out.println("验证成功: 页面标题包含搜索内容");
                } else {
                    System.out.println("验证失败: 页面标题不包含搜索内容");
                }

                // 返回百度首页
                driver.navigate().back();
                driver.navigate().refresh();
                System.out.println("返回百度首页"+driver.getTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭浏览器
            driver.quit();
        }
    }
}
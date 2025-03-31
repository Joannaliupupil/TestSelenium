package com.example;  // 添加包声明
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class BaiduSettingTest {
    public static void main(String[] args) {
        // 设置ChromeDriver路径
        String driverPath = Paths.get(System.getProperty("user.dir"), "drivers", "chromedriver").toString();
        System.setProperty("webdriver.chrome.driver", driverPath);

        // 设置Chrome选项
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--proxy-server='direct://'");  // 禁用代理
        options.addArguments("--proxy-bypass-list=*");  // 禁用代理

        // 初始化WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // 打开百度首页
            driver.get("https://www.baidu.com");

            // 创建Actions对象
            Actions actions = new Actions(driver);

            // 显式等待“设置”按钮可见
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement settingsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#s-usersetting-top")));

            // 移动到“设置”按钮并点击
            actions.moveToElement(settingsButton).perform();

            // 等待下拉菜单出现并点击“搜索设置”
            WebElement searchSettings = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("搜索设置")));
            searchSettings.click();

            System.out.println("成功打开搜索设置页面");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭浏览器
            driver.quit();
        }
    }
}

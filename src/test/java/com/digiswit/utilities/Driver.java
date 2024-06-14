package com.digiswit.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private Driver() {
    }

    private static InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();
    public static WebDriver get() {

        if (driver.get() == null) {

            String browser = System.getProperty("browser") != null ? browser = System.getProperty("browser") : ConfigReader.get("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions option = new ChromeOptions();
                    option.addArguments("--disable-blink-features=AutomationControlled");
                    option.setExperimentalOption("useAutomationExtension", false);
                    //System.setProperty("webdriver.chrome.driver", "./chromedriver");
                    driver.set(new ChromeDriver(option));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;

            }
        }
        return driver.get();
    }
    public static void closeDriver() {
        driver.get().quit();
        driver.remove();
    }
}

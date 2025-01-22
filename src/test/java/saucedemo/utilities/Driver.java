package saucedemo.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import saucedemo.pages.PageInitializer;

import java.time.Duration;

public class Driver {
    public static WebDriver driver;
    public static Actions actions;

    public static WebDriver getDriver() {
        if (driver == null) { // Ensure a single instance of WebDriver
            String browser = ConfigurationReader.get("browser");
            switch (browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    ChromeOptions chromeHeadlessOptions = new ChromeOptions();
                    chromeHeadlessOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeHeadlessOptions);
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");
                    }
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            PageInitializer.initialize();
            actions = new Actions(driver);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
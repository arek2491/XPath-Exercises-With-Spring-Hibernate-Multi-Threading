package com.xpath.lotto.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverConfig {

    public final static String CHROME = "CHROME_DRIVER";
    public static WebDriver getDriver(final String driver) {

        System.setProperty("webdriver.chrome.driver","c:\\chromedriver.exe");

        if(driver.equals(CHROME)) {
            return new ChromeDriver();
        } else {
            return null;
        }
    }
}

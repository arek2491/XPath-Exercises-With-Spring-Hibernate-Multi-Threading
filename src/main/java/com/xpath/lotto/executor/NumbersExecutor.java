package com.xpath.lotto.executor;

import com.xpath.lotto.config.DriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class NumbersExecutor {

    public static final String XPATH_BUTTON = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div/div[3]/div[2]/div[3]/button";
    public static final String XPATH_NUMBER1 = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]";
    public static final String XPATH_NUMBER2 = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[1]/div[3]/div[2]";
    public static final String XPATH_NUMBER3 = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[1]/div[3]/div[3]";
    public static final String XPATH_NUMBER4 = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[1]/div[3]/div[4]";
    public static final String XPATH_NUMBER5 = "//*[@id=\"__layout\"]/div/div[2]/div[4]/div/div/div[2]/div/div[3]/div[2]/div[2]/div[1]/div[1]/div[3]/div[5]";

    public ArrayList<Integer> execute() {

        WebDriver driver = DriverConfig.getDriver(DriverConfig.CHROME);
        driver.get("https://www.lotto.pl/mini-lotto");

        WebElement button = driver.findElement(By.xpath(XPATH_BUTTON));
        button.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement num1 = driver.findElement(By.xpath(XPATH_NUMBER1));
        WebElement num2 = driver.findElement(By.xpath(XPATH_NUMBER2));
        WebElement num3 = driver.findElement(By.xpath(XPATH_NUMBER3));
        WebElement num4 = driver.findElement(By.xpath(XPATH_NUMBER4));
        WebElement num5 = driver.findElement(By.xpath(XPATH_NUMBER5));

        int number1 = Integer.parseInt(num1.getText());
        int number2 = Integer.parseInt(num2.getText());
        int number3 = Integer.parseInt(num3.getText());
        int number4 = Integer.parseInt(num4.getText());
        int number5 = Integer.parseInt(num5.getText());

        List<Integer> theList = new ArrayList<>();
        theList.add(number1);
        theList.add(number2);
        theList.add(number3);
        theList.add(number4);
        theList.add(number5);

        Collections.sort(theList);
        driver.close();

        return new ArrayList<>(theList);
    }
}

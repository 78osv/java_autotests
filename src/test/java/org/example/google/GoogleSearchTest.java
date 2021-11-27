package org.example.google;

import org.example.yandex.ConfProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearchTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
    }

    @Test
    public void googleSearchTest() {
        String searchTerm = "купить кофемашину bork c804";

        driver.get("https://google.com");
        driver.manage().window().maximize();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchTerm, Keys.ENTER);
        // searchField.submit();
        List<WebElement> results = driver.findElements(By.xpath("//*[@id='rso']//a"));

        for (WebElement webElement : results) {
            System.out.println(webElement.getText() + webElement.getAttribute("href").contains("mvideo.ru"));
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}




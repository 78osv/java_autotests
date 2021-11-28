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

        // В поисковой выдаче всего 7 страниц
        for (int i = 1; i < 7; i++) {
            List<WebElement> results = driver.findElements(By.xpath(" //*[@id='rso']//h3/ancestor::a"));
            for (WebElement webElement : results) {
                if (webElement.getAttribute("href").contains("mvideo.ru")) {
                    System.out.println(webElement.getAttribute("href"));
                }
            }
            driver.findElement(By.xpath("//span[text()='Следующая']")).click();
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}




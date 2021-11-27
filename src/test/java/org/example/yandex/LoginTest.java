package org.example.yandex;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static MainPage mainPage;
    public static LoginPage loginPage;
    public static MailPage mailPage;
    public static WebDriver driver;


    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("mainpage"));
    }

    // позитивный автотест на вход в почтовый ящик на www.yandex.ru.
    @Test
    public void loginTest() {
        //клик на почту на главной странице
        mainPage.clickMail();
        //вводим логин
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //вводим пароль
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        WebElement accountName = driver.findElement(By.xpath("//*[@id=\"js-apps-container\"]/div[2]/div[7]/div/div[2]/div/div/div[3]/div/div/a[1]/span[1]"));
        String name = accountName.getText();
        Assert.assertEquals(ConfProperties.getProperty("login"), name);
        // выход из аккаунта
        mailPage.entryMenu();
        mailPage.userLogout();
    }

    // негативный автотест на вход в почтовый ящик на www.yandex.ru.
    @Test
    public void withoutLoginTest() {
        mainPage.clickMail();
        loginPage.clickLoginBtn();
        WebElement errorMessage = driver.findElement(By.cssSelector(".Textinput-Hint.Textinput-Hint_state_error"));
        String error = errorMessage.getText();
        Assert.assertEquals("Логин не указан", error);
    }

    // закрытие окна браузера
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}

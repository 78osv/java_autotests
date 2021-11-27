package org.example.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // определение локатора почты
    @FindBy(xpath = "//div[text()='Почта']")
    private WebElement mail;

    // метод для клика на почту и перехода на новую вкладку
    public void clickMail() {
        String parentHandle = driver.getWindowHandle();
        mail.click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);

        }
    }

}

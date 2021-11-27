package org.example.yandex;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MailPage {

    public WebDriver driver;

    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // определение локатора меню пользователя
    @FindBy(xpath = "//*[contains(@class, 'user-pic user-pic_has-plus_ user-account__pic')]")
    private WebElement userMenu;

    // определение локатора кнопки выхода из аккаунта
    @FindBy(xpath = "//span[text()='Выйти из сервисов Яндекса']")
    private WebElement logoutBtn;



    // метод для нажатия кнопки меню пользователя
    public void entryMenu() {
        userMenu.click();
    }

    // метод для нажатия кнопки выхода из аккаунта
    public void userLogout() {
        logoutBtn.click();
    }
}

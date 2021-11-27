package org.example.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // определение локатора поля ввода логина
    @FindBy(xpath = "//*[contains(@id, 'passp-field-login')]")
    private WebElement loginField;
    // определение локатора кнопки входа в аккаунт
    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginBtn;
    // определение локатора поля ввода пароля
    @FindBy(xpath = "//*[contains(@id, 'passp-field-passwd')]")
    private WebElement passwdField;

    // метод для ввода логина
    public void inputLogin(String login) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id, 'passp-field-login')]")));
        loginField.sendKeys(login);
    }

    // метод для ввода пароля
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    // метод для клика на кнопку входа в аккаунт
    public void clickLoginBtn() {
        loginBtn.click();
    }
}

package praktikum.pages;

import org.openqa.selenium.By;

public class Locators {
    // Заголовок "Соберите бургер" в верхней части страницы
    public static final By LOGO = By.xpath(".//div[contains(@class, 'logo')]");
    // Кнопка "Личный кабинет" в верхней части страницы
    public static final By USER_PROFILE_BUTTON = By.xpath("..//a[contains(@href, '/account')]");
    // Раздел "Булки" на главной странице
    public static final By BUNS_SECTION = By.xpath(".//span[text() = 'Булки']/parent::div");
    // Активный раздел "Булки" на главной странице
    public static final By BUNS_SECTION_SELECTED = By.xpath((".//div[contains(@class, 'tab_tab_type_current')]/span[text()='Булки']"));
    // Раздел "Соусы" на главной странице
    public static final By SAUCES_SECTION = By.xpath(".//span[text() = 'Соусы']/parent::div");
    // Активный раздел "Соусы" на главной странице
    public static final By SAUCES_SECTION_SELECTED = By.xpath((".//div[contains(@class, 'tab_tab_type_current')]/span[text()='Соусы']"));
    // Раздел "Начинки" на главной странице
    public static final By FILLINGS_SECTION = By.xpath(".//span[text() = 'Начинки']/parent::div");
    // Активный раздел "Начинки" на главной странице
    public static final By FILLINGS_SECTION_SELECTED = By.xpath((".//div[contains(@class, 'tab_tab_type_current')]/span[text()='Начинки']"));

    // Текст "Некорректный пароль" на экране авторизации пользователя
    public static final By INCORRECT_PASSWORD_TEXT = By.xpath(".//p[text()='Некорректный пароль']");
    // Поле "Email" на экране авторизации пользователя
    public static final By EMAIL_FIELD = By.xpath(".//input[@name='name']");
    // Поле "Пароль" на экране авторизации пользователя
    public static final By PASSWORD_FIELD = By.xpath(".//input[@name='Пароль']");
    // Кнопка "Войти" на экране авторизации пользователя
    public static final By SIGN_IN_BUTTON = By.xpath(".//button[text()='Войти']");

    // Поле "Имя" на экране регистрации пользователя
    public static final By NEW_USER_NAME_FIELD = By.xpath("//fieldset[1]//input[@name='name']");
    // Поле "Email" на экране регистрации пользователя
    public static final By NEW_USER_EMAIL_FIELD = By.xpath("//fieldset[2]//input[@name='name']");
    // Поле "Пароль" на экране регистрации пользователя
    public static final By NEW_USER_PASSWORD_FIELD = By.xpath("//input[@name='Пароль']");
    // Кнопка "Зарегистрироваться" на экране регистрации пользователя
    public static final By SIGN_UP_BUTTON = By.xpath(".//button[text()='Зарегистрироваться']");

    // Кнопка "Выход" на экране ЛК
    public static final By LOGOUT_BUTTON = By.xpath(".//button[text()='Выход']");
}

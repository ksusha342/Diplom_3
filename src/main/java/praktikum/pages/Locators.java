package praktikum.pages;

import org.openqa.selenium.By;

public class Locators {
    // Заголовок "Соберите бургер" в верхней части главной страницы
    public static final By MAIN_TITLE = By.xpath(".//h1[text() = 'Соберите бургер']");
    // Раздел "Булки"
    public static final By BUNS_SECTION = By.xpath(".//span[text() = 'Булки']/parent::div");
    // Активный раздел "Булки"
    public static final By BUNS_SECTION_SELECTED = By.xpath((".//div[contains(@class, 'tab_tab_type_current')]/span[text()='Булки']"));
    // Раздел "Соусы"
    public static final By SAUCES_SECTION = By.xpath(".//span[text() = 'Соусы']/parent::div");
    // Активный раздел "Соусы"
    public static final By SAUCES_SECTION_SELECTED = By.xpath((".//div[contains(@class, 'tab_tab_type_current')]/span[text()='Соусы']"));
    // Раздел "Начинки"
    public static final By FILLINGS_SECTION = By.xpath(".//span[text() = 'Начинки']/parent::div");
    // Активный раздел "Начинки"
    public static final By FILLINGS_SECTION_SELECTED = By.xpath((".//div[contains(@class, 'tab_tab_type_current')]/span[text()='Начинки']"));

}

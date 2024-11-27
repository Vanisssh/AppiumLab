package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends MainPageObject {

    private static final By
            SEARCH_INIT_ELEMENT = By.xpath("//*[@text='Поиск по Википедии']"),
            SEARCH_INPUT = By.xpath("//*[@text='Поиск по Википедии']"),
            SEARCH_RESULT = By.xpath("//*[@text='The Hobbit' and @id='page_list_item_title']"),
            WEBVIEW_ELEMENT = By.xpath("//*[@text='The Hobbit' and @class='android.webkit.WebView']"),
            OPTIONS_BUTTON = By.xpath("//*[@id='page_toolbar_button_show_overflow_menu']"),
            SAVE_BUTTON = By.xpath("//*[@text='Сохранить']"),
            ADD_TO_LIST_BUTTON = By.xpath("//*[@text='Добавить в список']"),
            LIST_NAME_INPUT = By.xpath("//*[@id='text_input']"),
            OK_BUTTON = By.xpath("//*[@text='ОК']"),
            VIEW_LIST_BUTTON = By.xpath("//*[@text='Посмотреть список']"),
            ITEM_OVERFLOW_MENU = By.xpath("//*[@id='item_overflow_menu']"),
            DELETE_LIST_BUTTON = By.xpath("//*[@text='Удалить список']"),
            DELETE_OK_BUTTON = By.xpath("//*[@text='ОК']"),
            EMPTY_LIST_ELEMENT = By.xpath("//*[contains(@text,'Ещё нет списков для чтения')]"),
            BACK_TO_EXPLORER_BUTTON = By.xpath("//*[@id='navigation_bar_item_icon_view' and ./parent::*[./parent::*[@id='nav_tab_explore']]]");

    public SearchPageObject(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Не удалось найти поле ввода поиска", 5);
    }

    public void enterSearchLine(String searchLine) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, searchLine, "Не удалось ввести текст в строку поиска", 5);
    }

    public void waitForSearchResultToAppear() {
        this.waitForElementPresent(SEARCH_RESULT, "Не удалось найти статью 'The Hobbit'", 10);
    }

    public void saveArticleToReadingList() {
        this.waitForElementAndClick(SEARCH_RESULT, "Не удалось кликнуть на статью 'The Hobbit'", 5);
        this.waitForElementAndClick(WEBVIEW_ELEMENT, "Не удалось кликнуть по элементу WebView", 5);
        this.waitForElementAndClick(OPTIONS_BUTTON, "Не удалось найти кнопку 'Ещё'", 5);
        this.waitForElementAndClick(SAVE_BUTTON, "Не удалось найти кнопку 'Сохранить'", 5);
        this.waitForElementAndClick(ADD_TO_LIST_BUTTON, "Не удалось найти кнопку 'Добавить в список'", 5);
        this.waitForElementAndClear(LIST_NAME_INPUT, "Не удалось очистить поле для ввода названия списка", 5);
        this.waitForElementAndSendKeys(LIST_NAME_INPUT, "Hobbit", "Не удалось ввести название списка", 5);
        this.waitForElementAndClick(OK_BUTTON, "Не удалось нажать кнопку 'ОК'", 15);
        this.waitForElementAndClick(VIEW_LIST_BUTTON, "Не удалось нажать 'Посмотреть список'", 5);
    }

    public void deleteReadingList() {
        this.waitForElementAndClick(ITEM_OVERFLOW_MENU, "Не удалось найти кнопку 'Ещё'", 5);
        this.waitForElementAndClick(DELETE_LIST_BUTTON, "Не удалось найти кнопку 'Удалить список'", 5);
        this.waitForElementAndClick(DELETE_OK_BUTTON, "Не удалось нажать кнопку 'ОК'", 15);
        this.waitForElementPresent(EMPTY_LIST_ELEMENT, "Список чтения не удалён, элемент 'Хоббит' всё ещё присутствует", 10);
        this.waitForElementAndClick(BACK_TO_EXPLORER_BUTTON, "Не удалось вернуться на главный экран", 5);
    }
}

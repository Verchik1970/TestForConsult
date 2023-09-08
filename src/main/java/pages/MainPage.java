package pages;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

public class MainPage {
    public static WebDriver driver;

    final String index = "https://books.ru/";

    public static final By popUpCloseButton = By.xpath("//div[@class='closeX']");
    /*final String popUpCloseButton = ;*/
    public static final By SEARCH_INPUT = By.xpath("//header/div[2]/div[1]/div[1]/form[1]/input[2]");
    public static final By SEARCH_BUTTON_HEADER = By.xpath("//header/div[2]/div[1]/div[1]/form[1]/button[1]"); //кнопка лупа
    public static final By SEARCH_RESULT_COUNT = By.xpath("//body/div[1]/div[1]/main[1]/div[3]/div[1]/div[1]");
    public static final By REGISTRATION_BTN = By.xpath("//header/div[2]/div[1]/div[2]/a[1]");
    public static final By BASKET_BTN = By.xpath("//header/div[2]/div[1]/div[2]/a[2]");
    public static final By CHOICE_CITY_BUTTON = By.cssSelector("a.link-icon.link-icon-region.header_nav-top_item");
    public static final By REGION_NAME = By.xpath("//label[contains(text(),'Мой регион:')]");
    public static final String myRegion = "Мой регион";
    public static final By CHANGE_BUTTON_CITY = By.cssSelector("#header_mainregion_trigger"); //выбор изменить
    public static final By DROPDOWN_CITIES = By.cssSelector("#header_mainregion_other"); //открытие списка
    public static final By CITY_LOCATION = By.xpath("//option[contains(text(),'Россия')]"); //Россия //*[@id="header_mainregion_other"]/option[4]
    public static final By RUSSIA_CITIES_CHANGE = By.xpath("//select[@id='header_mainregion_other2']"); // алтай //*[@id="header_mainregion_other2"]/option[8]
    public static final By ALTAY_REGION = By.xpath("/html/body/header/div[1]/nav/div/a");
    public static final String test_city_value = "Россия, Алтай";
    public static final By HELP_BTN = By.xpath("//header/div[1]/nav[1]/a[2]"); //div[@id='search-list-popup']


    public MainPage(WebDriver driver) {
        MainPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(index);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        closePopUp();
    }

    public void closePopUp() {
        driver.findElement(popUpCloseButton).click();
    }

    public void inputSearchInput(String value) {
        driver.findElement(SEARCH_INPUT).sendKeys(value);
    }

    public void timeOutDuration(long sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

    }



    public void allureScreenshot(String description) {
        Allure.addAttachment(description,
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void clickSearhButton() {
        //нажатие кнопки поиска-лупы
        driver.findElement(SEARCH_BUTTON_HEADER).click();

    }



    public void registrationBtnClick() {
        driver.findElement(REGISTRATION_BTN).click();
    }

    public void basketBtnClick() {
        driver.findElement(BASKET_BTN).click();
    }



}




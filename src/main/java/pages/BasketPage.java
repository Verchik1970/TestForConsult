package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasketPage {
    public static WebDriver driver;
    public static String value = "Трудно быть богом";

    public BasketPage(WebDriver driver) {
        BasketPage.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public static By DISCOUNT_CODE_BTN = By.cssSelector("#discode-input-trigger");
    public static By DISCOUNT_INPUT = By.cssSelector("label.label.coupon_label:nth-child(1)");

    public static By ITEM_TITLE = By.cssSelector(" a.custom-link.book-catalog_item_title ");
    public void addToCartItems(String value) {
        mainPage.inputSearchInput(value);
        mainPage.clickSearhButton();
        mainPage.addToBasket();
        mainPage.timeOutDuration(5);
        mainPage.basketBtnClick();
    }



    public void clickBTN(By locator) {
        driver.findElement(locator).click();
    }

}

package TestRed;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static DriverUtils.DriverUtils.getDriver;

 class CartPage {

    private By cartLink = By.cssSelector("img[src=\"/img/bag.png\"]");
    private By subTotalPrice = By.cssSelector("span[class=\"val_sum\"]");
    private By removeItemFromCart = By.cssSelector("a[href=\"/basket/shop-checkout-step1-delete/point/0\"]");
    private By emptyLink = By.xpath("//p[.=\"Корзина пуста\"]");

     void selectCart(){

        getDriver().findElement(cartLink).click();
    }

     String getSubTotalValue(){

        return getDriver().findElement(subTotalPrice).getText();
    }

     void removeItemsFromCart() {

        getDriver().findElement(removeItemFromCart).click();
        Alert alert1 = getDriver().switchTo().alert();
        alert1.accept();

        getDriver().findElement(removeItemFromCart).click();
        Alert alert2 = getDriver().switchTo().alert();
        alert2.accept();
    }

     boolean isCartEmpty(){

        return getDriver().findElement(emptyLink).isDisplayed();
    }

}

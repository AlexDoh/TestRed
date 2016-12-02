package TestRed;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static DriverUtils.DriverUtils.getDriver;

 class ChosenWomensTshirtPage {

    private By sizeTshirt = By.cssSelector("label[for=\"39size\"]");
    private By buyButton = By.cssSelector("span[onclick=\"getQuickCart('/product/id/49772/c-a-futbolka'); return false;\"]");
    private By price = By.cssSelector("span[class=\"price\"]");
    private By elementForAssert = By.id("span_ok");
    private By elementForAssertBuy = By.xpath("//span[.=\"SR0418899-081116\"]");


     void chooseSizeAndClickAddBuntton(){
        getDriver().findElement(sizeTshirt).click();
        (new WebDriverWait(getDriver(), 5000)).until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(elementForAssertBuy), "SR0418899-081116"));
        getDriver().findElement(buyButton).click();
        (new WebDriverWait(getDriver(), 5000)).until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(elementForAssert), "2"));
    }


     String getCountForAssert() {
        return getDriver().findElement(elementForAssert).getText();
    }

     int getPrice() {
        String text = getDriver().findElement(price).getText().substring(5, 8);
        return Integer.parseInt(text);
    }

     boolean checkPrice(int expectedPrice) {
        String pr = new String();
        pr += expectedPrice;
        boolean result = getDriver().findElement(price).getText().contains(pr);
        return result;
    }
}
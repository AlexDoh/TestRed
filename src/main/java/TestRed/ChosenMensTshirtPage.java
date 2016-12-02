package TestRed;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static DriverUtils.DriverUtils.getDriver;

 class ChosenMensTshirtPage {

    private By buyButton = By.cssSelector("span[onclick=\"getQuickCart('/product/id/50038/zippo-futbolka'); return false;\"]");
    private By price = By.cssSelector("span[class=\"price\"]");
    private By elementForAssert = By.id("span_ok");

     void clickAddButton() {
        getDriver().findElement(buyButton).click();
        (new WebDriverWait(getDriver(), 5000)).until(ExpectedConditions.textToBePresentInElement(getDriver().findElement(elementForAssert), "1"));
    }

     String getCountForAssert(){
        return getDriver().findElement(elementForAssert).getText();
    }

     int getPrice(){
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

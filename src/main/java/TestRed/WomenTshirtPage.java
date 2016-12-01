package TestRed;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static DriverUtils.DriverUtils.getDriver;

 class WomenTshirtPage {

    private By womenLink = By.xpath("//p[text()=\"Женская одежда\"]");
    private By womensTshirtLink = By.xpath("//div[@class=\"bulka-center\"]//h1[text()=\"Футболки, Тенниски, Топы\"]");
    private By chosenTshirt = By.cssSelector("a[href=\"/product/id/49772/c-a-futbolka\"]");
    private By elementForAssert = By.cssSelector("a[href=\"/category/id/30/zhenskaja-odezhda/futbolki-tenniski-topy/futbolki-tenniski-topy/\"]");

     void openWomensTshirt() throws InterruptedException {
        Actions action = new Actions(getDriver());
        action.moveToElement(getDriver().findElement(womenLink)).build().perform();
        getDriver().findElement(womensTshirtLink).click();
    }

     void chooseATshirt(){
        getDriver().findElement(chosenTshirt).click();
    }

     String getTextForAssert(){
        return getDriver().findElement(elementForAssert).getText();
    }
}

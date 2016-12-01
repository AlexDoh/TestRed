package TestRed;

import org.openqa.selenium.By;

import static DriverUtils.DriverUtils.getDriver;

 class MensTshirtPage {

    private By chosenTshirt = By.cssSelector("div:not([id=\"article-item\"]) > a[href=\"/product/id/50038/zippo-futbolka\"]");
    private By elementForAssert = By.cssSelector("a[href=\"/category/id/32/muzhskaja-odezhda/futbolki-maiki/futbolki-maiki/\"]");

     void chooseMenTshirt(){
        getDriver().findElement(chosenTshirt).click();
    }

     String getTextForAssert(){
        return getDriver().findElement(elementForAssert).getText();
    }


}

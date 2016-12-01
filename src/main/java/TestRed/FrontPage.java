package TestRed;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static DriverUtils.DriverUtils.getDriver;

 class FrontPage
{
    private By menLink = By.xpath("//a[@href=\"/category/id/15/muzhskaja-odezhda/\"]");
    private By mensTshirtLink = By.xpath("//div[@class=\"bulka-center\"]//h1[.=\"Футболки, Майки\"]");

     void open() {
        getDriver().get("http://www.red.ua/");
    }

     void chooseMensTshirt() throws InterruptedException {
        Actions action = new Actions(getDriver());
        action.moveToElement(getDriver().findElement(menLink)).build().perform();
        getDriver().findElement(mensTshirtLink).click();
    }

}

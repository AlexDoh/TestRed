package TestRed;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static DriverUtils.DriverUtils.getDriver;

public class TestRed {

    @Before
    public void preCondition() {
    }

    @Test
    public void RedPurchasingTest() throws InterruptedException {

        int totalPrice = 0;
        FrontPage front = new FrontPage();
        front.open();
        front.chooseMensTshirt();

        MensTshirtPage tshirtPage = new MensTshirtPage();
        Assert.assertEquals("Футболки, Майки", tshirtPage.getTextForAssert());
        tshirtPage.chooseMenTshirt();

        ChosenMensTshirtPage choosenMensTshirt = new ChosenMensTshirtPage();
        Assert.assertTrue(choosenMensTshirt.checkPrice(259));
        totalPrice += choosenMensTshirt.getPrice();
        choosenMensTshirt.clickAddButton();
        Assert.assertTrue(choosenMensTshirt.getCountForAssert().contains("1"));

        WomenTshirtPage womentshirt = new WomenTshirtPage();
        womentshirt.openWomensTshirt();
        Assert.assertEquals("Футболки, Тенниски, Топы", womentshirt.getTextForAssert());
        womentshirt.chooseATshirt();

        ChosenWomensTshirtPage choosenWomensTshirt = new ChosenWomensTshirtPage();
        Assert.assertTrue(choosenWomensTshirt.checkPrice(119));
        totalPrice += choosenWomensTshirt.getPrice();
        choosenWomensTshirt.chooseSizeAndClickAddBuntton();
        Assert.assertTrue(choosenWomensTshirt.getCountForAssert().contains("2"));

        CartPage cart = new CartPage();
        cart.selectCart();
        String countedTotal = new String();
        countedTotal += totalPrice;
        Assert.assertTrue(cart.getSubTotalValue().contains(countedTotal));
        cart.removeItemsFromCart();
        Assert.assertTrue(cart.isCartEmpty());
    }

    @After
    public void postCondition(){

        getDriver().close();
    }

}

package day06_window_iframe_actionclass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    // https://the-internet.herokuapp.com/iframe adresine gidin
    // Your content goes here. yazisinin gorunur oldugunu test edin

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe ");
        /*
        bazen lokate islemimizden iemin olmammiza ragmen locater calismaz
        Bunun sebebi kullanmak istedimiz webelemntinin bir iframe icinde olabilir
        Eger kullanmak istedigimiz webelement anasayfa iceinde gomlulen bi baska websayfasinin
        elementi ise once gomulu sayfaya gecmemiz gerekir

        HTML komutlari icinde sayfa icerine gommek icin iframe tagi kullanilir
        Bizde istedigimiz elementi kullanmak icin once o iframe switch yapamaliyiz.

        1- Gecis yapmak istedigiz frami lokete edin
        2- switch to ile o frame gecis yapiun
        3- sonra istediginiz element ile istedihiz islemi yapin
         */

        WebElement frameelementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameelementi);

        WebElement yaziElementi=driver.findElement(By.tagName("p"));

        Assert.assertTrue(yaziElementi.isDisplayed());
        bekle(2);
        // Elemental Selenium linkine clik yapin
        /*
        Bir frame gecis yaotiktan sonra oradan cikincaya veya baska bir frame gecinceye kadar driver o frame icerisinde
        kalir.
        isimimiz bittiginde veya baska frame gecmek istedigimizde once calisacagimiz yere gecis yapmaliyiz
         */
        driver.switchTo().parentFrame();// bir ust seviye
       // driver.switchTo().defaultContent();// direkt ana sayfaya cikar
        driver.findElement(By.linkText("Elemental Selenium")).click();


    }

}

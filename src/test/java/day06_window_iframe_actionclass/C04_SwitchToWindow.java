package day06_window_iframe_actionclass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C04_SwitchToWindow extends TestBase {
    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get(" https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement ilkSayfaYaziElementi=driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualyazi=ilkSayfaYaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualyazi);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle="The Internet";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();
        //● Click Here butonuna basın.

        driver.findElement(By.linkText("Click Here")).click();
        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        /*
        eger switchtonewwindow kullanilirsa
        driver yeni acilan sayfaya gecis yapar
        ancak bu method tiklandiginda yeni bir sayfa aciliyorsa
        driver yeni sayfaya gecis yapmaz
        bizim yani acilan sayfanin window handle degerini bulup
        driveri sayfaya gecirmemiz gerekir

        Linke click yaptigimizda acik 2 sayfamiz oluyor
        bunlardan bir tanesi windowhandle degerini kaydettigimiz ilk sayfa
        digertide window handle degerini bilmadeimiz ikinci sayfa
         */
        Set<String> tumSayfalrHandleDegerSet=driver.getWindowHandles();


        String ikinciSayfaWHD="";
        for (String each:tumSayfalrHandleDegerSet){
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWHD=each;
            }
        }
        driver.switchTo().window(ikinciSayfaWHD);
        expectedTitle="New Window";
        actualTitle=driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String ikinciSayfayazi=driver.findElement(By.tagName("h3")).getText();
        expectedYazi="New Window";
        Assert.assertEquals(expectedTitle,ikinciSayfayazi);
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        expectedTitle="The Internet";
        actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

}

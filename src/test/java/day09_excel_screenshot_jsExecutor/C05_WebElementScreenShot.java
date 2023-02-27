package day09_excel_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_WebElementScreenShot extends TestBase {

    @Test
    public void test01() throws IOException { // amazon anasayfasina gidin
        driver.get("https://amazon.com");

        // nutella icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // sonuclarin nutella icerdigini test edin
        WebElement sonucYazielementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String actualSonucYazisi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        String expectedIcerik="Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        // ve rapora eklemek icin sonuc yazisi elementinin  fotografini cekin

        //1- fotograf cekilecek elementi locate edin
        //2- dosyayi kaydetmek icin bir file olusturun
        File elementSs= new File("target/elementSs.jpg");


        //3-webelement ile screenshot cekip gecici dosyaya kaydedin
        File geciciDosya= sonucYazielementi.getScreenshotAs(OutputType.FILE);

        //4- gecici dosyayi elementSs kopyalayiniz
        FileUtils.copyFile(geciciDosya,elementSs);

    }



}

package day09_excel_screenshot_jsExecutor;

import jdk.management.jfr.SettingDescriptorInfo;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_TumSayfaScreenshot  extends TestBase {

    @Test
    public void test01() throws IOException {
         // amazon anasayfasina gidin
        driver.get("https://amazon.com");

        // nutella icin arama yapin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
       // sonuclarin nutella icerdigini test edin
        String actualSonucYazisi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText();
        String expectedIcerik="Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
       // ve rapora eklemek icin tum sayfanin fotografini cekin

        //1- take screnshot objesi olusturuyoru
        TakesScreenshot ts= (TakesScreenshot) driver;

        //2- screenshot i kaydedecegimiz bir dosya olusturalim
        File tumSayfaSS= new File("target/screenshot.png");

        // 3- gecici bir dosya olusturup ts objesi ile cekilen fotografi dosyaya kaydediyoruz
        File geciciResim=ts.getScreenshotAs(OutputType.FILE);

        //4- gecici dosyayi tum sayfa ss dosysina koplayallim
        FileUtils.copyFile(geciciResim,tumSayfaSS);
        bekle(2);
    }
}

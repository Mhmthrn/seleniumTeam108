package day03_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_CssSelector {
    public static void main(String[] args) {
        //1- bir class olusturun
        //2- https://www.amazon.com/ adresine gidin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

        //3- Browseri tam sayfa yapin
        //4- Sayfayi “refresh” yapin

        //5- Sayfa basliginin “Spend less” ifadesi icerdigini test edin
        String expectedTitle="Spend less";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Ttile testi PASSED");
        }else{
            System.out.println("Title testi FAILED");
        }

        //6- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]")).click();

         driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]")).click();

        //7- Birthday butonuna basin

        driver.findElement(By.cssSelector("img[alt='Birthday'")).click();

        //8- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("//*[@id=\"acs-product-block-0\"]/a/span/span[2]")).click();
        //9- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("//*[@id=\"gc-mini-picker-amount-1\"]")).click();
        //10-Urun ucretinin 25$ oldugunu test edin
        WebElement ucretElementi=driver.findElement(By.cssSelector("#gc-live-preview-amount"));
        String expectedUcret="$25.00";
        String actualUcret=ucretElementi.getText();

        if (actualUcret.equals(expectedUcret)){
            System.out.println("Ucret testi PASSED");
        }else{
            System.out.println("Ucret testi FAILED" +
                    "\nActual ucret"+ucretElementi.getText());
        }
        //11-Sayfayi kapatin
        driver.close();
    }
}

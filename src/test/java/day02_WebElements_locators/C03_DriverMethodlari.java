package day02_WebElements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverMethodlari {
    /*
    1.Yeni bir class olusturalim (Homework)
    2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
    3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
    4.https://www.walmart.com/ sayfasina gidin.
    5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
    6. Tekrar “facebook” sayfasina donun
    7. Sayfayi yenileyin
    8. Sayfayi tam sayfa (maximize) yapin
    9.Browser’i kapatin
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.facebook.com");

        String expectedTitle="facebook";
        String actualTitle=driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("facebook title testi PASSED");
        }else{
            System.out.println("facebook title testi FAILED" +
                    "\nGercekleseen title:"+ actualTitle);
        }

        String expectedIcerik="facebook";
        String actualURL= driver.getCurrentUrl();

        if (actualTitle.contains(expectedIcerik)){

        }







        driver.quit();




    }
}

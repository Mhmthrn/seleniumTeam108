package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ProjeyeSeleniumEkleme {
    public static void main(String[] args) throws InterruptedException {
         /*
        Bir projede selenium ile otomasyon yapabilmek icin
        projeye 2 sey eklemeliyiz
        1- Selenium kutuphanesi
        2- kullanmak istedigimiz browser(lar)in selenium driver'i
          (Biz sadece chrome kullanip sonra daha gelismis framework'lere gecis yapacagiz)
        dosyalari projeye eklemek icin
        1- selenium dev sayfasindan dosyalari bilgisayarimiza indiriyoruz
        2- bunlari unzip yapip, projemizde olusturdugumuz drivers klasorune tasiyoruz
        3- projeye selenium kutuphanelerini (jar dosyalarini) ekliyoruz
     */
        System.setProperty("Webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");

        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }


}


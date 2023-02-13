package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverMethodlari {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://wisequarter.com");

        System.out.println(driver.getWindowHandle());
        // CDwindow-0DB37B83C2E15236F720EB6C01CCCFC1
        // her sayfa icin uretilen uniqi handle degerini dondurur.

        System.out.println(driver.getWindowHandles());
        //[CDwindow-2F97A4378032AD6F0E6DC53F7DA9FC56]
        // test sirasinda bir den fazla pencere acilmissa onlarin degerini bi set olarak dondurur.

        System.out.println(driver.getPageSource());


        String expectedIcerik="2 hours weekly";
        String actualSayfaKodlari=driver.getPageSource();

        if (actualSayfaKodlari.contains(expectedIcerik)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Faild");
        }

        driver.quit();
        // close ve quit driveri kapatmak icin kullanilir
        // close tek sayfayi kapatir
        // quit coklu sayfalari kapatir


    }
}

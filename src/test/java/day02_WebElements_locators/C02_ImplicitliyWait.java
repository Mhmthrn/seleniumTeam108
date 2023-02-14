package day02_WebElements_locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ImplicitliyWait {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        driver i bir web uygulamasina gonderdigimizde o sayfanin acilmasi,
        orada istedigimiz islemleri yapmak icin elementleri bulmasi ... gibi islemler zaman gerektirebilir.
         */

    }
}

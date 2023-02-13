package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_DriverNavigateMethodlari {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        // amzon ana sayfaya gidin

        driver.get("https://amazon.com");

        //sonra wisequarter ana sayfaya gidin
        driver.get("https://wisequarter.com");

        //sonra amazon ana sayfaya gidin
        driver.navigate().back();

       // sonra wisequarter ana sayfaya gidin
        driver.navigate().forward();

        driver.navigate().to("https://www.youtube.com");// get ile ayni islemi gorur

        driver.navigate().refresh();


        driver.quit();



    }
}
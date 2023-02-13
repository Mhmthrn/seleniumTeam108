package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_Driver_Methodlari {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");
        WebDriver driver= new ChromeDriver();


        driver.manage().window().maximize();

        // amazon ana sayfaya gidin gittiginiz sayfadaki title ve url i yazdirim
        driver.get("https://amazon.com");


        System.out.println("URL :"+driver.getCurrentUrl());
        System.out.println("Baslik :"+driver.getTitle());

        // amazon ana sayfaya gittiginizi test edin

        // Test ; expected result ile actual result in karsilastirilmasidir
        // ornegin url amazon iceriyorsa

        String expectedIcerik="amazon";
        String actualUrl=driver.getCurrentUrl();



        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }




        driver.close();


    }
}

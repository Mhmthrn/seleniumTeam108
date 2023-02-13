package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_DriverManegeMethodlari {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Maximize Size: "+driver.manage().window().getSize());
        System.out.println("Maximize position :" +driver.manage().window().getPosition());

        driver.manage().window().maximize();

        System.out.println("Minimize Size: "+driver.manage().window().getSize());
        System.out.println("Minimize position :" +driver.manage().window().getPosition());


    }
}

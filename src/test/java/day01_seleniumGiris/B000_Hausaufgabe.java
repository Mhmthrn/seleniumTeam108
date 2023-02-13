package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class B000_Hausaufgabe {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.facebook.com");
        String expectedTitle="facebook";
        String actualTitle= driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Sayfa title i facebook icermektedir");
        }else {
            System.out.println(driver.getTitle());
        }
        Thread.sleep(5000);

        driver.navigate().to("https://www.walmart.com");
        String expectedTitle1="Walmart.com";
        String actualTitle1= driver.getTitle();

        if (actualTitle1.contains(expectedTitle1)){
            System.out.println("Sayfa title i www.walmart.com icermektedir");
        }else {
            System.out.println(driver.getTitle());
        }
        driver.navigate().back();
        driver.navigate().refresh();

        driver.manage().window().maximize();
        driver.close();


    }
}

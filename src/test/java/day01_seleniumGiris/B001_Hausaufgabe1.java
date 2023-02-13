package day01_seleniumGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class B001_Hausaufgabe1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.youtube.com");
        String expectedTitle="youtube";
        String actualTitle=driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("sayfa basligi youtube ifadesi icermektedir");
        }else {
            System.out.println(driver.getTitle());
        }

        Thread.sleep(5000);

        String expectedUrl="youtube";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("sayfa URL i youtube ifadesi icermektedir");
        }else {
            System.out.println(driver.getCurrentUrl());
        }

        driver.get("https://www.amazon.com");

        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.manage().window().maximize();

        Thread.sleep(5000);

        String expectedTitle1="Amazon";
        String actualTitle1=driver.getTitle();

        if (actualTitle1.contains(expectedTitle1)){
            System.out.println("sayfa basligi Amazon ifadesi icermektedir.");
        }
        else {
            System.out.println(driver.getTitle());
        }

        String expectedURL="https://www.amazon.com/";
        String actualURL=driver.getCurrentUrl();

        if (actualURL.contains(expectedURL)){
            System.out.println("sayfa basligi https://www.amazon.com/ ifadesi icermektedir.");
        }
        else {
            System.out.println(driver.getCurrentUrl());
        }

        driver.close();

    }
}

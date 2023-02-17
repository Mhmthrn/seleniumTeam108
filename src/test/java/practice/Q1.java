package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Q1 {
    /*...Exercise1...
    Create a new class under Q1 create main method
    Set Path
    Create chrome driver
    Maximize the window
    Open google home page https://www.google.com/.
    On the same class, Navigate to amazon home page  https://www.amazon.com/Navigate back to google
    Navigate forward to amazon
    Refresh the page
    Close/Quit the browser
    And last step : print "All Ok" on console
     */
    public static void main(String[] args) throws InterruptedException {
       System.setProperty("Webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();// tum ekrani kaplar arac cubugunu dahi gostermez
        Thread.sleep(3000);
        driver.manage().window().maximize();// tam ekran yapar arac cubugu ve diger araclar gorulur

        driver.get("https://www.google.com");
        Thread.sleep(3000);

        driver.navigate().to("https://www.amazon.com/");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();

        driver.close();

        System.out.println("All Ok");


    }
}

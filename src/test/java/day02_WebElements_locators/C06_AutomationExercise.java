package day02_WebElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C06_AutomationExercise {
    public static void main(String[] args) throws InterruptedException {
       // 1- Bir test class’i olusturun ilgili ayarlari yapin
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com");
       // 3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementleriList = driver.findElements(By.tagName("a"));

        int expectedLinkSayisi=147;
        int actualLinkSayisi=linkElementleriList.size();

        if (actualLinkSayisi== expectedLinkSayisi){
            System.out.println("Link saysi testi Passed");
        }else {
            System.out.println("Linke testi sayisi testi Failed" +
                    "\nsayfade var olan link sayisi:"+ actualLinkSayisi);
        }
        // 4- Products linkine tiklayin

        driver.findElement(By.partialLinkText(" Products")).click();

       // 5- special offer yazisinin gorundugunu test edin

        WebElement spesialOfferElementi=driver.findElement(By.id("sale_image"));
        if (spesialOfferElementi.isDisplayed()){
            System.out.println("Special offer testi PASSED");
        }else{
            System.out.println("Specilal offer testi Failed");
        }

       // 6- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();



    }
}

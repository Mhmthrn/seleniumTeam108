package practice;

import com.fasterxml.jackson.annotation.JsonValue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {
    /* ...Exercise2...
 1 - Driver olusturalim
 2 - Java class'imiza chromedriver.exe'yi tanitalim
 3 - Driver'in tum ekrani kaplamasini saglayalim
 4 - Driver'a sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini
     söyleyelim. Eger oncesinde sayfa yuklenirse, beklemeyi bıraksin.
 5 - "https://www.otto.de" adresine gidelim
 6 - Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
 7 - Title ve url'nin "OTTO" kelimesinin icerip icermedigini kontrol edelim
 8 - Ardindan "https://wisequarter.com/" adresine gidelim
 9 - Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini
     kontrol edelim
 10- Bir onceki web sayfamiza geri donelim
 11- Sayfayi yenileyelim
 12- Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
 13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://www.otto.de");
        String title=driver.getTitle();
        String url=driver.getCurrentUrl();
        String expectedIcerik="OTTO";

        System.out.println("Sayfa title : "+title);
        System.out.println("Sayfa URL : "+url);


        if (title.contains(expectedIcerik)){
            System.out.println("Sayfa basligi OTTO ifadesi icermektedir");
        }else {
            System.out.println("Sayfa basligi OTTO ifadesi icermemektedir !!!");
        }


        if (url.contains(expectedIcerik)){
            System.out.println("Sayfa URL OTTO ifadesi icermektedir");
        }else {
            System.out.println("Sayfa URL OTTO ifadesi icermemektedir !!!");
        }
        Thread.sleep(3000);

        driver.navigate().to("https://wisequarter.com/");

        String title1=driver.getTitle();

        String expectedIcerik1="Quarter";

        System.out.println("Sayfa title : "+title1);


        if (title1.contains(expectedIcerik1)){
            System.out.println("Sayfa basligi Quarter ifadesi icermektedir");
        }else {
            System.out.println("Sayfa basligi Quarter ifadesi icermemektedir !!!");
        }

        driver.navigate().back();
        driver.navigate().refresh();

        driver.navigate().forward();
        driver.close();
        Thread.sleep(3000);

        driver.quit();



    }
}

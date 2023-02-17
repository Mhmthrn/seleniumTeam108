package day04_junitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {


        /*
        Framework : ortak calisma cercevesi
                    hangi dosyalri nerede olusturacagimizi beilrler boylece toplu calismayi kolaylastirir.
                    Her Framework, dosya duzeni olusturmanin yaninda islerimizi kolaylastiran yeni ozellikler
                    sunmustur.

                    JUnit framework en temel test framework dur.
                    bize kazandirdigi en onemli ozellik @Test Annotation (Notasyon) dur.

                    @Test notasyonu sayesinde herbir method
                    bagimsiz olarak calistirilabilen bir test
                    methodu olur.

                    Test notasyonu sayesinde istersek herbir test methodunu basgimsiz calistirabildigimiz gibi
                    istesek class level de calistirip tum testleri calismasini saglayabiliriz.

                    JUnit ile test methodlarinin hangi sira ilr calisacagini ongoremeyiz ve kontrol edemeyiz.
         */


    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.wisequarter.com");
        driver.close();
    }

    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.youtube.com");
        driver.close();
    }
}

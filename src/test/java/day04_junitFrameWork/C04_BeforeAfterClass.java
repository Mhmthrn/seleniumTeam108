package day04_junitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfterClass {

    // 3 test method'u olusturun




    // Eger herbir test methodu icin driver olusturup sonunda kapatmamiz gerekmiyorsa
    // classin basinda bir kez driver olusturup clasin sonunda kapatabiliriz.

   // @BeforeClass,@AfterClass notasyonu olan methodlar static olmali
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void teardown(){
        driver.close();

    }

    @Test
    public void test01(){
        // 1.amazon anasayfaya gidip, amazona gittiginizi test edin
        driver.get("https://www.amazon.com");
        String expectedIceriik="amazon";
        String actulaUrl=driver.getCurrentUrl();

        if (actulaUrl.contains(expectedIceriik)){
            System.out.println("Amazon testi passed");
        }else {
            System.out.println("URL amazon icermiyor test Failed");
        }
    }

    @Test
    public void test02(){
        // 2.Nutella aratip arama sonuclarinin nutella icerdigini test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement aramaSonucElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        String expectedIcerik="Nutella";
        String actulaSonucyazidi=aramaSonucElementi.getText();

        if (actulaSonucyazidi.contains(expectedIcerik)){
            System.out.println("Nutella Testi Passed");
        }else {
            System.out.println("Nutella testi Failed");
        }
    }
    @Test@Ignore
    public void test03(){
        // 3.Ilk urune tiklayip, urun isminde Nutella gectigini test edin

        WebElement ilkUrun=driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        ilkUrun.click();

        WebElement urunIsimElementi=driver.findElement(By.xpath("//span[@id='productTitle']"));

        String expectedIcerik="Nutella";
        String actulaIcerik=urunIsimElementi.getText();

        if (actulaIcerik.contains(expectedIcerik)){
            System.out.println("Ilk urun testi Passed");
        }else{
            System.out.println("Ilk urun testi Failed");
        }



    }

}

package day04_junitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_IlkAssertion {
    //1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void test01() {
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin

        String expectedUrl = "https://www.bestbuy.com/";
        String actulURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actulURL);

    }

    @Test
    public void test02() {
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin


        String expecteIcerik = "Rest";
        String actulTitle = driver.getTitle();

        Assert.assertFalse(expecteIcerik.contains(actulTitle));

    }

    @Test
    public void test03() {
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin


        WebElement logo= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));


        Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test04() {
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

        WebElement fransizcLink= driver.findElement(By.xpath("(//button[text()='Français'])[1]"));


        Assert.assertTrue(fransizcLink.isDisplayed());

    }
}


package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C01_Assertions {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //    ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

       WebElement cookiesKabulButonu= driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]"));
       cookiesKabulButonu.click();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void titleTest(){

        //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle="YouTube";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Test
    public void imageTests(){
        //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin

        WebElement logoElement=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'][1])"));

        Assert.assertTrue(logoElement.isDisplayed());

    }

    @Test
    public void searchBoxTest(){
        //    ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())

        WebElement searchElement= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchElement.isEnabled());

    }

    @Test
    public void wrongTitile(){
        String unexpectedTitle="youtube";
        String actualTitle=driver.getTitle();
        Assert.assertNotEquals(unexpectedTitle,actualTitle);
    }


}

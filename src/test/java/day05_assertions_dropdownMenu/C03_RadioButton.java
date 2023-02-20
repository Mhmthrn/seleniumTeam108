package day05_assertions_dropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    static WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
       driver.close();
    }
    @Test
    public void tests01(){
        // a. Verilen web sayfasına gidin.
        //     https://facebook.com
        driver.get("https://facebook.com");

        // b. Cookies’i kabul edin
        WebElement cokiesKabul=driver.findElement(By.xpath("(//button[@data-testid='cookie-policy-manage-dialog-accept-button'])[2]"));
        cokiesKabul.click();
        // c. Create an account buton’una basin
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
        // d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement femaleButton=driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleButton=driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement costumButton=driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
        maleButton.click();
        // e. sectiginiz radio buttonun secili otekilerin secili olmadigini test edin
        Assert.assertTrue(maleButton.isSelected());
        Assert.assertFalse(femaleButton.isSelected());
        Assert.assertFalse(costumButton.isSelected());


    }

}

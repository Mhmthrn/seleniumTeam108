package day04_junitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ZeroTest {
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();

        //3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //4. Password alanine “password” yazdirin
        driver.findElement(By.id("user_password")).sendKeys("password");

        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        //6 back tusu ile sayfaya donun
        driver.navigate().back();

        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("200");

        //9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement mesajElementi=driver.findElement(By.id("alert_content"));

       if (mesajElementi.isDisplayed()){
           System.out.println("Test Passed");
       }else{
           System.out.println("Test Failed");
       }

       driver.close();

    }

}

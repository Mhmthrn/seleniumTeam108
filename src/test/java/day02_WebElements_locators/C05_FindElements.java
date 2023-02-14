package day02_WebElements_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_FindElements {
    public static void main(String[] args) throws InterruptedException {
        /*
        amazon ana sayfaya gidin arama kutusuna java yazin arama sonuclarinida cilan resimlerdeki yazileri yazdirin
         */
       // System.setProperty("Webdriver.chrome.driver","src/main/driver/chromedriver_win32/chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.amazon.com");

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("java"+ Keys.ENTER);
       // aramaKutusu.submit();

        List<WebElement> aramaSonuclariElementList=driver.findElements(By.className("sg-col-inner"));


        System.out.println(aramaSonuclariElementList.size());
        int elementNo=1;
        for (WebElement eachElement:aramaSonuclariElementList){
            System.out.println(elementNo +"--------"+ eachElement.getText());
            elementNo++;
        }


        Thread.sleep(3000);

        driver.close();
    }
}

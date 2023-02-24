package day08_explicitlyWait_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C06_WebTables  extends TestBase {
    @Test
    public void test(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        // 2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerBasliklar=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));

        int siraNo=1;
        for (WebElement eachHead:headerBasliklar){
            System.out.println(siraNo+" : "+eachHead.getText());
        }
        System.out.println("=-=-=-=-=-=-=-3-=-=-=-=-=-=-=-=-=-=-=-=");
        // 3. 3.sutunun basligini yazdirin
        System.out.println("3.sutunun basli : "+driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[3]")).getText());
        System.out.println("=-=-=-=-=-=-=-4-=-=-=-=-=-=-=-=-=-=-=-=");

        // 4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDatalar=driver.findElements(By.xpath(" //div[@class='rt-td']"));
         siraNo=1;
        for (WebElement eachHead:tumDatalar){
            System.out.println(siraNo+" : "+eachHead.getText());
            siraNo++;
        }
        System.out.println("=-=-=-=-=-=-=-5-=-=-=-=-=-=-=-=-=-=-=-=");
        // 5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin


        System.out.println("=-=-=-=-=-=-=-6-=-=-=-=-=-=-=-=-=-=-=-=");
        // 6. Tablodaki satir sayisini yazdirin

        System.out.println("=-=-=-=-=-=-=-7-=-=-=-=-=-=-=-=-=-=-=-=");
        // 7. Tablodaki sutun sayisini yazdirin

        System.out.println("=-=-=-=-=-=-=-8-=-=-=-=-=-=-=-=-=-=-=-=");
        // 8. Tablodaki 3.kolonu yazdirin
        System.out.println("=-=-=-=-=-=-=-9-=-=-=-=-=-=-=-=-=-=-=-=");
        // 9. Tabloda “First Name” i Kierra olan kisinin Salary’sini yazdirin
        System.out.println("=-=-=-=-=-=-=-10-=-=-=-=-=-=-=-=-=-=-=-=");
        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin
    }


}

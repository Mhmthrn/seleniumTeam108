package day08_explicitlyWait_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;


import java.util.Set;

public class C04_Cookies extends TestBase {
    @Test
    public  void test01(){
        //Yeni bir class olusturun : cookiesAutomation
        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet=driver.manage().getCookies();
        int siraNo=1;
        for (Cookie eachCookie:cookiesSet){
            System.out.println(siraNo+" =-= "+eachCookie.toString());
            siraNo++;
        }
        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookiesSet.size()>5);
        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
       String actualValue= driver.manage().getCookieNamed("i18n-prefs").getValue();
       String expectedValue="USD";
       Assert.assertEquals(expectedValue,actualValue);
        // 5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie olusturun ve sayfaya ekleyin
        Cookie benimCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(benimCookie);
        cookiesSet=driver.manage().getCookies();
        siraNo=1;
        for (Cookie eachCookie:cookiesSet){
            System.out.println(siraNo+" =-= "+eachCookie.toString());
            siraNo++;
        }
        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        actualValue=driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        expectedValue="cikolatali";
        Assert.assertEquals(expectedValue,actualValue);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        // olmayan bir elemani tst edemem bunun yerine
        // for each loop ile ele aldigimiz her cookie cintrol edelim
        // ismi skin olan varsa test faild olun
        driver.manage().deleteCookieNamed("skin");
        cookiesSet=driver.manage().getCookies();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        for (Cookie eachCookie:cookiesSet){
            Assert.assertNotEquals("skin", eachCookie.getName());


        }


        //8- tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet=driver.manage().getCookies();

        Assert.assertEquals(0, cookiesSet.size());
    }
}

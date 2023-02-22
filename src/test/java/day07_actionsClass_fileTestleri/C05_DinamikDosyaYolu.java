package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DinamikDosyaYolu {
    @Test
    public void test01(){

        // download da bulunanan The delta isimli bir dosya bulundugunu test edin
        String dosyaYolu=System.getProperty("user.home")+"\\Downloads\\JavaFileDokument\\TheDelta.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}

package day07_actionsClass_fileTestleri;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FilePath {
    @Test
    public void test01(){
        // bilgisayarimizin temel dosya yolu user.home

        // icinde bulundugumuz projenin temel dosya yolu user.dir
        /*
            Bilgisayarimizda bir dosyanin var oldugunu test etmek icin
            dosya yoluna ihtiyacimiz var
            Ancak herkesin bilgisayarindaki dosya yollari
            farkliliklar gosterir
            herkesin bilgisayarina gore farkli olan kismi
            java'dan bir komut ile elde edebiliriz
         */

        //user.home bilgisayarimizdaki  dosya yolu
       // "C:\Users\USER\DDownloads\JavaFileDokument\TheDelta.docx"

        // user.dir
        // C:\Users\USER\IdeaProjects\com.seleniumTeam108\src\test\java\day07_actionsClass_fileTestleri\text.txt


        String dosyayolu= "C:\\Users\\USER\\Downloads\\JavaFileDokument\\TheDelta.docx";

        boolean sonuc= Files.exists(Paths.get(dosyayolu));
        System.out.println(sonuc);

        /*
        herkesin bilgisayarina gore farkli olan kusmi java dan bir komnut ile elde edebiliriz
         */
        dosyayolu=System.getProperty("user.home")+"\\Downloads\\JavaFileDokument\\TheDelta.docx";
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }
}

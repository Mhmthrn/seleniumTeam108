package day04_junitFrameWork;

import org.junit.*;

public class C05_BirlikteKullanim {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass calisti\n-=-=-=-==-=-=-=-=-=-=-=");

    }

    @AfterClass
    public static void afterClass(){
        System.out.println("=-=-=-==-=-=-=-=-=-=-=\nAfterClass calisti");

    }

    @Before
    public void before(){
        System.out.println("\nbefore methodu calisti");
    }

    @After
    public void after(){
        System.out.println("After methodu calisti");
    }

    @Test
    public void test01(){
        System.out.println("test1 calisti");
    }
    @Test
    public void test02(){
        System.out.println("test2 calisti");
    }
    @Test
    public void test03(){
        System.out.println("test3 calisti");
    }
}

package day05;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C02_BeforeClassNotasyonu {

    // amazon sayfasina gidip 3 farkli test methodu hazirlayin
    // her method'da farkli aramalar yapalim

    static WebDriver driver;
    WebElement searchTextBox= driver.findElement(By.id("twotabsearchtextbox"));

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");



    }
    @Test
    public void test1(){
        searchTextBox.clear();
        searchTextBox.sendKeys("nutella"+ Keys.ENTER);

    }

    @Test
    public void test2(){
        searchTextBox.clear();
        searchTextBox.sendKeys("bicycle"+ Keys.ENTER);

   }

    @Test
    public void test3(){
        searchTextBox.clear();
        searchTextBox.sendKeys("java"+ Keys.ENTER);

    }

    @AfterClass
    public static void tearDown(){

        driver.close();

    }


}
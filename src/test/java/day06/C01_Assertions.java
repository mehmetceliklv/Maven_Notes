package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C01_Assertions {
    static WebDriver driver;


    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void urlTest(){
        String expectedURL="https://www.bestbuy.com/";
        String actualURL= driver.getCurrentUrl();
        Assert.assertEquals("Istenen URL bulanamadi",expectedURL,actualURL);

    }

    @Test
    public void titleTest(){
        String istenmeyenKelime="Rest";
        String actualTitle=driver.getTitle();

        Assert.assertFalse("istenmeyen kelime title da var", actualTitle.contains(istenmeyenKelime));
    }
    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.xpath("(//img[@class= 'logo'])[1]"));
        Assert.assertTrue("Logo gorunmuyor", logo.isDisplayed());
    }

    @Test
    public void fransizcaTesti(){
        WebElement fransizcaLinki=driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue("Fransizca linki gorunmuyor",fransizcaLinki.isDisplayed());
    }

    @AfterClass
    public static void tearDown() {

        driver.close();
    }

    
}
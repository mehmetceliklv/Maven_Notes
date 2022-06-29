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

public class C02_AssertionsYoutube {

    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
    //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //	 ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //	○ wrongTitleTest	=> Sayfa basliginin “youtube” olmadigini dogrulayin

   static WebDriver driver;
    @BeforeClass
    public static void setup(){

       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
       driver.get("https://www.youtube.com");

   }


   @Test
    public void titleTest(){
       String expectedTitle="YouTube";
       String actualTitle=driver.getTitle();
       Assert.assertEquals("Sayfa basligi beklenenden farkli",expectedTitle,actualTitle);

   }

   @Test
    public void logoTest(){

       WebElement logo= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
       Assert.assertTrue("logo gorunmuyor",logo.isDisplayed());

   }

    @Test
    public void searchBoxTest(){

        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue("searchbox aktif degil",searchBox.isEnabled());

    }

    @Test
    public void wrongTitleTest(){
        String expectedTitle1="Youtube";
        String actualTitle1=driver.getTitle();
        Assert.assertNotEquals("Sayfa basligi beklenenden gibi",expectedTitle1,actualTitle1);

       // Assert.assertFalse("false mesaji",expectedTitle1.equals(actualTitle));
       // Assert.assertTrue("True Mesaji",!expectedTitle1.equals(actualTitle));
        }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    }
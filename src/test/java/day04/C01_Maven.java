package day04;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C01_Maven {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


        // class'in basinda implicitlywait komutu yazilirsa
        // bu test boyunca her locator icin driver maximum yazilan zaman kadar bekler

        //1- https://www.amazon.com/ sayfasina gidelim
        //2- arama kutusunu locate edelim
        //3- “Samsung headphones” ile arama yapalim
        //4- Bulunan sonuc sayisini yazdiralim
        //5- Ilk urunu tiklayalim
        //6- Sayfadaki tum basliklari yazdiralim






        driver.get("https://www.amazon.com");

        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("samsung headphones"+ Keys.ENTER);

        //WebElement sonucYazisiElementi=driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small"));
        // By.className ile locate ettigimiz webelementinde class attribute'nun degerinde
        // bosluk varsa locator saglikli calismayabilir

        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisiElementi.getText());

        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
        Thread.sleep(3000);

        driver.navigate().back();

        List<WebElement> urunlerListesi= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        for (WebElement each:urunlerListesi) {
            System.out.println(each.getText());
        }




    }
}

package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C03_Test02 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //1. http://zero.webappsecurity.com sayfasina gidin
        //2. Signin buttonuna tiklayin
        //3. Login alanine  “username” yazdirin
        //4. Password alanine “password” yazdirin
        //5. Sign in buttonuna tiklayin
        //6. Pay Bills sayfasina gidin
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //8. tarih kismina “2020-09-10” yazdirin
        //9. Pay buttonuna tiklayin
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin







        driver.get(" http://zero.webappsecurity.com");

        WebElement signInButon= driver.findElement(By.id("signin_button"));
        signInButon.click();

        WebElement loginTextBox=driver.findElement(By.id("user_login"));
        loginTextBox.sendKeys("username");

        WebElement passTextBox= driver.findElement(By.xpath("//input[@id='user_password']"));

        passTextBox.sendKeys("password");

        WebElement signInButon2= driver.findElement(By.name("submit"));
        signInButon2.click();
        driver.get(" http://zero.webappsecurity.com");

        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        driver.findElement(By.id("sp_amount")).sendKeys("250");
        driver.findElement(By.id("sp_date")).sendKeys("2022-09-10");
        driver.findElement(By.id("pay_saved_payees")).click();

        WebElement basariliYazisiElementi= driver.findElement(By.id("alert_content"));

        if (basariliYazisiElementi.isDisplayed()) {
            System.out.println("Odeme uyarisi cikti,Test PASS");
        }else{
            System.out.println("Odeme uyarisi cikmadi,Test FAILED");
        }










    }
}

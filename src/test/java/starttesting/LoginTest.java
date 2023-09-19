package starttesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {


    WebDriver driver;

    @BeforeClass
    public void preconditions(){
        driver = new ChromeDriver();
        driver.navigate().to("https://ilcarro.web.app/search");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }

    @Test
    public void loginPositive(){
        /*
        1. click login
        2. fill input email
        3. fill input password
        4. click yalla
        5. validate by text: Logged in success in the element //h2[@class = 'message']
        */

        WebElement btnLogin = driver.findElement(By.xpath(""));
        btnLogin.click();

        WebElement inputEmail = driver.findElement(By.xpath(""));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("");

        WebElement inputPassword = driver.findElement(By.xpath(""));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("");

        WebElement btnYalla = driver.findElement(By.xpath(""));
        btnYalla.click();

        WebElement textMessagePopUPh2 =driver.findElement(By.xpath("//h2[@class = 'message']"));
        String TextMessageH2 = textMessagePopUPh2.getText().trim().toUpperCase();
        String expectedResult ="Logged in success".toUpperCase();



    }



    @AfterClass
    public void postConditions(){
        driver.quit();
    }

}
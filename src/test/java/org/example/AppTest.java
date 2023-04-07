package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.ResourceBundle;

public class AppTest
{
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser", "Url"})
    public void openbrowser(String browser, String Url)
    {
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.get(Url);

    }
    @Test
    public void login()
    {
        ResourceBundle r = ResourceBundle.getBundle("config");

        String email = r.getString("email");

        String password = r.getString("password");


        driver.findElement(By.cssSelector("input#id='login_field")).sendKeys(email);

        driver.findElement(By.cssSelector("input#id='password']")).sendKeys(password);

        driver.findElement(By.cssSelector("input#name='commit'")).click();

    }
    @AfterClass
    public void closee()
    {
        driver.close();
    }

}




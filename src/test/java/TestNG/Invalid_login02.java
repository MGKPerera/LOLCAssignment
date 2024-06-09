package TestNG;

import PageObject.PageObjectClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Invalid_login02 {
    private WebDriver driver;
    PageObjectClass pageObjectClass;



    @BeforeMethod
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        pageObjectClass = new PageObjectClass(driver);
    }

    @Test
    public void testInvalidLogin() throws Exception {
        pageObjectClass.InvalidUserLogin();
    }

    @AfterMethod
    public void DriverClose() {
        pageObjectClass.Closedriver();
    }


}

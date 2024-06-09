package TestNG;

import PageObject.PageObjectClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Valid_Login01 {
    WebDriver driver;
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
    public void testValidLogin() throws Exception {
        pageObjectClass.ValidUserLogin();
    }


    @AfterMethod
    public void DriverClose() {
        pageObjectClass.Closedriver();
    }




}

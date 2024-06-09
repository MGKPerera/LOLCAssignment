package PageObject;

import PageFactory.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class PageObjectClass {

    WebDriver driver;

    //creating constructor
    public PageObjectClass(WebDriver driver) {
        this.driver = driver;
    }


    public void ValidUserLogin() throws Exception {

        Thread.sleep(500);
        WebElement usernameField = driver.findElement(By.xpath(PageFactory.txt_username));
        WebElement passwordField = driver.findElement(By.xpath(PageFactory.txt_Password));

        //here entering the valid user name and password
        Thread.sleep(500);
        usernameField.sendKeys("standard_user");
        Thread.sleep(500);
        passwordField.sendKeys("secret_sauce");

        //click on the login button
        WebElement loginButton = driver.findElement(By.xpath(PageFactory.btn_login));
        Thread.sleep(500);
        loginButton.click();

        //verify that user has successfully login to the system
        WebElement headerOfSuccessLogin = driver.findElement(By.xpath(PageFactory.header_SuccessLogin));
        Thread.sleep(1000);
        Assert.assertTrue(headerOfSuccessLogin.isDisplayed());
        System.out.println("successful login!!!!");

//        driver.close();
    }

    public void InvalidUserLogin() throws Exception {

        Thread.sleep(500);
        WebElement usernameField = driver.findElement(By.xpath(PageFactory.txt_username));
        WebElement passwordField = driver.findElement(By.xpath(PageFactory.txt_Password));

        //here entering the invalid user name and password
        Thread.sleep(500);
        usernameField.sendKeys("ABC");
        Thread.sleep(500);
        passwordField.sendKeys("abc");

        //click on the login button
        WebElement loginButton = driver.findElement(By.xpath(PageFactory.btn_login));
        Thread.sleep(500);
        loginButton.click();

        //verify that invalid login
        WebElement ErrorMsgOfUnsuccessFulLogin = driver.findElement(By.xpath(PageFactory.Message_ErrorLogin));
        Thread.sleep(500);
        Assert.assertTrue(ErrorMsgOfUnsuccessFulLogin.isDisplayed());
        System.out.println("UnsuccessfulFul Login!");
    }

    public void Closedriver() {
        if (driver != null) {
            driver.close();
        }
    }
}
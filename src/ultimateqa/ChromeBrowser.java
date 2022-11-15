package ultimateqa;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowser {

    public static void main(String[] args) {

        String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //launch the url
        driver.get(baseUrl);
        //maximise the browser window
        driver.manage().window().maximize();
        //give implicit wait time to the driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Print page title
        System.out.println("Page Title: " + driver.getTitle());
        //Print current url
        System.out.println("Current url: " + driver.getCurrentUrl());
        //Print page source
        System.out.println("Page source: " + driver.getPageSource());

        //Find the email field element and send data to the field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("test123@gmail.com");

        //Find the password field element and send data to the field
        WebElement passField = driver.findElement(By.id("user[password]"));
        passField.sendKeys("test123");

        //closing the browser
        driver.quit();


    }

}

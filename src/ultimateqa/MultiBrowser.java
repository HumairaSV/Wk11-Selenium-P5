package ultimateqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {

    static String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
    static String browser = "edge";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.ghecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println("Incorrect browser name-Select from Chrome or Edge or Firefox");
        }

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

        //find the email field element and send data to the field
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("test123@gmail.com");

        //find the password field element and send data to the field
        WebElement passField = driver.findElement(By.id("user[password]"));
        passField.sendKeys("test123");

        //closing the browser
        driver.quit();

    }

}

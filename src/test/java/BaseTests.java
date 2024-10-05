import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pages.HomePage;

import java.time.Duration;

public class BaseTests {
    public WebDriver driver;
    protected HomePage homePage;



    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(new ChromeOptions().addArguments("disable-infobars"));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.eg/");
        homePage=new HomePage(driver);


    }

    public void goHome(){
        driver.get("https://www.amazon.eg/");
    }


    @AfterSuite
    public void afterTest(){
        driver.quit();
        }


}

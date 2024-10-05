package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v125.page.model.WebAppManifest;

public class SunGlasses {

    WebDriver driver;

    public SunGlasses(WebDriver driver){
        this.driver=driver;
    }


    public RedSunglasses applyColorFilter(){
        driver.findElement(By.xpath("(//div[@class='colorsprite aok-float-left'])[5]")).click();
        return new RedSunglasses(driver);
    }
}

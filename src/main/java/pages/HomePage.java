package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By searchField=By.xpath("//input[@id='twotabsearchtextbox']");
    private By searchButton=By.xpath("//input[@id='nav-search-submit-button']");

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void searchingForProducts(String SearchProduct){
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(SearchProduct);
        driver.findElement(searchButton).click();
    }

    public SchoolBags searchForSchoolBags(){
        return new SchoolBags(driver);
    }


    public SunGlasses sesarchForSunGlasses(){
        return new SunGlasses(driver);
    }

}



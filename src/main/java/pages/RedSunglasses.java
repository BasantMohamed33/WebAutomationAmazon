package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RedSunglasses {

    WebDriver driver;


    public RedSunglasses(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyFilteredProducts(String expectedColor) {
        List<WebElement> products = driver.findElements(By.xpath("//img[@class='s-image']"));

        for (WebElement product : products) {
            String productColor = product.findElement(By.xpath("//li[@id='p_n_size_two_browse-vebin/21909003031']")).getText();

            if (!productColor.equalsIgnoreCase(expectedColor)) {
                return false;
            }
        }
        return true;
    }
}
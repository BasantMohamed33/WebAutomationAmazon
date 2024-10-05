
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class Tests extends BaseTests {


    @Test
    public void Getproducts() throws IOException {
        homePage.searchingForProducts("School Bag");
        var schoolBagPage=homePage.searchForSchoolBags();
        schoolBagPage.returnResults();
    }

    @Test
    public void filterResults(){
        homePage.searchingForProducts("sun glassess");
        var sunGlassesPage=homePage.sesarchForSunGlasses();
        var redSunGlasses =sunGlassesPage.applyColorFilter();
        By redColor=By.xpath("//li[@id='p_n_size_two_browse-vebin/21909003031']");
        redSunGlasses.verifyFilteredProducts(driver.findElement(redColor).getText());

        boolean areProductsFiltered = redSunGlasses.verifyFilteredProducts(driver.findElement(redColor).getText());
        Assert.assertTrue(areProductsFiltered, "The products are not filtered correctly!");


    }
}
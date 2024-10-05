package pages;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class SchoolBags {

    private WebDriver driver;
    private WebDriverWait wait;


    public SchoolBags(WebDriver driver) {
        this.driver = driver;
    }

    public void returnResults() throws IOException {

        wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='a-size-medium-plus a-spacing-none a-color-base a-text-bold']")));

        List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        List<WebElement> ProductsPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        // Print the number of products and prices for debugging
        System.out.println(products.size());
        System.out.println(ProductsPrice.size());

        // Create a new Excel workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Products");

        // Write the header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Product Name");
        header.createCell(1).setCellValue("Price");

        // Loop through the products and prices
        int rowCount = 1;
        for (int i = 0; i < products.size() && i < ProductsPrice.size(); i++) {
            String productName = products.get(i).getText();
            String price = ProductsPrice.get(i).getText();

            // Create a new row and write the product data
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(productName);
            row.createCell(1).setCellValue(price);
        }


        // Write the data to an Excel file
        FileOutputStream fileOut = new FileOutputStream("SchoolBagProducts.xlsx");
        workbook.write(fileOut);

        // Close the workbook and file stream
        workbook.close();
        fileOut.close();

        // Close the browser
        driver.quit();

        System.out.println("Data has been successfully extracted to 'SchoolBagProducts.xlsx'.");
    }

    }



       /* if (elements.size() >0 && elementPrice.size() >0){
            Workbook workbook=new XSSFWorkbook();
            Sheet sheet= workbook.createSheet("School Bags");

            Row headerRow=sheet.createRow(0);
            Cell headearCell=headerRow.createCell(0);
            headearCell.setCellValue("Product Name");
            Cell headerCell2 = headerRow.createCell(1);
            headerCell2.setCellValue("Product Price");

            int minSize = Math.min(elements.size(), elementPrice.size());
            for (int i = 0; i < minSize; i++) {
                Row row = sheet.createRow(i + 1);
                Cell cell1 = row.createCell(0);
                cell1.setCellValue(elements.get(i).getText());
                Cell cell2 = row.createCell(1);
                cell2.setCellValue(elementPrice.get(i).getText());
            }

            FileOutputStream fileOutputStream = new FileOutputStream("SchoolPagsProducts.xlsx");
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } else {
            System.out.println("No products found");
        }
    }*/




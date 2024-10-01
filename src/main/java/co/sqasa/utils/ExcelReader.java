package co.sqasa.utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
public class ExcelReader {
    public static List<String> getProducts(String filePath) {
        List<String> products = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                products.add(cell.getStringCellValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}

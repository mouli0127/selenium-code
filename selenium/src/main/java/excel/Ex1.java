package excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
Read from existing excel that has following data
excel location : "C:\\test\\Inputdata.xlsx"

un
admin1
admin2
admin3
admin4
admin5

*/
public class Ex1 {
public static void main(String[] args) throws FileNotFoundException, IOException {
Workbook fileObj = new XSSFWorkbook(new FileInputStream("C:\\test\\Inputdata.xlsx"));

Sheet sheetObj = fileObj.getSheetAt(0);

//how to get row count
int rowCount = sheetObj.getLastRowNum() - sheetObj.getFirstRowNum();


for(int r=0;r<=rowCount;r++) {
Row row = sheetObj.getRow(r);
int cells = row.getLastCellNum() - row.getFirstCellNum();

for(int c=0;c<cells;c++) {
Cell cell = row.getCell(c);
System.out.print(cell.getStringCellValue() + " ");
}
System.out.println("\n");
}

}
}
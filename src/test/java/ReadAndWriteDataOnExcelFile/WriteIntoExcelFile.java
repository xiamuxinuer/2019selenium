package ReadAndWriteDataOnExcelFile;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class WriteIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws IOException {

        FileInputStream inputStream =new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("QA3-short");
        Row row=sheet.getRow(0);// first row of file
        Cell cell=row.getCell(5);// find last cell
        System.out.println(cell.getStringCellValue());// get value of last cell
        cell.setCellValue("Failed");
        System.out.println("after change : "+cell.getStringCellValue());


        Row firstRow=sheet.getRow(0);
        Cell newCell=firstRow.createCell(6);
        newCell.setCellValue("Date of execution");

        Row secondRow= sheet.getRow(1);
        Cell newCell2=secondRow.createCell(6);
        newCell2.setCellValue(LocalDate.now().toString());


        FileOutputStream outputStream=new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();


    }


}

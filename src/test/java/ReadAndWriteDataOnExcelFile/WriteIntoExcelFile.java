package ReadAndWriteDataOnExcelFile;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WriteIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws IOException {

        FileInputStream inputStream =new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheet("QA3-short");
        Row row=sheet.getRow(0);// first row of file
        Cell cell=row.getCell(row.getLastCellNum()-1);// find last cell
        System.out.println(cell.getStringCellValue());// get value of last cell



    }


}

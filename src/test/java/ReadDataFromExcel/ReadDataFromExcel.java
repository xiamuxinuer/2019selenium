package ReadDataFromExcel;

import com.google.gson.internal.bind.util.ISO8601Utils;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import utilities.ExcelUtils;

import java.io.File;
import java.util.Map;

public class ReadDataFromExcel {
    @Test
    public void readExcelFileTest() throws Exception{
        //we need to get a file as an object
        File file = new File("VytrackTestUsers.xlsx");
        //object that represents excel file
        Workbook workbook = WorkbookFactory.create(file);
        //get QA1-short
        Sheet workSheet = workbook.getSheet("QA1-short");
        //get 1st row
        Row firstRow = workSheet.getRow(0);
        //get 1st cell
        Cell firstCell = firstRow.getCell(0);
        //get string value
        String value = firstCell.getStringCellValue();
        String secondCellValue=firstRow.getCell(1).getStringCellValue();
        //System.out.println(firstRow.getCell(1));

        System.out.println(value);
        System.out.println(secondCellValue);

        int lastCell=firstRow.getLastCellNum();

        System.out.println("###############");

        for (int i = 0; i <lastCell; i++) {
            System.out.print(firstRow.getCell(i)+"|");

        }
        System.out.println("################");

      int numberOFRows=workSheet.getLastRowNum();//index of last row
      int numberOfRows2=workSheet.getPhysicalNumberOfRows();
        System.out.println("index of last row :"+numberOFRows);
        System.out.println("total number of rows :"+ numberOfRows2);


        for (int row = 0; row <workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell <workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue=workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue+" | ");
            }
            System.out.println();
        }

    }

    @Test
    public void ExcelUtilityTest(){
        String path="VytrackTestUsers.xlsx";
        String spreadSheet="QA1-all";
        ExcelUtils excelUtils=new ExcelUtils(path,spreadSheet);
       for (Map<String,String> record:excelUtils.getDataList()){
           System.out.println(record);
       }


       // excelUtils.getDataList().forEach(System.out::println);
    }









}





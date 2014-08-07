import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 07.08.14
 * Time: 10:00
 * To change this template use File | Settings | File Templates.
 */
@Deprecated
public class ExcelProcessor {
    private static void xlsx(){
        try{
            InputStream file = new FileInputStream("zuko.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for(Iterator<Row> rowIterator = sheet.iterator(); rowIterator.hasNext();){
                Row row = rowIterator.next();
                for(Iterator<Cell> cellIterator = row.cellIterator(); cellIterator.hasNext();){
                    Cell cell = cellIterator.next();
                    switch(cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();

            FileOutputStream out = new FileOutputStream(new File("test.xls"));
            workbook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.SDET.programs.SDETAllProgramsinMaven;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public static List<Student> readDataFromExcel(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            Iterator<Row> iterator = sheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                if (currentRow.getRowNum() == 0) {
                    continue; // Skip header row
                }

                Iterator<Cell> cellIterator = currentRow.iterator();
                String name = cellIterator.next().getStringCellValue();
                String courses = cellIterator.next().getStringCellValue();
                String fee = cellIterator.next().getStringCellValue();

                Student student = new Student(name, courses, fee);
                students.add(student);
            }
        }

        return students;
    }
}

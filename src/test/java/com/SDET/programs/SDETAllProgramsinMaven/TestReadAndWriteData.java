package com.SDET.programs.SDETAllProgramsinMaven;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.util.List;

public class TestReadAndWriteData {

    @Test
    public void testReadAndPrintExcel() throws IOException {
        String filePath = "D://file.xlsx"; // Replace with the actual path
        List<Student> students = ExcelReader.readDataFromExcel(filePath);

        // Display students in console
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

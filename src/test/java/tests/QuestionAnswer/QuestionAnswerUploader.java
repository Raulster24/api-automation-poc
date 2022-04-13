package tests.QuestionAnswer;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utilities.GenerateAuthToken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static steps.Base.*;

public class QuestionAnswerUploader {

    @BeforeAll
    void setup() {
        accessToken = new GenerateAuthToken("oauth/token", null).GetToken();
        System.out.println(accessToken);
    }

    @Test
    void uploadQuestionAndAnswers() throws IOException {
        File file =    new File("./CategoryAssessment.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        Workbook categoryAssessmentExcel = new XSSFWorkbook(inputStream);
        Sheet sheet = categoryAssessmentExcel.getSheetAt(0);
        // Row row = sheet.getRow(0);
        // Cell cell = row.getCell(1);

        System.out.println(sheet.getRow(2).getCell(5));
        int numofRows = sheet.getLastRowNum();
        int numofColumns = sheet.getRow(0).getLastCellNum();
        System.out.println("No of rows" +numofRows+ "and number of columns"+numofColumns);

        for(int i = 0; i<= numofRows; i++) {
            for(int j = 0; j<numofColumns; j++) {

            }
        }
    }
}

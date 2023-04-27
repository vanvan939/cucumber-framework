package Utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
//import org.json.JSONObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadData {
    private static String registerSheet = "register";
    private static String dataPathExcel = "D:\\web-automation-java\\selenium-cucumber-framework\\src\\main\\java\\DataProviders\\data.xlsx";
    private static String dataPathJson = "D:\\web-automation-java\\selenium-cucumber-framework\\src\\main\\java\\DataProviders\\data.json";

    public List<String> getRegisterDataFromExcel(int row) throws IOException {
        List listTable = new ArrayList();
        File src=new File(dataPathExcel);
        FileInputStream fis=new FileInputStream(src);
        XSSFWorkbook srcBook= new XSSFWorkbook(fis);
        XSSFSheet sourceSheet = srcBook.getSheet(registerSheet);

        XSSFRow sourceRow = sourceSheet.getRow(row);
        XSSFCell displayName=sourceRow.getCell(0);
        XSSFCell email=sourceRow.getCell(1);
        XSSFCell password=sourceRow.getCell(2);

        String displayNameExcel = displayName.getStringCellValue();
        String userExcel = email.getStringCellValue();
        String pwExcel = password.getStringCellValue();

        listTable.add(displayNameExcel);
        listTable.add(userExcel);
        listTable.add(pwExcel);

        return listTable;
    }
    public JSONObject getRegisterDataFromJSON(int row) throws org.json.simple.parser.ParseException {
        JSONObject map = null;
        try {
            JSONParser parser = new JSONParser();

            JSONObject data = (JSONObject) parser.parse(
                    new FileReader(dataPathJson));  //path to the JSON file.

            List totalRegisterData = (List) data.get(registerSheet);
            map = (JSONObject) totalRegisterData.get(row);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args)  {
        String a = "-0.001";
        float f=Float.parseFloat(a);
        System.out.println(f);
    }
}

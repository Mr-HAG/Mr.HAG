package com.cybertek.tests.day19_ddf;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilsDemo {

    @Test
    public void readExcelFile(){

        //create an object from ExcelUtil
        //it accepts to arguments
        // Argument 1: location of the file(path)
        //Argument 2: sheet that we want to open(sheetName)

        ExcelUtil qa3short = new ExcelUtil("src\\test\\Resources\\Vytracktestdata.xlsx","QA3-short");

        //how many rows in the sheet
        System.out.println("Row Count = " + qa3short.rowCount());

        //how many columns in the sheet
        System.out.println("Column Count = " + qa3short.columnCount());

        //get all columns names
        System.out.println("Column Names = " + qa3short.getColumnsNames());

        //get all data in list of maps
        List<Map<String,String>> dataList = qa3short.getDataList();
        System.out.println("qa3short.getDataList().get(2) = " + qa3short.getDataList().get(2));
        System.out.println("All data in list of maps = " + qa3short.getDataList());
        for (Map<String, String> oneRow : dataList) {
            System.out.println(oneRow);
        }

        //get all data in 2d array
        String[][] dataArray = qa3short.getDataArray();
        System.out.println(Arrays.deepToString(dataArray));


    }
}

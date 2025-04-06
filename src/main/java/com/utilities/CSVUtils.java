package com.utilities;

import com.opencsv.bean.CsvToBeanBuilder;
import com.s2p.LoginData;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class CSVUtils {

    public static List<LoginData> readCSV(String filePath,String testCaseName) {
        try {
            List<LoginData> allData = new CsvToBeanBuilder<LoginData>(new FileReader(filePath))
                    .withType(LoginData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();

            return allData.stream()
                    .filter(data -> data.getTestCaseName().equalsIgnoreCase(testCaseName))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    }
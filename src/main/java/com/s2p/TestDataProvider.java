package com.s2p;

import com.utilities.CSVUtils;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

public class TestDataProvider {

    @DataProvider(name = "csvLoginData")
    public static Object[][] getLoginDataFromCSV(Method method) {
        String path = System.getProperty("user.dir")+ File.separator +"src"+File.separator+"test"+File.separator+"resources"+File.separator+ "loginData.csv";
        String testName = method.getName();  // test method ka naam fetch karo
        List<LoginData> matchedData = CSVUtils.readCSV(path, testName);

        Object[][] data = new Object[matchedData.size()][1];
        for (int i = 0; i < matchedData.size(); i++) {
            data[i][0] = matchedData.get(i);
        }

        return data;
    }
}
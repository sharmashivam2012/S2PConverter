package com.s2p;

import com.opencsv.bean.CsvBindByName;
import lombok.*;



@Data // generates getters, setters, toString, equals, hashCode
@NoArgsConstructor
public class LoginData {

    @CsvBindByName(column = "testCaseName")
    private String testCaseName;

    @CsvBindByName(column ="username" )
    private String username;

    @CsvBindByName(column = "password")
    private String password;
}
package com.example.easy34propertiesmanagement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("vars")
@RestController
public class PropertiesController {

    @Value("${var1:def1}")
    private String var1;

    @Value("${var2:def2}")
    private String var2;

    @Value("${var3:def3}")
    private String var3;

    @Value("${var4:def4}")
    private String var4;

    @Value("${var5:def5}")
    private String var5;

    @Value("${var6:def6}")
    private String var6;

    @GetMapping
    public ResponseEntity<String> getVars() {
        String resp =
                        "var1: " + var1 + " <br>" +
                        "var2: " + var2 + " <br>" +
                        "var3: " + var3 + " <br>" +
                        "var4: " + var4 + " <br>" +
                        "var5: " + var5 + " <br>" +
                        "var6: " + var6 + " <br>";
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}

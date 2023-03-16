package com.techtask;

import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<String, String> env = System.getenv();
        String base = env.get("MY_SQL_DB");
        String pass = env.get("MY_SQL_PASS");
        System.out.println("base = " + base);
        System.out.println("pass = " + pass);
    }
}

package com.techtask.util;

import com.techtask.security.Encoder;

public class PassTest {
    public static void main(String[] args) {
        Encoder encoder = new Encoder();
        System.out.println("encoder.passwordEncoder().encode(\"01234567890\") = " + encoder.passwordEncoder().encode("01234567890"));
    }
}

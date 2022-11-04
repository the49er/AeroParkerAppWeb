package com.techtask.user.model;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@AllArgsConstructor
public enum Title {
    EMPTY("Choose your title"),
    MR("Mr"),
    MRS("Mrs"),
    MS("Ms"),
    OTHER("Other");
    private final String title;


    public String getTitleValue() {
        return title;
    }

    private static final List<Title> ALL_VALUES = new ArrayList<>();

    static {
        ALL_VALUES.addAll(Arrays.asList(values()));
    }

    public static List<Title> getAllValues() {
        return ALL_VALUES;
    }

}

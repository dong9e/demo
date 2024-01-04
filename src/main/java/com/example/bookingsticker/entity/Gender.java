package com.example.bookingsticker.entity;

import com.example.bookingsticker.common.StringConst;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

public enum Gender {
    MALE(StringConst.MALE, StringConst.ZERO),
    FEMALE(StringConst.FEMALE, StringConst.ONE),
    UNKNOWN(StringConst.UNKNOWN, StringConst.TWO);

    private String text;
    private String value;

    Gender(String text, String value){
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static Gender getGender(String value){
        if (StringUtils.isBlank(value))
            return null;

        switch (value){
            case StringConst.ZERO:
                return MALE;
            case StringConst.ONE:
                return FEMALE;
            case StringConst.TWO:
                return UNKNOWN;
            default:
                return null;
        }
    }
}

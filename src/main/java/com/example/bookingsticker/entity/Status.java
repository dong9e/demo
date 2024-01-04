package com.example.bookingsticker.entity;

import com.example.bookingsticker.common.StringConst;
import org.apache.commons.lang3.StringUtils;

public enum Status {
    ACTIVE(StringConst.ACTIVE, StringConst.ZERO),
    NON_ACTIVE(StringConst.NON_ACTIVE, StringConst.ONE),
    LOCK(StringConst.LOCK, StringConst.TWO);

    private String text;
    private String value;

    Status(String text, String value){
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

    public static Status getStatus(String value){
        if (StringUtils.isBlank(value))
            return null;

        switch (value){
            case StringConst.ZERO:
                return ACTIVE;
            case StringConst.ONE:
                return NON_ACTIVE;
            case StringConst.TWO:
                return LOCK;
            default:
                return null;
        }
    }
}

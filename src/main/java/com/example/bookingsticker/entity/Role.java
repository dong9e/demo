package com.example.bookingsticker.entity;

import com.example.bookingsticker.common.StringConst;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

public enum Role {

    ADMIN(StringConst.ADMIN, StringConst.ZERO),
    USER(StringConst.USER, StringConst.ONE);

    private String text;
    private String value;

    Role(String text, String value) {
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

    public static Role getRole(String value){
        if (StringUtils.isBlank(value))
            return null;

        switch (value){
            case StringConst.ZERO:
                return ADMIN;
            case StringConst.ONE:
                return USER;

            default:
                return null;
        }
    }
}

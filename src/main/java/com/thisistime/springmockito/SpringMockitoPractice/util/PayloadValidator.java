package com.thisistime.springmockito.SpringMockitoPractice.util;

import com.thisistime.springmockito.SpringMockitoPractice.model.ToDo;

public class PayloadValidator {
    public static boolean validateCreatePayload(ToDo payload) {

        if(payload.getId() > 0){
            return false;
        }

        return true;
    }
}

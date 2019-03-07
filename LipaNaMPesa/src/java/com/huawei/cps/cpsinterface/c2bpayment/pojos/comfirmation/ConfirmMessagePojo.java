/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.huawei.cps.cpsinterface.c2bpayment.pojos.comfirmation;

/**
 *
 * @author gaddafi
 */
public class ConfirmMessagePojo {
    private String message, max, min, min_allowed_ejaze_balance, short_code;

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMin_allowed_ejaze_balance() {
        return min_allowed_ejaze_balance;
    }

    public void setMin_allowed_ejaze_balance(String min_allowed_ejaze_balance) {
        this.min_allowed_ejaze_balance = min_allowed_ejaze_balance;
    }

    public String getShort_code() {
        return short_code;
    }

    public void setShort_code(String short_code) {
        this.short_code = short_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.indra.iopen.pojo;

import java.util.ArrayList;
import java.util.List;

public class YearBillingData {
    private Integer year;

    private List<MonthBillingData> monthBills;

    public YearBillingData() {
        super();
        this.monthBills = new ArrayList<MonthBillingData>();
    }

    public YearBillingData(final Integer year) {
        super();
        this.year = year;
        this.monthBills = new ArrayList<MonthBillingData>();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(final Integer year) {
        this.year = year;
    }

    public List<MonthBillingData> getMonthBills() {
        return monthBills;
    }

    public void setMonthBills(final List<MonthBillingData> monthBills) {
        this.monthBills = monthBills;
    }

    public void addMonthBill(final MonthBillingData monthData) {
        this.monthBills.add(monthData);
    }

}

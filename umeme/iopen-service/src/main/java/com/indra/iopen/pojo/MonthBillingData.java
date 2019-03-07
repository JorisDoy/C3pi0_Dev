package com.indra.iopen.pojo;

public class MonthBillingData {

    private String contractNumber;

    private Integer year;

    private Integer month;

    private Long invoiceAmount;

    private Long consumption;

    public MonthBillingData() {
        super();
    }

    public MonthBillingData(final String contractNumber, final Integer year, final Integer month,
            final Long invoiceAmount) {
        super();
        this.contractNumber = contractNumber;
        this.year = year;
        this.month = month;
        this.invoiceAmount = invoiceAmount;
    }

    public MonthBillingData(final String contractNumber, final Integer year, final Integer month, final Long invoiceAmount, final Long consumption) {
        super();
        this.contractNumber = contractNumber;
        this.year = year;
        this.month = month;
        this.invoiceAmount = invoiceAmount;
        this.consumption = consumption;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(final String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(final Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(final Integer month) {
        this.month = month;
    }

    public Long getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(final Long invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public Long getConsumption() {
        return consumption;
    }

    public void setConsumption(final Long consumption) {
        this.consumption = consumption;
    }

}

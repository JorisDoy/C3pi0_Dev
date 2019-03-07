package com.indra.iopen.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.indra.iopen.pojo.ContractBillingData;

@Component
public class GraphicalRepresentation {

    @NotNull
    private String contractNumber;

    @NotNull
    private String year;

    private List<ContractBillingData> contractBillingList;

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(final String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getYear() {
        return year;
    }

    public void setYear(final String year) {
        this.year = year;
    }

    public List<ContractBillingData> getContractBillingList() {
        if (contractBillingList == null) {
            this.contractBillingList = new ArrayList<ContractBillingData>();
        }
        return contractBillingList;
    }

    public void setContractBillingList(final List<ContractBillingData> contractBillingList) {
        this.contractBillingList = contractBillingList;
    }

}

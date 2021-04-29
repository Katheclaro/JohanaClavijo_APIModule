package com.globant.pojo;

import com.globant.BaseTest.FakerUtils;
import groovy.transform.builder.Builder;
import lombok.Getter;


/**
 * pojo with fields
 * Incluide a Faker to generate random data
 */
@Getter
@Builder
public class BankTransacctionPojo {

    private String id;
    private String AccountNumber = FakerUtils.getFaker().bothify("12####96");
    private String AccountType = FakerUtils.getFaker().letterify("Ana??s");
    private String StartDate = FakerUtils.getFaker().letterify("City???s");
    private String UserId = FakerUtils.getFaker().letterify("City???s");
    private String BankCode = FakerUtils.getFaker().bothify("01##05");
    private String BankName = FakerUtils.getFaker().letterify("City???s");
    private String BankBalance = FakerUtils.getFaker().bothify("114#45");
    private Boolean Status = true;
    private String NumberCard = FakerUtils.getFaker().bothify("12####96");
    private String TransactionType = FakerUtils.getFaker().letterify("Draw_????");
    private String Email = FakerUtils.getFaker().letterify("?????asafs@gmail.com");

    public BankTransacctionPojo(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getBankCode() {
        return BankCode;
    }

    public void setBankCode(String bankCode) {
        BankCode = bankCode;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getBankBalance() {
        return BankBalance;
    }

    public void setBankBalance(String bankBalance) {
        BankBalance = bankBalance;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public String getNumberCard() {
        return NumberCard;
    }

    public void setNumberCard(String numberCard) {
        NumberCard = numberCard;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}




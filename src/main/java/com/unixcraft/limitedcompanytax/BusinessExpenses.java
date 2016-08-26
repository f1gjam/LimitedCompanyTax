package com.unixcraft.limitedcompanytax;

import java.math.BigDecimal;

/**
 * Created by kali on 21/08/2016.
 */
public class BusinessExpenses {
    private BigDecimal car = BigDecimal.ZERO;
    private BigDecimal Internet = new BigDecimal("75");
    private BigDecimal office365 = new BigDecimal("18");
    private BigDecimal skype = new BigDecimal("8");
    private BigDecimal mobile1 = new BigDecimal("40");
    private BigDecimal mobile2 = new BigDecimal("25");
    private BigDecimal fuel = new BigDecimal("60");
    private BigDecimal subscriptions = new BigDecimal("20");
    private BigDecimal adobe = new BigDecimal("6");
    private BigDecimal liabilityInsurance = new BigDecimal("20");
    private BigDecimal ir35Insurance = new BigDecimal("25");
    private BigDecimal accountantsFee = new BigDecimal("100");
    private BigDecimal travelCost = new BigDecimal("180");

    public BigDecimal getCar() {
        return car;
    }

    public void setCar(BigDecimal car) {
        this.car = car;
    }

    public BigDecimal getInternet() {
        return Internet;
    }

    public void setInternet(BigDecimal internet) {
        Internet = internet;
    }

    public BigDecimal getOffice365() {
        return office365;
    }

    public void setOffice365(BigDecimal office365) {
        this.office365 = office365;
    }

    public BigDecimal getSkype() {
        return skype;
    }

    public void setSkype(BigDecimal skype) {
        this.skype = skype;
    }

    public BigDecimal getMobile1() {
        return mobile1;
    }

    public void setMobile1(BigDecimal mobile1) {
        this.mobile1 = mobile1;
    }

    public BigDecimal getMobile2() {
        return mobile2;
    }

    public void setMobile2(BigDecimal mobile2) {
        this.mobile2 = mobile2;
    }

    public BigDecimal getFuel() {
        return fuel;
    }

    public void setFuel(BigDecimal fuel) {
        this.fuel = fuel;
    }

    public BigDecimal getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(BigDecimal subscriptions) {
        this.subscriptions = subscriptions;
    }

    public BigDecimal getAdobe() {
        return adobe;
    }

    public void setAdobe(BigDecimal adobe) {
        this.adobe = adobe;
    }

    public BigDecimal getLiabilityInsurance() {
        return liabilityInsurance;
    }

    public void setLiabilityInsurance(BigDecimal liabilityInsurance) {
        this.liabilityInsurance = liabilityInsurance;
    }

    public BigDecimal getIr35Insurance() {
        return ir35Insurance;
    }

    public void setIr35Insurance(BigDecimal ir35Insurance) {
        this.ir35Insurance = ir35Insurance;
    }

    public BigDecimal getAccountantsFee() {
        return accountantsFee;
    }

    public void setAccountantsFee(BigDecimal accountantsFee) {
        this.accountantsFee = accountantsFee;
    }

    public BigDecimal getTravelCost() {
        return travelCost;
    }

    public void setTravelCost(BigDecimal travelCost) {
        this.travelCost = travelCost;
    }
}
